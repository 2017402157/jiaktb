import request from '@/utils/request'

// 查询车辆图片列表
export function listCarphoto(query) {
  return request({
    url: '/jiaktb/carphoto/list',
    method: 'get',
    params: query
  })
}

// 查询车辆图片详细
export function getCarphoto(carPhotoId) {
  return request({
    url: '/jiaktb/carphoto/' + carPhotoId,
    method: 'get'
  })
}

// 新增车辆图片
export function addCarphoto(data) {
  return request({
    url: '/jiaktb/carphoto',
    method: 'post',
    data: data
  })
}

// 修改车辆图片
export function updateCarphoto(data) {
  return request({
    url: '/jiaktb/carphoto',
    method: 'put',
    data: data
  })
}

// 删除车辆图片
export function delCarphoto(carPhotoId) {
  return request({
    url: '/jiaktb/carphoto/' + carPhotoId,
    method: 'delete'
  })
}

// 导出车辆图片
export function exportCarphoto(query) {
  return request({
    url: '/jiaktb/carphoto/export',
    method: 'get',
    params: query
  })
}
