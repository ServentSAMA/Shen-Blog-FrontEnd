import axios from 'axios'

const baseContextPath = process.env.VUE_APP_API_BASE_URL

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
export function httpPost (url, params) {
  return axiosInstance({
    url: url,
    method: 'post',
    data: params
  })
}
export function logout (url, token) {
  return axiosInstance({
    url: url,
    method: 'post',
    headers: {
      'Authorization': 'Bearer ' + token
    }
  })
}
