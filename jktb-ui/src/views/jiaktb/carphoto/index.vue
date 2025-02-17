<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="图片标题" prop="carInfoId">
        <el-input
          v-model="queryParams.carInfoId"
          placeholder="请输入图片标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['jiaktb:carphoto:add']"
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
          v-hasPermi="['jiaktb:carphoto:edit']"
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
          v-hasPermi="['jiaktb:carphoto:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['jiaktb:carphoto:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="carphotoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="图片标识" align="center" prop="carPhotoId" />
      <el-table-column label="图片标题" align="center" prop="carInfoId" />
      <el-table-column label="图片路径" align="center" prop="photosId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['jiaktb:carphoto:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['jiaktb:carphoto:remove']"
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

    <!-- 添加或修改车辆图片对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="图片标题" prop="carInfoId">
          <el-input v-model="form.carInfoId" placeholder="请输入图片标题" />
        </el-form-item>
        <el-form-item label="图片路径" prop="photosId">
          <el-input v-model="form.photosId" placeholder="请输入图片路径" />
        </el-form-item>
        <el-divider content-position="center">图片信息信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddPhotos">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeletePhotos">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="0" :row-class-name="rowPhotosIndex" @selection-change="handlePhotosSelectionChange" ref="photos">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="图片标题" prop="photosTitle">
            <template slot-scope="scope">
              <el-input v-model="scope.row.photosTitle" placeholder="请输入图片标题" />
            </template>
          </el-table-column>
          <el-table-column label="图片路径" prop="photosUri">
            <template slot-scope="scope">
              <imageUpload v-model="scope.row.photosUri"/>
            </template>
          </el-table-column>
          <el-table-column label="上传时间" prop="upTime">
            <template slot-scope="scope">
              <el-date-picker clearable size="small"
                              v-model="scope.row.upTime"
                              type="date"
                              value-format="yyyy-MM-dd"
                              placeholder="选择上传时间">
              </el-date-picker>
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
import { listCarphoto, getCarphoto, delCarphoto, addCarphoto, updateCarphoto, exportCarphoto } from "@/api/jiaktb/carphoto";
import {getToken} from "@/utils/auth";
import ImageUpload from '@/components/ImageUpload';

export default {
  name: "Carphoto",
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
      // 子表选中数据
      checkedPhotos: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 车辆图片表格数据
      carphotoList: [],
      // 图片信息表格数据
      photosList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        carInfoId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        carInfoId: [
          { required: true, message: "图片标题不能为空", trigger: "blur" }
        ],
        photosId: [
          { required: true, message: "图片路径不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询车辆图片列表 */
    getList() {
      this.loading = true;
      listCarphoto(this.queryParams).then(response => {
        this.carphotoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        carPhotoId: null,
        carInfoId: null,
        photosId: null
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
      this.ids = selection.map(item => item.carPhotoId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加车辆图片";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const carPhotoId = row.carPhotoId || this.ids
      getCarphoto(carPhotoId).then(response => {
        this.form = response.data;
        this.photosList = response.data.photosList;
        this.open = true;
        this.title = "修改车辆图片";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.photosList = this.photosList;
          if (this.form.carPhotoId != null) {
            updateCarphoto(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCarphoto(this.form).then(response => {
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
      const carPhotoIds = row.carPhotoId || this.ids;
      this.$confirm('是否确认删除车辆图片编号为"' + carPhotoIds + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delCarphoto(carPhotoIds);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
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
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有车辆图片数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportCarphoto(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
