<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学员姓名" prop="stuName">
        <el-input
          v-model="queryParams.stuName"
          placeholder="请输入学员姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="statusCd">
        <el-select v-model="queryParams.statusCd" placeholder="请选择状态" clearable size="small">
          <el-option
            v-for="dict in statusCdOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="教员编号" prop="coachInfoId">
        <el-input
          v-model="queryParams.coachInfoId"
          placeholder="请输入教员编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属团体" prop="groupUserId">
        <el-input
          v-model="queryParams.groupUserId"
          placeholder="请输入所属团体"
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
          v-hasPermi="['jiaktb:stuinfo:add']"
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
          v-hasPermi="['jiaktb:stuinfo:edit']"
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
          v-hasPermi="['jiaktb:stuinfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['jiaktb:stuinfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stuinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学员姓名" align="center" prop="stuName" />
      <el-table-column label="性别" align="center" prop="sex" :formatter="sexFormat" />
      <el-table-column label="申请车型" align="center" prop="appCarType" />
      <el-table-column label="地址" align="center" prop="addr" />
      <el-table-column label="状态" align="center" prop="statusCd" :formatter="statusCdFormat" />
      <el-table-column label="报名时间" align="center" prop="impDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.impDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="教员编号" align="center" prop="coachInfoId" />
      <el-table-column label="所属团体" align="center" prop="groupUserId" />
      <el-table-column label="申请状态" align="center" prop="appStatus" :formatter="appStatusFormat" />
      <el-table-column label="处理时间" align="center" prop="appStatusTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.appStatusTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['jiaktb:stuinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['jiaktb:stuinfo:remove']"
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

    <!-- 添加或修改学员信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学员姓名" prop="stuName">
          <el-input v-model="form.stuName" placeholder="请输入学员姓名" />
        </el-form-item>
        <el-form-item label="身份证号码" prop="cardId">
          <el-input v-model="form.cardId" placeholder="请输入身份证号码" />
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="form.sex">
            <el-radio
              v-for="dict in sexOptions"
              :key="dict.dictValue"
              :label="parseInt(dict.dictValue)"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="准驾车型" prop="chCarType">
          <el-select v-model="form.chCarType" placeholder="请选择准驾车型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="申请车型" prop="appCarType">
          <el-select v-model="form.appCarType" placeholder="请选择申请车型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="右眼视力" prop="rigthEye">
          <el-input v-model="form.rigthEye" placeholder="请输入右眼视力" />
        </el-form-item>
        <el-form-item label="左眼视力" prop="leftEye">
          <el-input v-model="form.leftEye" placeholder="请输入左眼视力" />
        </el-form-item>
        <el-form-item label="地址" prop="addr">
          <el-input v-model="form.addr" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="照片">
          <imageUpload v-model="form.phone"/>
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.statusCd">
            <el-radio
              v-for="dict in statusCdOptions"
              :key="dict.dictValue"
              :label="parseInt(dict.dictValue)"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="报名时间" prop="impDate">
          <el-date-picker clearable size="small"
                          v-model="form.impDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择报名时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="毕业时间" prop="expDate">
          <el-date-picker clearable size="small"
                          v-model="form.expDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择毕业时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="教员编号" prop="coachInfoId">
          <el-input v-model="form.coachInfoId" placeholder="请输入教员编号" />
        </el-form-item>
        <el-form-item label="所属驾校" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入所属驾校" />
        </el-form-item>
        <el-form-item label="是否是本地户口(1000是，1100否)" prop="isLocal">
          <el-input v-model="form.isLocal" placeholder="请输入是否是本地户口(1000是，1100否)" />
        </el-form-item>
        <el-form-item label="暂住证">
          <imageUpload v-model="form.prove"/>
        </el-form-item>
        <el-form-item label="身份证正面">
          <imageUpload v-model="form.zCard"/>
        </el-form-item>
        <el-form-item label="身份证反面">
          <imageUpload v-model="form.fCard"/>
        </el-form-item>
        <el-form-item label="所属团体" prop="groupUserId">
          <el-input v-model="form.groupUserId" placeholder="请输入所属团体" />
        </el-form-item>
        <el-form-item label="申请状态">
          <el-radio-group v-model="form.appStatus">
            <el-radio
              v-for="dict in appStatusOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="处理时间" prop="appStatusTime">
          <el-date-picker clearable size="small"
                          v-model="form.appStatusTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择处理时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStuinfo, getStuinfo, delStuinfo, addStuinfo, updateStuinfo, exportStuinfo } from "@/api/jiaktb/stuinfo";
import ImageUpload from '@/components/ImageUpload';

export default {
  name: "Stuinfo",
  components: {
    ImageUpload,
  },
  data() {
    return {
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
      // 学员信息表格数据
      stuinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 性别字典
      sexOptions: [],
      // 状态字典
      statusCdOptions: [],
      // 申请状态字典
      appStatusOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stuName: null,
        statusCd: null,
        coachInfoId: null,
        groupUserId: null,
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
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
    this.getDicts("car_info_status").then(response => {
      this.statusCdOptions = response.data;
    });
    this.getDicts("sys_apple").then(response => {
      this.appStatusOptions = response.data;
    });
  },
  methods: {
    /** 查询学员信息列表 */
    getList() {
      this.loading = true;
      listStuinfo(this.queryParams).then(response => {
        this.stuinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 性别字典翻译
    sexFormat(row, column) {
      return this.selectDictLabel(this.sexOptions, row.sex);
    },
    // 状态字典翻译
    statusCdFormat(row, column) {
      return this.selectDictLabel(this.statusCdOptions, row.statusCd);
    },
    // 申请状态字典翻译
    appStatusFormat(row, column) {
      return this.selectDictLabel(this.appStatusOptions, row.appStatus);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        stuInfoId: null,
        stuName: null,
        cardId: null,
        sex: 0,
        chCarType: null,
        appCarType: null,
        rigthEye: null,
        leftEye: null,
        addr: null,
        phone: null,
        statusCd: 0,
        impDate: null,
        expDate: null,
        coachInfoId: null,
        deptId: null,
        isLocal: null,
        prove: null,
        zCard: null,
        fCard: null,
        groupUserId: null,
        appStatus: "0",
        appStatusTime: null
      };
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
      this.ids = selection.map(item => item.stuInfoId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学员信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const stuInfoId = row.stuInfoId || this.ids
      getStuinfo(stuInfoId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学员信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.stuInfoId != null) {
            updateStuinfo(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStuinfo(this.form).then(response => {
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
      const stuInfoIds = row.stuInfoId || this.ids;
      this.$confirm('是否确认删除学员信息编号为"' + stuInfoIds + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delStuinfo(stuInfoIds);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有学员信息数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportStuinfo(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
