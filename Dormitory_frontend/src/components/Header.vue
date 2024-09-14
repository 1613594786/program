<template>
  <!-- 最外层的容器,使用flexbox布局 -->
  <div style="line-height: 50px;display: flex">
    <!-- 显示系统名称的DIV,宽度为200像素,左边距10像素,字体加粗,颜色为dodgerblue -->
    <div style="width: 200px;margin-left: 10px; font-weight: bold; color: dodgerblue">高校宿舍管理系统</div>

    <!-- 显示时钟组件,字体大小为20像素,绝对定位在页面正中间 -->
    <Clock style="font-size: 20px;position: absolute;left: 50%;overflow: hidden;"/>

    <!-- 使用flex-grow:1来撑满剩余空间 -->
    <div style="flex: 1"></div>

    <!-- 右侧的个人信息区域 -->
    <div class="right-info">
      <!-- 使用Element UI的下拉菜单组件 -->
      <el-dropdown>
        <span class="el-dropdown-link">
          <!-- 显示头像图标和"个人中心"文字 -->
          <el-icon :size="18" style="float: left;margin-right: 7px;"><avatar/></el-icon>
          个人中心
          <el-icon class="el-icon--right"><arrow-down/></el-icon>
        </span>

        <!-- 下拉菜单的内容 -->
        <template #dropdown>
          <el-dropdown-menu>
            <!-- 点击"个人信息"跳转到个人信息管理页面 -->
            <el-dropdown-item @click="selfInfoManage">个人信息</el-dropdown-item>
            <!-- 点击"退出登录"执行退出登录的逻辑 -->
            <el-dropdown-item @click="SignOut">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>





<script>
import request from "@/utils/request"; // 导入请求工具
import Clock from "@/components/Clock"; // 导入时钟组件

const {ElMessage} = require("element-plus"); // 从Element UI中导入Message组件

export default {
  name: "Header", // 组件名称
  components: {
    Clock // 注册时钟组件
  },
  data() {
    return {
      name: '' // 组件的数据属性
    }
  },
  created() {
    // 组件创建时的钩子函数，钩子函数是一种特殊的函数,它可以在特定的时间点或事件触发时被系统自动调用。钩子函数通常用于扩展或定制系统的行为。
  },
  methods: {
    // 退出登录的方法
    SignOut() {
      sessionStorage.clear() // 清除session存储
      request.get("/main/signOut"); // 发送退出登录请求
      ElMessage({
        message: '用户退出登录', // 显示退出成功的消息
        type: 'success',
      });
      this.$router.replace({path: '/login'}); // 跳转到登录页面
    },
    // 跳转到个人信息管理页面
    selfInfoManage() {
      this.$router.push("/selfInfo")
    }
  },
}
</script>


<style scoped>
/* 右侧个人信息区域的样式 */
.right-info {
  width: 120px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 1.5%;
}

.right-info:hover {
  cursor: pointer; /* 鼠标悬停时变为手型 */
}
</style>