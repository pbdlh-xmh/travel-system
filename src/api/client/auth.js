import request from '@/utils/request'

/**
 * 客户端认证相关API
 */

// 客户端登录方法 - 支持用户名/邮箱/手机号登录
export function clientLogin(data) {
  return request({
    url: '/client/auth/login',
    method: 'post',
    data: {
      account: data.account,  // 统一使用account字段，后端判断登录类型
      password: data.password
    }
  })
}

// 检查用户名是否已存在
export function checkUsername(username) {
  return request({
    url: '/client/auth/check/username',
    method: 'get',
    params: { username }
  })
}

// 检查邮箱是否已存在
export function checkEmail(email) {
  return request({
    url: '/client/auth/check/email',
    method: 'get',
    params: { email }
  })
}

// 检查手机号是否已存在
export function checkPhone(phone) {
  return request({
    url: '/client/auth/check/phone',
    method: 'get',
    params: { phone }
  })
}

// 获取客户端用户信息
export function getClientInfo() {
  return request({
    url: '/client/auth/info',
    method: 'get'
  })
}

// 客户端登出方法
export function clientLogout() {
  return request({
    url: '/client/auth/logout',
    method: 'post'
  })
}

// 注册方法
export function register(data) {
  return request({
    url: '/client/auth/register',
    method: 'post',
    data: data
  })
}

// 登录方法
export function login(data) {
  return request({
    url: '/client/auth/login',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}

// 获取用户详细信息
export function getInfo() {
  return request({
    url: '/client/auth/getInfo',
    method: 'get'
  })
}

// 退出方法
export function logout() {
  return request({
    url: '/client/auth/logout',
    method: 'post'
  })
} 