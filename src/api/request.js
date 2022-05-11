import axios from 'axios'

let baseContextPath = 'http://192.168.0.104:8088/blog'

const axiosInstance = axios.create({
  baseURL: baseContextPath,
  timeout: 9000// 请求超时时间
})

export function httpGet (url, params) {
  return axiosInstance({
    url: url,
    method: 'get',
    data: params
  })
}
