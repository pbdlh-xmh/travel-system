import request from '@/utils/request'

// 查询收藏管理列表
export function listFavorite(query) {
  return request({
    url: '/lytj/favorite/list',
    method: 'get',
    params: query
  })
}

// 查询收藏管理详细
export function getFavorite(favoriteId) {
  return request({
    url: '/lytj/favorite/' + favoriteId,
    method: 'get'
  })
}

// 新增收藏管理
export function addFavorite(data) {
  return request({
    url: '/lytj/favorite',
    method: 'post',
    data: data
  })
}

// 修改收藏管理
export function updateFavorite(data) {
  return request({
    url: '/lytj/favorite',
    method: 'put',
    data: data
  })
}

// 删除收藏管理
export function delFavorite(favoriteId) {
  return request({
    url: '/lytj/favorite/' + favoriteId,
    method: 'delete'
  })
}
