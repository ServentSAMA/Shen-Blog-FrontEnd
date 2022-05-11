import {httpGet} from './request'

// 文章相关
const listArticle = (params) => httpGet('/front/article/listArticle', params)
const articleDetails = (params) => httpGet('/front/article/details', params)

export {
  listArticle,
  articleDetails
}
