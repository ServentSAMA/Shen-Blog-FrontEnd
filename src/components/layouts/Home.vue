<template>
  <el-container style="height: 650px">
    <el-header style="background-color: #afd4f5;text-align: right">
    </el-header>
    <el-container>
      <el-aside style="background-color: rgb(238, 241, 246)">
        aside
      <router-link to="login">login</router-link>
      </el-aside>
      <el-main style="">
        <div id="home" style="width: 450px;">
          <el-table :data="data">
            <el-table-column prop="articleName" label="文章名"></el-table-column>
            <el-table-column prop="author" label="作者"></el-table-column>
            <el-table-column prop="createTime" label="创建时间"></el-table-column>
          </el-table>
          <el-button v-on:click="load" icon="el-icon-search">按钮</el-button>
        </div>
        <div id="test" style="height: 600px;width: 600px"></div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { listArticle } from '@/api/api'
import * as echarts from 'echarts'
export default {
  name: 'Home',
  data () {
    return {
      data: []
    }
  },
  mounted () {
    this.load()
  },
  methods: {
    load () {
      listArticle().then((res) => {
        if (res.data.success) {
          this.data = res.data.data
        }
      })
    }
    // /* eslint-disable */
    // initEcharts () {
    //   const option = {
    //     title: {
    //       text: "ECharts 入门示例"
    //     },
    //     tooltip: {},
    //     legend: {
    //       data: ["销量"]
    //     },
    //     xAxis: {
    //       data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
    //     },
    //     yAxis: {},
    //     series: [
    //       {
    //         name: "销量",
    //         type: "bar", //类型为柱状图
    //         data: [5, 20, 36, 10, 10, 20]
    //       }
    //     ]
    //   }
    //   const myChart = echarts.init(document.getElementById("test"));// 图标初始化
    //   myChart.setOption(option);// 渲染页面
    //   //随着屏幕大小调节图表
    //   window.addEventListener("resize", () => {
    //     myChart.resize();
    //   });
    // }
  }
}

</script>

<style scoped>
</style>
