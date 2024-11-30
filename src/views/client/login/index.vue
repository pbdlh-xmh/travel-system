<template>
  <div class="client-login">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
      <h3 class="title">旅游管理系统</h3>
      
      <!-- 支持用户名/邮箱/手机号登录 -->
      <el-form-item prop="account">
        <el-input
          v-model="loginForm.account"
          type="text"
          auto-complete="off"
          placeholder="账号/邮箱/手机号"
        >
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      
      <el-form-item prop="password">
        <el-input
          v-model="loginForm.password"
          type="password"
          auto-complete="off"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      
      <el-form-item style="width:100%;">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div class="register-link">
          <router-link class="link-type" :to="'/client/register'">
            立即注册
          </router-link>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'ClientLogin',
  data() {
    // 验证账号
    const validateAccount = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入账号/邮箱/手机号'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        account: '', // 统一使用account字段，后端判断是用户名/邮箱/手机号
        password: ''
      },
      loginRules: {
        account: [
          { required: true, trigger: 'blur', validator: validateAccount }
        ],
        password: [
          { required: true, trigger: 'blur', message: '请输入密码' },
          { min: 6, max: 20, message: '密码长度在 6 到 20 个字符', trigger: 'blur' }
        ]
      },
      loading: false,
      redirect: undefined
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  methods: {
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          this.$store.dispatch('client/Login', this.loginForm)
            .then(() => {
              this.$router.push({ path: this.redirect || '/client' })
              this.loading = false
            })
            .catch(() => {
              this.loading = false
            })
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.client-login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f2f5;
  
  .login-form {
    width: 400px;
    padding: 25px 25px 5px 25px;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 6px;
    box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
    
    .title {
      margin: 0 auto 30px;
      text-align: center;
      color: #333;
      font-size: 24px;
      font-weight: 500;
    }
    
    .el-input {
      height: 40px;
      input {
        height: 40px;
        padding-left: 30px;
      }
    }
    
    .input-icon {
      height: 40px;
      width: 14px;
      margin-left: 6px;
    }

    .register-link {
      float: right;
      margin-top: 10px;
    }
  }
  
  .link-type {
    color: #409EFF;
    text-decoration: none;
    font-size: 14px;
    &:hover {
      color: #66b1ff;
    }
  }
}
</style> 