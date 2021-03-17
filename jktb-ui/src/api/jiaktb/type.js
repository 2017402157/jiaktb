import request from '@/utils/request'

// 查询驾驶证种类列表
export function listType(query) {
  return request({
    url: '/jiaktb/type/list',
    method: 'get',
    params: query
  })
}

// 查询驾驶证种类详细
export function getType(driveTypeId) {
  return request({
    url: '/jiaktb/type/' + driveTypeId,
    method: 'get'
  })
}

// 新增驾驶证种类
export function addType(data) {
  return request({
    url: '/jiaktb/type',
    method: 'post',
    data: data
  })
}

// 修改驾驶证种类
export function updateType(data) {
  return request({
    url: '/jiaktb/type',
    method: 'put',
    data: data
  })
}

// 删除驾驶证种类
export function delType(driveTypeId) {
  return request({
    url: '/jiaktb/type/' + driveTypeId,
    method: 'delete'
  })
}

// 导出驾驶证种类
export function exportType(query) {
  return request({
    url: '/jiaktb/type/export',
    method: 'get',
    params: query
  })
}
