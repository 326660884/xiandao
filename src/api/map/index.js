import request from '../index'

export function getList() {
  return request({
    url: '/getList',
    method: 'get'
  })
}