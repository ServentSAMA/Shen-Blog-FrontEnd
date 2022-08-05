import {httpGet, httpPost, logout} from './request'

// 文章相关
const listArticle = (params) => httpGet('/article/listArticle', params)
const articleDetails = (params) => httpGet('/article/details', params)
const login = (params) => httpPost('/sys/auth/login', params)
const logoutApi = (token) => logout('/sys/auth/logout', token)
export {
  listArticle,
  articleDetails,
  login,
  logoutApi
}
