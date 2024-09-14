<template>
  <!-- ECharts的容器 -->
  <div id="echarts-dom" style="width: 650px;height: 500px"></div>
</template>

<script>
import * as echarts from 'echarts';
import request from "@/utils/request";

// 引入ECharts主题
require("echarts/theme/macarons");

export default {
  name: "home_echarts", // 组件名称
  data() {
    return {
      option: {
        // 柱状图的宽度
        barWidth: 35,
        // 提示框组件
        tooltip: {},
        // x轴配置
        xAxis: {
          data: [] // x轴数据
        },
        // y轴配置
        yAxis: {
          type: "value" // y轴类型为数值轴
        },
        // 系列列表
        series: [
          {
            name: '人数', // 系列名称
            type: 'bar', // 图表类型为柱状图
            data: [] // 系列数据
          },
        ],
        // 网格配置
        grid: {
          x: 40,
          y: 40,
          x2: 40,
          y2: 40,
          borderWidth: 10,
          top: '10%',
          bottom: '0%',
          containLabel: true // 网格区域包含坐标轴的刻度标签
        }
      },
      myEcharts: '', // ECharts实例
      chartWidth: '', // 图表宽度
      chartHeight: '', // 图表高度
    };
  },
  created() {
    // 组件创建时获取楼宇数量
    this.getBuildingNum();
  },
  mounted() {
    // 组件挂载时创建ECharts实例
    this.createEcharts();
  },
  watch: {
    // 监听option的变化
    option: {
      handler(newVal, oldVal) {
        if (this.myEcharts) {
          // 如果ECharts实例存在
          if (newVal) {
            // 如果新的option存在，设置新的option
            this.myEcharts.setOption(newVal);
          } else {
            // 否则设置旧的option
            this.myEcharts.setOption(oldVal);
          }
        } else {
          // 如果ECharts实例不存在，重新创建ECharts实例
          this.createEcharts();
        }
      },
      deep: true // 深度监听对象内部属性的变化
    }
  },
  methods: {
    // 创建ECharts实例
    createEcharts() {
      const chartDmo = document.getElementById("echarts-dom"); // 获取ECharts容器
      this.myEcharts = echarts.init(chartDmo, null); // 初始化ECharts实例
      this.myEcharts.setOption(this.option, true); // 设置ECharts配置项
    },
    // 获取楼宇数量
    getBuildingNum() {
      request.get("/building/getBuildingName").then(res => {
        if (res.code === '0') {
          // 设置x轴数据
          this.option.xAxis.data = res.data;
          // 获取每栋楼的学生数量
          request.get("/room/getEachBuildingStuNum/" + res.data.length).then(result => {
            if (result.code === '0') {
              // 设置系列数据
              this.option.series[0].data = result.data;
            }
          });
        }
      });
    },
  }
}
</script>

<style scoped>
/* 添加你自己的样式 */
</style>
