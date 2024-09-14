<template>
  <el-container>
    <span>{{ dateFormat(date) }}</span> <!--数据绑定，数据格式化-->
  </el-container>
</template>

<script>
//创建一个函数来增加月日时小于10在前面加0
const padaDate = function (value) {
  return value < 10 ? '0' + value : value;
};
export default {
  name: 'clock',
  data() {
    return {
      // 当前时间
      date: new Date()
    }
  },

// 挂载时间
  mounted() {
    //获取当前日期
    let that = this;
    // 创建一个定时器,每隔 1 秒钟执行一次回调函数
    this.timer = setInterval(function () {
      // 获取当前时间,并格式化为本地化的字符串
      that.date = new Date().toLocaleString();
    }, 1000);
  },
  methods: {
    //当前日期格式化
    dateFormat() {
      const date = new Date();
      const year = date.getFullYear();
      const month = date.getMonth() + 1 < 10 ?
          '0' + (date.getMonth() + 1) : date.getMonth() + 1; // 判断下一个月到底是1位数还是2位数
      const day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
      const hours = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
      const minutes = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
      const seconds = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
      return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds
    }
  }
}
</script>