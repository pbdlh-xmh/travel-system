import request from '@/utils/request'

// 查询线路-景点关联管理列表
export function listRouteAttraction(query) {
  return request({
    url: '/lytj/routeAttraction/list',
    method: 'get',
    params: query
  })
}

// 查询线路-景点关联管理详细
export function getRouteAttraction(id) {
  return request({
    url: '/lytj/routeAttraction/' + id,
    method: 'get'
  })
}

// 新增线路-景点关联管理
export function addRouteAttraction(data) {
  return request({
    url: '/lytj/routeAttraction',
    method: 'post',
    data: data
  })
}

// 修改线路-景点关联管理
export function updateRouteAttraction(data) {
  return request({
    url: '/lytj/routeAttraction',
    method: 'put',
    data: data
  })
}

// 删除线路-景点关联管理
export function delRouteAttraction(id) {
  return request({
    url: '/lytj/routeAttraction/' + id,
    method: 'delete'
  })
}
