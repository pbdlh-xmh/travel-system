import Vue from 'vue'
import App from './ClientApp.vue'
import clientRouter from './router/client'
import store from './store'
import ElementUI from 'element-ui'
import { Message } from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/styles/client.scss'
import { parseTime, resetForm, handleTree } from "@/utils/ruoyi"
import { getClientToken } from '@/utils/clientAuth'

// 导入 svg-icon 组件
import SvgIcon from '@/components/SvgIcon'
// 导入所有 svg 图标
import '@/assets/icons'

// 注册 svg-icon 组件
Vue.component('svg-icon', SvgIcon)

// 全局方法挂载
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.handleTree = handleTree

Vue.use(ElementUI)

NProgress.configure({ showSpinner: false })


// 白名单路由
const whiteList = [
  '/client/login',
  '/client/register',
  '/client/forget',
  '/client/home'  // 首页允许未登录访问
]

// 添加客户端路由守卫
clientRouter.beforeEach((to, from, next) => {
  NProgress.start()
  
  const hasToken = getClientToken()

  if (hasToken) {
    if (to.path === '/client/login') {
      next({ path: '/client/home' })
      NProgress.done()
    } else {
      const hasRoles = store.getters.clientRoles && store.getters.clientRoles.length > 0
      if (hasRoles) {
        next()
      } else {
        store.dispatch('client/GetInfo').then(() => {
          next({ ...to, replace: true })
        }).catch(err => {
          store.dispatch('client/LogOut').then(() => {
            Message.error(err || '验证失败，请重新登录')
            next({ path: '/client/login' })
          })
        })
      }
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next(`/client/login?redirect=${to.fullPath}`)
      NProgress.done()
    }
  }
})

// 路由跳转后的处理
clientRouter.afterEach(() => {
  NProgress.done()
})

new Vue({
  router: clientRouter,
  store,
  render: h => h(App)
}).$mount('#app')

// 添加错误处理
Vue.config.errorHandler = function(err, vm, info) {
  console.error('Vue error:', err)
  console.error('Error info:', info)
}

// 添加调试信息
if (process.env.NODE_ENV === 'development') {
  console.log('Client mode:', process.env.VUE_APP_MODE)
  console.log('Base API:', process.env.VUE_APP_BASE_API)
}