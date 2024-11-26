import request from '@/utils/request'

// 查询轮播图管理列表
export function listCarousel(query) {
  return request({
    url: '/lytj/carousel/list',
    method: 'get',
    params: query
  })
}

// 查询轮播图管理详细
export function getCarousel(carouselId) {
  return request({
    url: '/lytj/carousel/' + carouselId,
    method: 'get'
  })
}

// 新增轮播图管理
export function addCarousel(data) {
  return request({
    url: '/lytj/carousel',
    method: 'post',
    data: data
  })
}

// 修改轮播图管理
export function updateCarousel(data) {
  return request({
    url: '/lytj/carousel',
    method: 'put',
    data: data
  })
}

// 删除轮播图管理
export function delCarousel(carouselId) {
  return request({
    url: '/lytj/carousel/' + carouselId,
    method: 'delete'
  })
}
