<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车辆类型" prop="carType">
        <el-select v-model="queryParams.carType" placeholder="请选择车辆类型" clearable size="small">
          <el-option v-for="item in driverTypeOptions"
                     :key="item.driveTypeId"
                     :label="item.driverName"
                     :value="item.driveTypeId"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="车牌号" prop="carNum">
        <el-input
          v-model="queryParams.carNum"
          placeholder="请输入车牌号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['jiaktb:carinfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['jiaktb:carinfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['jiaktb:carinfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['jiaktb:carinfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="carinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="车辆标识" align="center" prop="carInfoId" />
      <el-table-column label="车辆类型" align="center" prop="driveTypeList.driverCode" />
      <el-table-column label="车牌号" align="center" prop="carNum" />
      <el-table-column label="状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="所属教练" align="center" prop="coachInfoList.chName" />
      <el-table-column label="购入价格" align="center" prop="carValue" />
      <el-table-column label="用车总人数" align="center" prop="num" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['jiaktb:carinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['jiaktb:carinfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改车辆信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车辆类型" prop="carType">
          <el-select v-model="form.carType" placeholder="请选择车辆类型" clearable size="small">
            <el-option v-for="item in driverTypeOptions"
                       :key="item.driveTypeId"
                       :label="item.driverName"
                       :value="item.driveTypeId"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="车牌号" prop="carNum">
          <el-input v-model="form.carNum" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="录入时间" prop="impDate">
          <el-date-picker clearable size="small"
                          v-model="form.impDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择录入时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in statusOptions"
              :key="dict.dictValue"
              :label="parseInt(dict.dictValue)"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="所属教练" prop="coachInfoId">
          <el-select v-model="form.coachInfoId" placeholder="请选择教练" clearable size="small">
            <el-option v-for="item in coachOptions"
                       :label="item.chName"
                       :value="item.coachInfoId"
                       :key="item.coachInfoId"/>
          </el-select>
        </el-form-item>
        <el-form-item label="购入价格" prop="carValue">
          <el-input v-model="form.carValue" placeholder="请输入购入价格" />
        </el-form-item>
        <el-form-item label="用车总人数" prop="num">
          <el-input v-model="form.num" placeholder="请输入用车总人数" />
        </el-form-item>

        <el-divider content-position="center">图片信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddPhotos">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeletePhotos">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="photosList" :row-class-name="rowPhotosIndex" @selection-change="handlePhotosSelectionChange" ref="photos">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="图片标题" prop="photosTitle">
            <template slot-scope="scope">
              <el-input v-model="scope.row.photosTitle" placeholder="请输入图片标题" />
            </template>
          </el-table-column>
          <el-table-column label="图片" prop="photosUri">
            <template slot-scope="scope">
              <imageUpload v-model="scope.row.photosUri"/>
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCarinfo, getCarinfo, delCarinfo, addCarinfo, updateCarinfo, exportCarinfo } from "@/api/jiaktb/carinfo";
import { listType } from "@/api/jiaktb/type";
import { listCoachinfo} from "@/api/jiaktb/coachinfo";
import ImageUpload from '@/components/ImageUpload';
import {getToken} from "@/utils/auth";

export default {
  name: "Carinfo",
  components: {
    ImageUpload
  },
  data() {
    return {
      uploadImgUrl: process.env.VUE_APP_BASE_API + "/common/upload", // 上传的图片服务器地址
      headers: {
        Authorization: "Bearer " + getToken(),
      },
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 车辆信息表格数据
      carinfoList: [],
      // 图片信息表格数据
      photosList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态字典
      statusOptions: [],
      coachOptions: [],
      driverTypeOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        carType: null,
        carNum: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("car_status").then(response => {
      this.statusOptions = response.data;
    });
    listType().then(response => {
      this.driverTypeOptions = response.rows;
    });
    listCoachinfo().then(response => {
      this.coachOptions = response.rows;
    });
  },
  methods: {
    /** 查询车辆信息列表 */
    getList() {
      this.loading = true;
      listCarinfo(this.queryParams).then(response => {
        this.carinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        carInfoId: null,
        carType: null,
        carNum: null,
        impDate: null,
        expDate: null,
        status: 0,
        coachInfoId: null,
        statusDate: null,
        carValue: null,
        num: null
      };
      this.photosList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.carInfoId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加车辆信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const carInfoId = row.carInfoId || this.ids
      getCarinfo(carInfoId).then(response => {
        this.form = response.data;
        console.log(this.form);
        this.photosList = response.data.photosList;
        this.open = true;
        this.title = "修改车辆信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.photosList = this.photosList;
          if (this.form.carInfoId != null) {
            updateCarinfo(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCarinfo(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const carInfoIds = row.carInfoId || this.ids;
      this.$confirm('是否确认删除车辆信息编号为"' + carInfoIds + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delCarinfo(carInfoIds);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有车辆信息数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportCarinfo(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    },
    /** 图片信息序号 */
    rowPhotosIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 图片信息添加按钮操作 */
    handleAddPhotos() {
      let obj = {};
      obj.photosTitle = "";
      obj.photosUri = "";
      obj.upTime = "";
      this.photosList.push(obj);
    },
    /** 图片信息删除按钮操作 */
    handleDeletePhotos() {
      if (this.checkedPhotos.length == 0) {
        this.$alert("请先选择要删除的图片信息数据", "提示", { confirmButtonText: "确定", });
      } else {
        this.photosList.splice(this.checkedPhotos[0].index - 1, 1);
      }
    },
    /** 单选框选中数据 */
    handlePhotosSelectionChange(selection) {
      if (selection.length > 1) {
        this.$refs.photos.clearSelection();
        this.$refs.photos.toggleRowSelection(selection.pop());
      } else {
        this.checkedPhotos = selection;
      }
    },
  }
};
</script>
