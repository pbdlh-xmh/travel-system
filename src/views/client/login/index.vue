<template>
  <div class="login-container">
    <div class="login-form">
      <h2>旅游推荐系统</h2>
      <el-form :model="loginForm" :rules="loginRules" ref="loginFormRef">
        <el-form-item prop="account">
          <el-input v-model.trim="loginForm.account" placeholder="账号/邮箱/手机号">
            <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" v-model.trim="loginForm.password" placeholder="密码">
            <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
          </el-input>
        </el-form-item>
        <el-form-item prop="code" class="code-item">
          <div class="code-input-container">
            <el-input 
              v-model.trim="loginForm.code" 
              placeholder="验证码" 
              @keyup.enter.native="handleLogin"
            >
              <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
            </el-input>
            <img 
              :src="codeUrl" 
              @click="getCode" 
              class="login-code-img"
              alt="验证码"
            />
          </div>
        </el-form-item>
        <el-form-item>
          <el-button :loading="loading" type="primary" style="width:100%" @click.native.prevent="handleLogin">
            <span v-if="!loading">登 录</span>
            <span v-else>登 录 中...</span>
          </el-button>
          <div class="register-link">
            <router-link class="link-type" to="/client/register">立即注册</router-link>
          </div>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { getCodeImg } from '@/api/login'
import { clientLogin } from '@/api/client/auth'
import { setClientToken } from '@/utils/clientAuth'

export default {
  name: 'ClientLogin',
  data() {
    return {
      loginForm: {
        account: '',
        password: '',
        code: '',
        uuid: ''
      },
      loginRules: {
        account: [{ required: true, trigger: 'blur', message: '请输入账号/邮箱/手机号' }],
        password: [{ required: true, trigger: 'blur', message: '请输入密码' }],
        code: [{ required: true, trigger: 'blur', message: '请输入验证码' }]
      },
      loading: false,
      codeUrl: '',
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
  created() {
    this.getCode()
  },
  methods: {
    async getCode() {
      try {
        const res = await getCodeImg()
        if (res.img) {
          this.codeUrl = "data:image/gif;base64," + res.img
          this.loginForm.uuid = res.uuid
          // 重置验证码输入
          this.loginForm.code = ''
          console.log('获取验证码成功，UUID:', res.uuid)
        }
      } catch (error) {
        console.error('获取验证码失败:', error)
        this.$message.error('获取验证码失败')
      }
    },
    async handleLogin() {
      try {
        // 表单验证
        await this.$refs.loginFormRef.validate()
        
        // 验证码检查
        if (!this.loginForm.code) {
          this.$message.error('请输入验证码')
          return
        }

        // 开始登录
        this.loading = true
        console.log('登录请求数据:', this.loginForm)
        
        const res = await clientLogin({
          account: this.loginForm.account,
          password: this.loginForm.password,
          code: this.loginForm.code.toString(),
          uuid: this.loginForm.uuid
        })
        
        // 登录成功处理
        setClientToken(res.token)
        this.$router.push({ path: this.redirect || '/client/home' })
        this.$message.success('登录成功')
      } catch (error) {
        console.error('登录失败:', error)
        // 登录失败时刷新验证码
        this.getCode()
      } finally {
        this.loading = false
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  width: 100%;
  margin: 0;
  padding: 0;
  background: url('~@/assets/images/loginbackground.jpg') no-repeat center center fixed;
  background-size: cover;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

.login-form {
  width: 400px;
  padding: 30px;
  border-radius: 15px;
  background: rgba(255, 255, 255, 0.25);
  backdrop-filter: blur(15px);
  box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
  border: 1px solid rgba(255, 255, 255, 0.18);

  h2 {
    margin-bottom: 30px;
    text-align: center;
    color: #333;
    font-size: 24px;
  }
}

.code-input-container {
  position: relative;
  width: 100%;

  .el-input {
    width: 100%;
  }
}

.login-code-img {
  position: absolute;
  top: 1px;
  right: 1px;
  height: 38px;
  width: 110px;
  cursor: pointer;
  border-radius: 0 4px 4px 0;
}

.register-link {
  margin-top: 15px;
  text-align: right;

  .link-type {
    color: #409EFF;
    text-decoration: none;

    &:hover {
      text-decoration: underline;
    }
  }
}

:deep(.el-input__inner) {
  padding-right: 120px;
}
</style>