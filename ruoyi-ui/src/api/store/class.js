import request from '@/utils/request'

// 查询类型管理列表
export function listClass(query) {
  return request({
    url: '/store/class/list',
    method: 'get',
    params: query
  })
}

// 查询类型管理详细
export function getClass(classId) {
  return request({
    url: '/store/class/' + classId,
    method: 'get'
  })
}

// 新增类型管理
export function addClass(data) {
  return request({
    url: '/store/class',
    method: 'post',
    data: data
  })
}

// 修改类型管理
export function updateClass(data) {
  return request({
    url: '/store/class',
    method: 'put',
    data: data
  })
}

// 删除类型管理
export function delClass(classId) {
  return request({
    url: '/store/class/' + classId,
    method: 'delete'
  })
}
