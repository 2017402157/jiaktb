import request from '@/utils/request'

// 查询学员信息列表
export function listStuinfo(query) {
  return request({
    url: '/jiaktb/stuinfo/list',
    method: 'get',
    params: query
  })
}

// 查询学员信息详细
export function getStuinfo(stuInfoId) {
  return request({
    url: '/jiaktb/stuinfo/' + stuInfoId,
    method: 'get'
  })
}

// 新增学员信息
export function addStuinfo(data) {
  return request({
    url: '/jiaktb/stuinfo',
    method: 'post',
    data: data
  })
}

// 修改学员信息
export function updateStuinfo(data) {
  return request({
    url: '/jiaktb/stuinfo',
    method: 'put',
    data: data
  })
}

// 删除学员信息
export function delStuinfo(stuInfoId) {
  return request({
    url: '/jiaktb/stuinfo/' + stuInfoId,
    method: 'delete'
  })
}

// 导出学员信息
export function exportStuinfo(query) {
  return request({
    url: '/jiaktb/stuinfo/export',
    method: 'get',
    params: query
  })
}
