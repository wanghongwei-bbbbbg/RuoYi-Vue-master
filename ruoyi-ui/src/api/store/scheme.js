import request from '@/utils/request'

// 查询装机方案列表
export function listScheme(query) {
  return request({
    url: '/store/scheme/list',
    method: 'get',
    params: query
  })
}

// 查询装机方案详细
export function getScheme(schemeId) {
  return request({
    url: '/store/scheme/' + schemeId,
    method: 'get'
  })
}

// 新增装机方案
export function addScheme(data) {
  return request({
    url: '/store/scheme',
    method: 'post',
    data: data
  })
}

// 修改装机方案
export function updateScheme(data) {
  return request({
    url: '/store/scheme',
    method: 'put',
    data: data
  })
}

// 删除装机方案
export function delScheme(schemeId) {
  return request({
    url: '/store/scheme/' + schemeId,
    method: 'delete'
  })
}
