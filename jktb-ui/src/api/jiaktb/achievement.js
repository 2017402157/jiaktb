import request from '@/utils/request'

// 查询成绩列表
export function listAchievement(query) {
  return request({
    url: '/jiaktb/achievement/list',
    method: 'get',
    params: query
  })
}

// 查询成绩详细
export function getAchievement(achievementId) {
  return request({
    url: '/jiaktb/achievement/' + achievementId,
    method: 'get'
  })
}

// 新增成绩
export function addAchievement(data) {
  return request({
    url: '/jiaktb/achievement',
    method: 'post',
    data: data
  })
}

// 修改成绩
export function updateAchievement(data) {
  return request({
    url: '/jiaktb/achievement',
    method: 'put',
    data: data
  })
}

// 删除成绩
export function delAchievement(achievementId) {
  return request({
    url: '/jiaktb/achievement/' + achievementId,
    method: 'delete'
  })
}

// 导出成绩
export function exportAchievement(query) {
  return request({
    url: '/jiaktb/achievement/export',
    method: 'get',
    params: query
  })
}
