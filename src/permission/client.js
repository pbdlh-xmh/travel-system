import router from '@/router/client'
import store from '@/store'
import { Message } from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { getClientToken } from '@/utils/clientAuth'

NProgress.configure({ showSpinner: false })

// 白名单路由
const whiteList = [
  '/client/login',
  '/client/register',
  '/client/forget',
  '/client/home'  // 首页允许未登录访问
]

router.beforeEach((to, from, next) => {
  NProgress.start()
  
  // 获取token
  const hasToken = getClientToken()

  if (hasToken) {
    if (to.path === '/client/login') {
      // 已登录且要跳转的页面是登录页
      next({ path: '/client/home' })
      NProgress.done()
    } else {
      // 判断当前用户是否已拉取完user_info信息
      const hasRoles = store.getters['client/roles'] && store.getters['client/roles'].length > 0
      if (hasRoles) {
        next()
      } else {
        try {
          // 获取用户信息
          store.dispatch('client/GetInfo').then(() => {
            next({ ...to, replace: true })
          }).catch(err => {
            // 获取用户信息失败，清除token并跳转登录页
            store.dispatch('client/LogOut').then(() => {
              Message.error(err || '验证失败，请重新登录')
              next({ path: '/client/login' })
            })
          })
        } catch (error) {
          // 出错时清除token并跳转登录页
          store.dispatch('client/LogOut').then(() => {
            Message.error(error || '出现错误，请重新登录')
            next({ path: '/client/login' })
          })
        }
      }
    }
  } else {
    // 没有token
    if (whiteList.indexOf(to.path) !== -1) {
      // 在免登录白名单，直接进入
      next()
    } else {
      // 其他没有访问权限的页面将被重定向到登录页面
      next(`/client/login?redirect=${to.fullPath}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done()
})