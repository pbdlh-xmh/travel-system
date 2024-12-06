import axios from 'axios'
import { Message } from 'element-ui'
import { getClientToken, removeClientToken } from '@/utils/clientAuth'
import router from '@/router/client'

/**
 * 客户端请求工具
 * 创建独立的 axios 实例，避免与后台请求混淆
 */

const clientRequest = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  timeout: 10000
})

// request拦截器
clientRequest.interceptors.request.use(
  config => {
    if (getClientToken()) {
      // 使用客户端专用的 token
      config.headers['Client-Token'] = getClientToken()
    }
    return config
  },
  error => {
    console.log('请求错误:', error)
    return Promise.reject(error)
  }
)

// response拦截器
clientRequest.interceptors.response.use(
  response => {
    const res = response.data

    // 处理不同的状态码
    switch (res.code) {
      case 200:
        return res
      case 401:
        // token 过期或无效
        Message({
          message: '登录状态已过期，请重新登录',
          type: 'error',
          duration: 5 * 1000
        })
        removeClientToken()
        router.push('/client/login')
        return Promise.reject(new Error('未授权'))
      case 403:
        Message({
          message: '没有权限访问该资源',
          type: 'error',
          duration: 5 * 1000
        })
        return Promise.reject(new Error('禁止访问'))
      case 500:
        Message({
          message: '服务器错误，请稍后重试',
          type: 'error',
          duration: 5 * 1000
        })
        return Promise.reject(new Error('服务器错误'))
      default:
        Message({
          message: res.msg || '请求失败',
          type: 'error',
          duration: 5 * 1000
        })
        return Promise.reject(new Error(res.msg || '请求失败'))
    }
  },
  error => {
    console.log('响应错误:', error)
    // 处理网络错误
    let message = '请求失败'
    if (error.response) {
      switch (error.response.status) {
        case 404:
          message = '请求的资源不存在'
          break
        case 408:
          message = '请求超时'
          break
        case 500:
          message = '服务器错误'
          break
        case 502:
          message = '网关错误'
          break
        case 503:
          message = '服务不可用'
          break
        case 504:
          message = '网关超时'
          break
        default:
          message = error.message
      }
    } else if (error.request) {
      message = '网络异常，请检查网络连接'
    }
    
    Message({
      message: message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default clientRequest