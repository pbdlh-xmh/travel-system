// 客户端路由守卫
import router from '@/router/client'  // 引入客户端路由
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { getClientToken } from '@/utils/clientAuth'
import { clientWhiteList } from '@/router/client'

NProgress.configure({ showSpinner: false })

router.beforeEach((to, from, next) => {
  NProgress.start()
  if (getClientToken()) {
    if (to.path === '/login') {
      next({ path: '/home' })
      NProgress.done()
    } else {
      next()
    }
  } else {
    if (clientWhiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next(`/login?redirect=${encodeURIComponent(to.fullPath)}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done()
})

export default router 