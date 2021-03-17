import request from '@/utils/request'

// 查询学费明细列表
export function listCost(query) {
  return request({
    url: '/jiaktb/cost/list',
    method: 'get',
    params: query
  })
}

// 查询学费明细详细
export function getCost(costId) {
  return request({
    url: '/jiaktb/cost/' + costId,
    method: 'get'
  })
}

// 新增学费明细
export function addCost(data) {
  return request({
    url: '/jiaktb/cost',
    method: 'post',
    data: data
  })
}

// 修改学费明细
export function updateCost(data) {
  return request({
    url: '/jiaktb/cost',
    method: 'put',
    data: data
  })
}

// 删除学费明细
export function delCost(costId) {
  return request({
    url: '/jiaktb/cost/' + costId,
    method: 'delete'
  })
}

// 导出学费明细
export function exportCost(query) {
  return request({
    url: '/jiaktb/cost/export',
    method: 'get',
    params: query
  })
}
