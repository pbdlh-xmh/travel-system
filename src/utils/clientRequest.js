import axios from 'axios'
import { Message } from 'element-ui'
import { getClientToken } from '@/utils/clientAuth'

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
    console.log(error)
    return Promise.reject(error)
  }
)

// response拦截器
clientRequest.interceptors.response.use(
  response => {
    const res = response.data
    if (res.code !== 200) {
      Message({
        message: res.msg || '请求失败',
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject(new Error(res.msg || '请求失败'))
    }
    return res
  },
  error => {
    console.log('err' + error)
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default clientRequest 