import request from '@/utils/request'

// 查询用户管理列表
export function listMyUser(query) {
  return request({
    url: '/lytj/myUser/list',
    method: 'get',
    params: query
  })
}

// 查询用户管理详细
export function getMyUser(userId) {
  return request({
    url: '/lytj/myUser/' + userId,
    method: 'get'
  })
}

// 新增用户管理
export function addMyUser(data) {
  return request({
    url: '/lytj/myUser',
    method: 'post',
    data: data
  })
}

// 修改用户管理
export function updateMyUser(data) {
  return request({
    url: '/lytj/myUser',
    method: 'put',
    data: data
  })
}

// 删除用户管理
export function delMyUser(userId) {
  return request({
    url: '/lytj/myUser/' + userId,
    method: 'delete'
  })
}
