import Vue from 'vue'
import App from './ClientApp.vue'
import clientRouter from './router/client'  // 使用客户端路由
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/styles/client.scss'
import { parseTime, resetForm, handleTree } from "@/utils/ruoyi"

// 全局方法挂载
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.handleTree = handleTree

Vue.use(ElementUI)

// 添加客户端路由守卫
clientRouter.beforeEach((to, from, next) => {
  // 这里添加客户端的路由守卫逻辑
  next()
})

new Vue({
  router: clientRouter,  // 使用客户端路由
  store,
  render: h => h(App)
}).$mount('#app')