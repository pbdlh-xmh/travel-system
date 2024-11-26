import request from '@/utils/request'

// 查询旅游线路管理列表
export function listRoute(query) {
  return request({
    url: '/lytj/route/list',
    method: 'get',
    params: query
  })
}

// 查询旅游线路管理详细
export function getRoute(routeId) {
  return request({
    url: '/lytj/route/' + routeId,
    method: 'get'
  })
}

// 新增旅游线路管理
export function addRoute(data) {
  return request({
    url: '/lytj/route',
    method: 'post',
    data: data
  })
}

// 修改旅游线路管理
export function updateRoute(data) {
  return request({
    url: '/lytj/route',
    method: 'put',
    data: data
  })
}

// 删除旅游线路管理
export function delRoute(routeId) {
  return request({
    url: '/lytj/route/' + routeId,
    method: 'delete'
  })
}
