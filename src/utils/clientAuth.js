const ClientTokenKey = 'Client-Token'

/**
 * 客户端认证工具
 * 使用独立的 Token 存储机制，避免与后台管理系统冲突
 */

export function getClientToken() {
  return localStorage.getItem(ClientTokenKey)
}

export function setClientToken(token) {
  return localStorage.setItem(ClientTokenKey, token)
}

export function removeClientToken() {
  return localStorage.removeItem(ClientTokenKey)
} 