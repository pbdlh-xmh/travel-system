import request from '@/utils/request'

// 查询旅游新闻列表
export function listNews(query) {
  return request({
    url: '/lytj/news/list',
    method: 'get',
    params: query
  })
}

// 查询旅游新闻详细
export function getNews(newsId) {
  return request({
    url: '/lytj/news/' + newsId,
    method: 'get'
  })
}

// 新增旅游新闻
export function addNews(data) {
  return request({
    url: '/lytj/news',
    method: 'post',
    data: data
  })
}

// 修改旅游新闻
export function updateNews(data) {
  return request({
    url: '/lytj/news',
    method: 'put',
    data: data
  })
}

// 删除旅游新闻
export function delNews(newsId) {
  return request({
    url: '/lytj/news/' + newsId,
    method: 'delete'
  })
}
