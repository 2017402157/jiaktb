<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教练姓名" prop="chName">
        <el-input
          v-model="queryParams.chName"
          placeholder="请输入教练姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择使用状态" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="电话号码" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入电话号码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属驾校" prop="deptId">
        <el-input
          v-model="queryParams.deptId"
          placeholder="请输入所属驾校"
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
          v-hasPermi="['jiaktb:coachinfo:add']"
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
          v-hasPermi="['jiaktb:coachinfo:edit']"
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
          v-hasPermi="['jiaktb:coachinfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['jiaktb:coachinfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="coachinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="教练标识" align="center" prop="coachInfoId" />
      <el-table-column label="教练姓名" align="center" prop="chName" />
      <el-table-column label="教练年龄" align="center" prop="chAge" />
      <el-table-column label="教练性别" align="center" prop="chSex" :formatter="chSexFormat" />
      <el-table-column label="使用状态" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="准驾车型" align="center" prop="chCarType" />
      <el-table-column label="电话号码" align="center" prop="phone" />
      <el-table-column label="薪水" align="center" prop="salary" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['jiaktb:coachinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['jiaktb:coachinfo:remove']"
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

    <!-- 添加或修改教练信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="教练姓名" prop="chName">
          <el-input v-model="form.chName" placeholder="请输入教练姓名" />
        </el-form-item>
        <el-form-item label="教练年龄" prop="chAge">
          <el-input v-model="form.chAge" placeholder="请输入教练年龄" />
        </el-form-item>
        <el-form-item label="教练性别" prop="chSex">
          <el-select v-model="form.chSex" placeholder="请选择教练性别">
            <el-option
              v-for="dict in chSexOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="parseInt(dict.dictValue)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="评分" prop="chEvaluate">
          <el-input v-model="form.chEvaluate" placeholder="请输入评分" />
        </el-form-item>
        <el-form-item label="使用状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in statusOptions"
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
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话号码" />
        </el-form-item>
        <el-form-item label="薪水" prop="salary">
          <el-input v-model="form.salary" placeholder="请输入薪水" />
        </el-form-item>
        <el-form-item label="入职时间" prop="impDate">
          <el-date-picker clearable size="small"
                          v-model="form.impDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择入职时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="身份证号码" prop="cardId">
          <el-input v-model="form.cardId" placeholder="请输入身份证号码" />
        </el-form-item>
        <el-form-item label="所属驾校" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入所属驾校" />
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
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
import { listCoachinfo, getCoachinfo, delCoachinfo, addCoachinfo, updateCoachinfo, exportCoachinfo } from "@/api/jiaktb/coachinfo";

export default {
  name: "Coachinfo",
  components: {
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
      // 教练信息表格数据
      coachinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 教练性别字典
      chSexOptions: [],
      // 使用状态字典
      statusOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        chName: null,
        status: null,
        phone: null,
        deptId: null,
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
      this.chSexOptions = response.data;
    });
    this.getDicts("coach_status").then(response => {
      this.statusOptions = response.data;
    });
  },
  methods: {
    /** 查询教练信息列表 */
    getList() {
      this.loading = true;
      listCoachinfo(this.queryParams).then(response => {
        this.coachinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 教练性别字典翻译
    chSexFormat(row, column) {
      return this.selectDictLabel(this.chSexOptions, row.chSex);
    },
    // 使用状态字典翻译
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
        coachInfoId: null,
        chName: null,
        chAge: null,
        chSex: null,
        chEvaluate: null,
        status: 0,
        statusDate: null,
        chCarType: null,
        phone: null,
        salary: null,
        impDate: null,
        expDate: null,
        cardId: null,
        deptId: null,
        userId: null
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
      this.ids = selection.map(item => item.coachInfoId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教练信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const coachInfoId = row.coachInfoId || this.ids
      getCoachinfo(coachInfoId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改教练信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.coachInfoId != null) {
            updateCoachinfo(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCoachinfo(this.form).then(response => {
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
      const coachInfoIds = row.coachInfoId || this.ids;
      this.$confirm('是否确认删除教练信息编号为"' + coachInfoIds + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return delCoachinfo(coachInfoIds);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有教练信息数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function() {
        return exportCoachinfo(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
};
</script>
