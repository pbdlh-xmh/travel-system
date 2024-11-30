import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export const clientRoutes = [
  {
    path: '/home',
    component: () => import('../views/client/layout/index.vue'),
    children: [
      {
        path: '',
        component: () => import('../views/client/home/index.vue'),
        name: 'ClientHome',
        meta: { title: '首页', requireAuth: true }
      }
    ]
  },
  {
    path: '/login',
    component: () => import('../views/client/login/index.vue'),
    hidden: true
  },
  {
    path: '/register',
    component: () => import('../views/client/register/index.vue'),
    hidden: true
  }
]

// 创建独立的客户端路由实例
const createClientRouter = () => new Router({
  mode: 'history',
  base: '/client/', // 添加基础路径
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    ...clientRoutes
  ]
})

const clientRouter = createClientRouter()

export function resetClientRouter() {
  const newRouter = createClientRouter()
  clientRouter.matcher = newRouter.matcher
}

export default clientRouter