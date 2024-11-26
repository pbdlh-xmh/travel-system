<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="线路名称" prop="routeName">
        <el-input
          v-model="queryParams.routeName"
          placeholder="请输入线路名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行程天数" prop="duration">
        <el-input
          v-model="queryParams.duration"
          placeholder="请输入行程天数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发地" prop="departurePlace">
        <el-input
          v-model="queryParams.departurePlace"
          placeholder="请输入出发地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目的地" prop="destination">
        <el-input
          v-model="queryParams.destination"
          placeholder="请输入目的地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最低预算" prop="minBudget">
        <el-input
          v-model="queryParams.minBudget"
          placeholder="请输入最低预算"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高预算" prop="maxBudget">
        <el-input
          v-model="queryParams.maxBudget"
          placeholder="请输入最高预算"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最大团体人数" prop="maxGroupSize">
        <el-input
          v-model="queryParams.maxGroupSize"
          placeholder="请输入最大团体人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
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
          v-hasPermi="['lytj:route:add']"
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
          v-hasPermi="['lytj:route:edit']"
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
          v-hasPermi="['lytj:route:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lytj:route:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="routeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="线路ID" align="center" prop="routeId" />
      <el-table-column label="线路名称" align="center" prop="routeName" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="行程天数" align="center" prop="duration" />
      <el-table-column label="出发地" align="center" prop="departurePlace" />
      <el-table-column label="目的地" align="center" prop="destination" />
      <el-table-column label="线路标签" align="center" prop="tags">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.user_interest_tags" :value="scope.row.tags ? scope.row.tags.split(',') : []"/>
        </template>
      </el-table-column>
      <el-table-column label="浏览量" align="center" prop="viewCount" />
      <el-table-column label="收藏次数" align="center" prop="favoritesCount" />
      <el-table-column label="评论数" align="center" prop="commentsCount" />
      <el-table-column label="预定次数" align="center" prop="bookingsCount" />
      <el-table-column label="最低预算" align="center" prop="minBudget" />
      <el-table-column label="最高预算" align="center" prop="maxBudget" />
      <el-table-column label="最大团体人数" align="center" prop="maxGroupSize" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lytj:route:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lytj:route:remove']"
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

    <!-- 添加或修改旅游线路管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="线路名称" prop="routeName">
          <el-input v-model="form.routeName" placeholder="请输入线路名称" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="线路描述">
          <editor v-model="form.description" :min-height="192"/>
        </el-form-item>
        <el-form-item label="行程天数" prop="duration">
          <el-input v-model="form.duration" placeholder="请输入行程天数" />
        </el-form-item>
        <el-form-item label="出发地" prop="departurePlace">
          <el-input v-model="form.departurePlace" placeholder="请输入出发地" />
        </el-form-item>
        <el-form-item label="目的地" prop="destination">
          <el-input v-model="form.destination" placeholder="请输入目的地" />
        </el-form-item>
        <el-form-item label="线路主图片URL" prop="imageUrl">
          <file-upload v-model="form.imageUrl"/>
        </el-form-item>
        <el-form-item label="线路多图路径" prop="images">
          <file-upload v-model="form.images"/>
        </el-form-item>
        <el-form-item label="线路标签" prop="tags">
          <el-checkbox-group v-model="form.tags">
            <el-checkbox
              v-for="dict in dict.type.user_interest_tags"
              :key="dict.value"
              :label="dict.value">
              {{dict.label}}
            </el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="浏览量" prop="viewCount">
          <el-input v-model="form.viewCount" placeholder="请输入浏览量" />
        </el-form-item>
        <el-form-item label="收藏次数" prop="favoritesCount">
          <el-input v-model="form.favoritesCount" placeholder="请输入收藏次数" />
        </el-form-item>
        <el-form-item label="评论数" prop="commentsCount">
          <el-input v-model="form.commentsCount" placeholder="请输入评论数" />
        </el-form-item>
        <el-form-item label="预定次数" prop="bookingsCount">
          <el-input v-model="form.bookingsCount" placeholder="请输入预定次数" />
        </el-form-item>
        <el-form-item label="最低预算" prop="minBudget">
          <el-input v-model="form.minBudget" placeholder="请输入最低预算" />
        </el-form-item>
        <el-form-item label="最高预算" prop="maxBudget">
          <el-input v-model="form.maxBudget" placeholder="请输入最高预算" />
        </el-form-item>
        <el-form-item label="最大团体人数" prop="maxGroupSize">
          <el-input v-model="form.maxGroupSize" placeholder="请输入最大团体人数" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
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
import { listRoute, getRoute, delRoute, addRoute, updateRoute } from "@/api/lytj/route";

export default {
  name: "Route",
  dicts: ['user_interest_tags', 'sys_normal_disable'],
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
      // 旅游线路管理表格数据
      routeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        routeName: null,
        price: null,
        duration: null,
        departurePlace: null,
        destination: null,
        tags: null,
        minBudget: null,
        maxBudget: null,
        maxGroupSize: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        routeName: [
          { required: true, message: "线路名称不能为空", trigger: "blur" }
        ],
        departurePlace: [
          { required: true, message: "出发地不能为空", trigger: "blur" }
        ],
        destination: [
          { required: true, message: "目的地不能为空", trigger: "blur" }
        ],
        tags: [
          { required: true, message: "线路标签不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询旅游线路管理列表 */
    getList() {
      this.loading = true;
      listRoute(this.queryParams).then(response => {
        this.routeList = response.rows;
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
        routeId: null,
        routeName: null,
        price: null,
        description: null,
        duration: null,
        departurePlace: null,
        destination: null,
        imageUrl: null,
        images: null,
        tags: [],
        viewCount: null,
        favoritesCount: null,
        commentsCount: null,
        bookingsCount: null,
        minBudget: null,
        maxBudget: null,
        maxGroupSize: null,
        createTime: null,
        updateTime: null,
        status: null
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
      this.ids = selection.map(item => item.routeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加旅游线路管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const routeId = row.routeId || this.ids
      getRoute(routeId).then(response => {
        this.form = response.data;
        this.form.tags = this.form.tags.split(",");
        this.open = true;
        this.title = "修改旅游线路管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.tags = this.form.tags.join(",");
          if (this.form.routeId != null) {
            updateRoute(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRoute(this.form).then(response => {
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
      const routeIds = row.routeId || this.ids;
      this.$modal.confirm('是否确认删除旅游线路管理编号为"' + routeIds + '"的数据项？').then(function() {
        return delRoute(routeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lytj/route/export', {
        ...this.queryParams
      }, `route_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
