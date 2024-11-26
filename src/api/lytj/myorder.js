import request from '@/utils/request'

// 查询订单管理列表
export function listMyorder(query) {
  return request({
    url: '/lytj/myorder/list',
    method: 'get',
    params: query
  })
}

// 查询订单管理详细
export function getMyorder(orderId) {
  return request({
    url: '/lytj/myorder/' + orderId,
    method: 'get'
  })
}

// 新增订单管理
export function addMyorder(data) {
  return request({
    url: '/lytj/myorder',
    method: 'post',
    data: data
  })
}

// 修改订单管理
export function updateMyorder(data) {
  return request({
    url: '/lytj/myorder',
    method: 'put',
    data: data
  })
}

// 删除订单管理
export function delMyorder(orderId) {
  return request({
    url: '/lytj/myorder/' + orderId,
    method: 'delete'
  })
}
