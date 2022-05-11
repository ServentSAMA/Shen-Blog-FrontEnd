import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/layouts/Home'
import Login from '../components/layouts/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
