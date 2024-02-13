<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="${comment}" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="motherboard">
        <el-input
          v-model="queryParams.motherboard"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="cpu">
        <el-input
          v-model="queryParams.cpu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="memory">
        <el-input
          v-model="queryParams.memory"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="powerSupply">
        <el-input
          v-model="queryParams.powerSupply"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="graphicsCard">
        <el-input
          v-model="queryParams.graphicsCard"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="hardDrive">
        <el-input
          v-model="queryParams.hardDrive"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="box">
        <el-input
          v-model="queryParams.box"
          placeholder="请输入${comment}"
          clearable
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
          v-hasPermi="['store:scheme:add']"
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
          v-hasPermi="['store:scheme:edit']"
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
          v-hasPermi="['store:scheme:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['store:scheme:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="schemeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="schemeId" />
      <el-table-column label="${comment}" align="center" prop="userName" />
      <el-table-column label="${comment}" align="center" prop="name" />
      <el-table-column label="${comment}" align="center" prop="motherboard" />
      <el-table-column label="${comment}" align="center" prop="cpu" />
      <el-table-column label="${comment}" align="center" prop="memory" />
      <el-table-column label="${comment}" align="center" prop="powerSupply" />
      <el-table-column label="${comment}" align="center" prop="graphicsCard" />
      <el-table-column label="${comment}" align="center" prop="hardDrive" />
      <el-table-column label="${comment}" align="center" prop="box" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['store:scheme:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['store:scheme:remove']"
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

    <!-- 添加或修改装机方案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="name">
          <el-input v-model="form.name" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="motherboard">
          <el-input v-model="form.motherboard" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="cpu">
          <el-input v-model="form.cpu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="memory">
          <el-input v-model="form.memory" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="powerSupply">
          <el-input v-model="form.powerSupply" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="graphicsCard">
          <el-input v-model="form.graphicsCard" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="hardDrive">
          <el-input v-model="form.hardDrive" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="box">
          <el-input v-model="form.box" placeholder="请输入${comment}" />
        </el-form-item>
        <el-divider content-position="center">${subTable.functionName}信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddTbSchemeReview">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteTbSchemeReview">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="tbSchemeReviewList" :row-class-name="rowTbSchemeReviewIndex" @selection-change="handleTbSchemeReviewSelectionChange" ref="tbSchemeReview">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="$comment" prop="customerId" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.customerId" placeholder="请输入$comment" />
            </template>
          </el-table-column>
          <el-table-column label="$comment" prop="rating" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.rating" placeholder="请输入$comment" />
            </template>
          </el-table-column>
          <el-table-column label="$comment" prop="reviewDate" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.reviewDate" type="date" value-format="yyyy-MM-dd" placeholder="请选择$comment" />
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
import { listScheme, getScheme, delScheme, addScheme, updateScheme } from "@/api/store/scheme";

export default {
  name: "Scheme",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedTbSchemeReview: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 装机方案表格数据
      schemeList: [],
      // ${subTable.functionName}表格数据
      tbSchemeReviewList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        name: null,
        motherboard: null,
        cpu: null,
        memory: null,
        powerSupply: null,
        graphicsCard: null,
        hardDrive: null,
        box: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询装机方案列表 */
    getList() {
      this.loading = true;
      listScheme(this.queryParams).then(response => {
        this.schemeList = response.rows;
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
        schemeId: null,
        userName: null,
        name: null,
        motherboard: null,
        cpu: null,
        memory: null,
        powerSupply: null,
        graphicsCard: null,
        hardDrive: null,
        box: null
      };
      this.tbSchemeReviewList = [];
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
      this.ids = selection.map(item => item.schemeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加装机方案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const schemeId = row.schemeId || this.ids
      getScheme(schemeId).then(response => {
        this.form = response.data;
        this.tbSchemeReviewList = response.data.tbSchemeReviewList;
        this.open = true;
        this.title = "修改装机方案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.tbSchemeReviewList = this.tbSchemeReviewList;
          if (this.form.schemeId != null) {
            updateScheme(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addScheme(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const schemeIds = row.schemeId || this.ids;
      this.$modal.confirm('是否确认删除装机方案编号为"' + schemeIds + '"的数据项？').then(function() {
        return delScheme(schemeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** ${subTable.functionName}序号 */
    rowTbSchemeReviewIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** ${subTable.functionName}添加按钮操作 */
    handleAddTbSchemeReview() {
      let obj = {};
      obj.customerId = "";
      obj.content = "";
      obj.rating = "";
      obj.reviewDate = "";
      this.tbSchemeReviewList.push(obj);
    },
    /** ${subTable.functionName}删除按钮操作 */
    handleDeleteTbSchemeReview() {
      if (this.checkedTbSchemeReview.length == 0) {
        this.$modal.msgError("请先选择要删除的${subTable.functionName}数据");
      } else {
        const tbSchemeReviewList = this.tbSchemeReviewList;
        const checkedTbSchemeReview = this.checkedTbSchemeReview;
        this.tbSchemeReviewList = tbSchemeReviewList.filter(function(item) {
          return checkedTbSchemeReview.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleTbSchemeReviewSelectionChange(selection) {
      this.checkedTbSchemeReview = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('store/scheme/export', {
        ...this.queryParams
      }, `scheme_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
