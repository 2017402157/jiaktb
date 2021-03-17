import request from '@/utils/request'

// 查询优惠配置列表
export function listRule(query) {
  return request({
    url: '/jiaktb/rule/list',
    method: 'get',
    params: query
  })
}

// 查询优惠配置详细
export function getRule(disRuleId) {
  return request({
    url: '/jiaktb/rule/' + disRuleId,
    method: 'get'
  })
}

// 新增优惠配置
export function addRule(data) {
  return request({
    url: '/jiaktb/rule',
    method: 'post',
    data: data
  })
}

// 修改优惠配置
export function updateRule(data) {
  return request({
    url: '/jiaktb/rule',
    method: 'put',
    data: data
  })
}

// 删除优惠配置
export function delRule(disRuleId) {
  return request({
    url: '/jiaktb/rule/' + disRuleId,
    method: 'delete'
  })
}

// 导出优惠配置
export function exportRule(query) {
  return request({
    url: '/jiaktb/rule/export',
    method: 'get',
    params: query
  })
}
