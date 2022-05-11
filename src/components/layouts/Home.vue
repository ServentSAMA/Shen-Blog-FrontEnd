<template>
<el-container style="height: 650px">
  <el-header style="background-color: #afd4f5;text-align: right">
    <el-dropdown style="right: 0px">
      <i class="el-icon-s-tools" style="margin-right: 15px;padding-top: 30%;font-size: 30px"></i>
      <el-dropdown-menu>
        <el-dropdown-item @click.native="login">登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </el-header>
  <el-container>
    <el-main style="">
      <div id="home" style="width: 450px;">
        <el-table :data="data">
          <el-table-column prop="articleName" label="文章名"></el-table-column>
          <el-table-column prop="author" label="作者"></el-table-column>
          <el-table-column prop="createTime" label="创建时间"></el-table-column>
        </el-table>
        <el-button v-on:click="load" icon="el-icon-search">按钮</el-button>
      </div>
    </el-main>
    <el-aside style="background-color: rgb(238, 241, 246)">aside</el-aside>
  </el-container>
</el-container>
</template>

<script>
import {listArticle} from '@/api/api'

export default {
  name: 'Home',
  data () {
    return {
      data: []
    }
  },
  methods: {
    load () {
      listArticle().then((res) => {
        if (res.data.success) {
          this.data = res.data.data
        }
      })
    },
    login () {
      console.log('---------')
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>
