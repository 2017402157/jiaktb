import request from '@/utils/request'

// 查询教练信息列表
export function listCoachinfo(query) {
  return request({
    url: '/jiaktb/coachinfo/list',
    method: 'get',
    params: query
  })
}

// 查询教练信息详细
export function getCoachinfo(coachInfoId) {
  return request({
    url: '/jiaktb/coachinfo/' + coachInfoId,
    method: 'get'
  })
}

// 新增教练信息
export function addCoachinfo(data) {
  return request({
    url: '/jiaktb/coachinfo',
    method: 'post',
    data: data
  })
}

// 修改教练信息
export function updateCoachinfo(data) {
  return request({
    url: '/jiaktb/coachinfo',
    method: 'put',
    data: data
  })
}

// 删除教练信息
export function delCoachinfo(coachInfoId) {
  return request({
    url: '/jiaktb/coachinfo/' + coachInfoId,
    method: 'delete'
  })
}

// 导出教练信息
export function exportCoachinfo(query) {
  return request({
    url: '/jiaktb/coachinfo/export',
    method: 'get',
    params: query
  })
}
