import request from '@/utils/request'

// 查询可视化大屏占位列表
export function listDashboard(query) {
  return request({
    url: '/lytj/dashboard/list',
    method: 'get',
    params: query
  })
}

// 查询可视化大屏占位详细
export function getDashboard(id) {
  return request({
    url: '/lytj/dashboard/' + id,
    method: 'get'
  })
}

// 新增可视化大屏占位
export function addDashboard(data) {
  return request({
    url: '/lytj/dashboard',
    method: 'post',
    data: data
  })
}

// 修改可视化大屏占位
export function updateDashboard(data) {
  return request({
    url: '/lytj/dashboard',
    method: 'put',
    data: data
  })
}

// 删除可视化大屏占位
export function delDashboard(id) {
  return request({
    url: '/lytj/dashboard/' + id,
    method: 'delete'
  })
}
