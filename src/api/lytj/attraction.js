import request from '@/utils/request'

// 查询景点管理列表
export function listAttraction(query) {
  return request({
    url: '/lytj/attraction/list',
    method: 'get',
    params: query
  })
}

// 查询景点管理详细
export function getAttraction(attractionId) {
  return request({
    url: '/lytj/attraction/' + attractionId,
    method: 'get'
  })
}

// 新增景点管理
export function addAttraction(data) {
  return request({
    url: '/lytj/attraction',
    method: 'post',
    data: data
  })
}

// 修改景点管理
export function updateAttraction(data) {
  return request({
    url: '/lytj/attraction',
    method: 'put',
    data: data
  })
}

// 删除景点管理
export function delAttraction(attractionId) {
  return request({
    url: '/lytj/attraction/' + attractionId,
    method: 'delete'
  })
}
