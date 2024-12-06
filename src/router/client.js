import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export const clientRoutes = [
  {
    path: '/client',  // 修改为父路径
    component: () => import('@/views/client/layout/index.vue'),
    redirect: '/client/home',  // 添加重定向
    children: [
      {
        path: 'home',  // 子路由路径，会自动拼接父路径
        component: () => import('@/views/client/home/index.vue'),  // 修改为正确的组件路径
        name: 'ClientHome',
        meta: { title: '首页', requireAuth: true }
      }
    ]
  },
  {
    path: '/client/login',
    component: () => import('@/views/client/login/index.vue'),
    hidden: true
  },
  {
    path: '/client/register',
    component: () => import('@/views/client/register/index.vue'),
    hidden: true
  }
]

const createClientRouter = () => new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/client'  // 重定向到 /client
    },
    ...clientRoutes,
    {
      path: '*',
      redirect: '/client'  // 404 重定向到 /client
    }
  ]
})

const clientRouter = createClientRouter()

export function resetClientRouter() {
  const newRouter = createClientRouter()
  clientRouter.matcher = newRouter.matcher
}

export default clientRouter