import request from '@/utils/request'

// 查询车辆信息列表
export function listCarinfo(query) {
  return request({
    url: '/jiaktb/carinfo/list',
    method: 'get',
    params: query
  })
}

// 查询车辆信息详细
export function getCarinfo(carInfoId) {
  return request({
    url: '/jiaktb/carinfo/' + carInfoId,
    method: 'get'
  })
}

// 新增车辆信息
export function addCarinfo(data) {
  return request({
    url: '/jiaktb/carinfo',
    method: 'post',
    data: data
  })
}

// 修改车辆信息
export function updateCarinfo(data) {
  return request({
    url: '/jiaktb/carinfo',
    method: 'put',
    data: data
  })
}

// 删除车辆信息
export function delCarinfo(carInfoId) {
  return request({
    url: '/jiaktb/carinfo/' + carInfoId,
    method: 'delete'
  })
}

// 导出车辆信息
export function exportCarinfo(query) {
  return request({
    url: '/jiaktb/carinfo/export',
    method: 'get',
    params: query
  })
}
