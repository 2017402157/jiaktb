import request from '@/utils/request'

// 查询图片信息列表
export function listPhotos(query) {
  return request({
    url: '/jiaktb/photos/list',
    method: 'get',
    params: query
  })
}

// 查询图片信息详细
export function getPhotos(photosId) {
  return request({
    url: '/jiaktb/photos/' + photosId,
    method: 'get'
  })
}

// 新增图片信息
export function addPhotos(data) {
  return request({
    url: '/jiaktb/photos',
    method: 'post',
    data: data
  })
}

// 修改图片信息
export function updatePhotos(data) {
  return request({
    url: '/jiaktb/photos',
    method: 'put',
    data: data
  })
}

// 删除图片信息
export function delPhotos(photosId) {
  return request({
    url: '/jiaktb/photos/' + photosId,
    method: 'delete'
  })
}

// 导出图片信息
export function exportPhotos(query) {
  return request({
    url: '/jiaktb/photos/export',
    method: 'get',
    params: query
  })
}
