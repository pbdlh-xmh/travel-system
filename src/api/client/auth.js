import request from '@/utils/request'

/**
 * 客户端认证相关API
 */

// 登录
export function clientLogin(data) {
  return request({
    url: '/client/auth/login',
    method: 'post',
    headers: {
      isToken: false
    },
    data: {
      account: data.account,
      password: data.password,
      code: data.code,
      uuid: data.uuid
    }
  })
}

// 退出登录
export function clientLogout() {
  return request({
    url: '/client/auth/logout',
    method: 'post'
  })
}

// 注册
export function register(data) {
  return request({
    url: '/client/auth/register',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}

// 获取用户信息
export function getClientInfo() {
  return request({
    url: '/client/auth/info',
    method: 'get'
  })
}

// 字段验证相关
export function checkUsername(username) {
  return request({
    url: '/client/auth/check/username',
    method: 'get',
    headers: {
      isToken: false
    },
    params: { username }
  })
}

export function checkEmail(email) {
  return request({
    url: '/client/auth/check/email',
    method: 'get',
    headers: {
      isToken: false
    },
    params: { email }
  })
}

export function checkPhone(phone) {
  return request({
    url: '/client/auth/check/phone',
    method: 'get',
    headers: {
      isToken: false
    },
    params: { phone }
  })
}