import request from '@/utils/request'

// 查询团体信息列表
export function listGroupuser(query) {
  return request({
    url: '/jiaktb/groupuser/list',
    method: 'get',
    params: query
  })
}

// 查询团体信息详细
export function getGroupuser(groupUserId) {
  return request({
    url: '/jiaktb/groupuser/' + groupUserId,
    method: 'get'
  })
}

// 新增团体信息
export function addGroupuser(data) {
  return request({
    url: '/jiaktb/groupuser',
    method: 'post',
    data: data
  })
}

// 修改团体信息
export function updateGroupuser(data) {
  return request({
    url: '/jiaktb/groupuser',
    method: 'put',
    data: data
  })
}

// 删除团体信息
export function delGroupuser(groupUserId) {
  return request({
    url: '/jiaktb/groupuser/' + groupUserId,
    method: 'delete'
  })
}

// 导出团体信息
export function exportGroupuser(query) {
  return request({
    url: '/jiaktb/groupuser/export',
    method: 'get',
    params: query
  })
}
