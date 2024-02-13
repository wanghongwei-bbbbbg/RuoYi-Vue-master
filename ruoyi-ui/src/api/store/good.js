import request from '@/utils/request'

// 查询商品管理列表
export function listGood(query) {
  return request({
    url: '/store/good/list',
    method: 'get',
    params: query
  })
}

// 查询商品管理详细
export function getGood(goodId) {
  return request({
    url: '/store/good/' + goodId,
    method: 'get'
  })
}

// 新增商品管理
export function addGood(data) {
  return request({
    url: '/store/good',
    method: 'post',
    data: data
  })
}

// 修改商品管理
export function updateGood(data) {
  return request({
    url: '/store/good',
    method: 'put',
    data: data
  })
}

// 删除商品管理
export function delGood(goodId) {
  return request({
    url: '/store/good/' + goodId,
    method: 'delete'
  })
}
