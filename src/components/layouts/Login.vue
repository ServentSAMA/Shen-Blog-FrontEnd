<template>
  <div>
    <div id="loginForm">
      <el-input class="login" placeholder="用户名" v-model="username"></el-input>
      <el-input class="login" placeholder="密码" show-password v-model="password"></el-input>
      <el-button id="loginButton" @click="login">登录</el-button>
    </div>
    <div>
      <el-button id="logoutButton" @click="logout">登出</el-button>
    </div>
  </div>
</template>

<script>
import {login, logoutApi} from '../../api/api'

export default {
  name: 'Login',
  data () {
    return {
      password: '',
      username: '',
      token: '',
      validatorRules: {
        username: [
          { required: true, message: '请输入用户名!' }
        ],
        password: [{
          required: true, message: '请输入密码!', validator: 'click'
        }]
      }
    }
  },
  methods: {
    login () {
      let accountModel = {
        username: this.username,
        password: this.password
      }
      login(accountModel).then((res) => {
        if (res.data.success) {
          this.token = res.data.data.token
          localStorage.setItem('token', this.token)
        }
      })
    },
    logout () {
      const token = localStorage.getItem('token')
      logoutApi(token).then((res) => {
        console.log(res.data)
      })
    }
  }
}
</script>

<style scoped>
@import url('../../assets/login.css');
</style>
