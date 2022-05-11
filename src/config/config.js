/** init domain config */
import Vue from 'vue'

/**
 * 存放配置常量(当值不为空时会覆盖env配置)
 */
window._CONFIG = {
  // 接口父路径
  VUE_APP_API_BASE_URL: '',
  // 单点登录地址
  VUE_APP_CAS_BASE_URL: '',
  // 文件预览路径
  VUE_APP_ONLINE_BASE_URL: ''
}

// 设置全局API_BASE_URL
Vue.prototype.API_BASE_URL = window._CONFIG.VUE_APP_API_BASE_URL
window._CONFIG['domianURL'] = Vue.prototype.API_BASE_URL
