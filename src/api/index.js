import axios from 'axios'
// import store from '@/store'

import { Message } from 'element-ui'

import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
// 创建axios 实例
const baseURL = 'https://www.easy-mock.com/mock/5b35cb3994d58d1454f1d594/d3'
const service = axios.create({
  baseURL: baseURL, // api的base_url
  timeout: 5000 // 请求超时时间
})

// request 拦截器
service.interceptors.request.use(config => {
  // 这里可以自定义一些config 配置
  NProgress.start()
  // 这里计算签名
  return config
},
error => {
  //  这里处理一些请求出错的情况
  Promise.reject(error)
}
)

// response 拦截器
service.interceptors.response.use(
  response => {
    const res = response.data

    NProgress.done()
    // 这里处理一些response 正常放回时的逻辑
    // store.dispatch('SetLoading', false)
    return res
  },
  error => {
    // 这里处理一些response 出错时的逻辑
    Message.error(error.message)
    NProgress.done()
    // store.dispatch('SetLoading', false)
    return Promise.reject(error)
  }
)

export default service
