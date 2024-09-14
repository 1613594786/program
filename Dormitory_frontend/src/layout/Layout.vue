<template>
  <!-- 整体布局使用 el-container 组件 -->
  <el-container>

    <!-- 侧边功能栏区域 -->
    <el-aside width="200px">
      <!-- 引入侧边栏组件 Aside -->
      <Aside/>

    </el-aside>

    <!-- 主体内容区域 -->
    <el-container>
      <!-- 头部区域 -->
      <el-header style="height: 50px;border-bottom: 1px solid #ccc;">
        <!-- 引入头部组件 Header -->
        <Header/>
      </el-header>
      <!-- 主要内容区域 -->
      <el-main style="padding: 0;">
        <!-- 使用 router-view 组件渲染当前路由匹配的组件 ，路由的内置组件-->
        <router-view/>
      </el-main>
    </el-container>

  </el-container>

</template>




<script>
// 导入头部和侧边栏组件
import Header from "@/components/Header";
import Aside from "@/components/Aside";

// 从 element-plus 中解构出 ElMessage 组件
const {ElMessage} = require("element-plus");

/**
 *
 * element-plus包含了各种常用的UI组件,如按钮、表单、表格、弹窗等,并提供了丰富的样式和交互效果。
 *
 * 在上面的代码中,{ElMessage}是从element-plus中导入的一个组件,它提供了一个消息提示框的功能。显示各种类型的消息提示。
 *
 **/

export default {
  name: "layout", // 组件名称
  components: {
    // 注册头部和侧边栏组件
    Header,
    Aside,
  },
}
</script>


<style scoped>
/* 添加组件级的 CSS 样式 */
</style>