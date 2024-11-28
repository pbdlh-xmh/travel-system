<template>
    <div class="test-container">
      <h1>欢迎来到旅游景点管理系统</h1>
      <div class="content">
        <p>这是一个测试页面</p>
        <el-button type="primary" @click="$router.push('/login')">
          去登录
        </el-button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'TestPage'
  }
  </script>
  
  <style scoped>
  .test-container {
    padding: 20px;
    text-align: center;
  }
  
  .content {
    margin-top: 20px;
  }
  
  h1 {
    color: #409EFF;
  }
  </style>