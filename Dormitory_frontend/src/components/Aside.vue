<template>
  <!-- 左侧菜单栏 -->
  <el-menu
      :default-active="this.path"
      router
      style="width: 200px; height:100%; min-height: calc(100vh - 40px)"
      unique-opened
  >
    <!-- Logo部分 -->
    <div style="display: flex;align-items: center;justify-content: center;padding: 11px 0;">
      <img alt="" src="@/assets/logo.png" style="width: 60px;">
    </div>

    <!-- 首页菜单项 -->
    <el-menu-item index="/home">
      <el-icon>
        <house/>
      </el-icon>
      <span>首页</span>
    </el-menu-item>

    <!-- 用户管理子菜单 -->
    <el-sub-menu v-if="this.judgeIdentity()!==0" index="2">
      <template #title>
        <el-icon>
          <user/>
        </el-icon>
        <span>用户管理</span>
      </template>
      <el-menu-item v-if="this.judgeIdentity()!==0" index="/stuInfo">学生信息</el-menu-item>
      <el-menu-item v-if="this.judgeIdentity()===2" index="/dormManagerInfo">宿管信息</el-menu-item>
    </el-sub-menu>

    <!-- 宿舍管理子菜单 -->
    <el-sub-menu v-if="this.judgeIdentity()!==0" index="3">
      <template #title>
        <el-icon>
          <coin/>
        </el-icon>
        <span>宿舍管理</span>
      </template>
      <el-menu-item v-if="this.judgeIdentity()!==0" index="/buildingInfo">楼宇信息</el-menu-item>
      <el-menu-item v-if="this.judgeIdentity()!==0" index="/roomInfo">房间信息</el-menu-item>
    </el-sub-menu>

    <!-- 信息管理子菜单 -->
    <el-sub-menu v-if="this.judgeIdentity()!==0" index="4">
      <template #title>
        <el-icon>
          <message/>
        </el-icon>
        <span>信息管理</span>
      </template>
      <el-menu-item v-if="this.judgeIdentity()===2" index="/noticeInfo">公告信息</el-menu-item>
      <el-menu-item v-if="this.judgeIdentity()!==0" index="/repairInfo">报修信息</el-menu-item>
    </el-sub-menu>

    <!-- 申请管理子菜单 -->
    <el-sub-menu v-if="this.judgeIdentity()!==0" index="5">
      <template #title>
        <el-icon>
          <pie-chart/>
        </el-icon>
        <span>申请管理</span>
      </template>
      <el-menu-item v-if="this.judgeIdentity()!==0" index="/adjustRoomInfo">调宿申请</el-menu-item>
    </el-sub-menu>

    <!-- 访客管理菜单项 -->
    <el-menu-item v-if="this.judgeIdentity()!==0" index="/visitorInfo">
      <svg class="icon" data-v-042ca774="" style="height: 18px; margin-right: 11px;"
           viewBox="0 0 1024 1024"
           xmlns="http://www.w3.org/2000/svg">
        <path
            d="M512 160c320 0 512 352 512 352S832 864 512 864 0 512 0 512s192-352 512-352zm0 64c-225.28 0-384.128 208.064-436.8 288 52.608 79.872 211.456 288 436.8 288 225.28 0 384.128-208.064 436.8-288-52.608-79.872-211.456-288-436.8-288zm0 64a224 224 0 110 448 224 224 0 010-448zm0 64a160.192 160.192 0 00-160 160c0 88.192 71.744 160 160 160s160-71.808 160-160-71.744-160-160-160z"
            fill="currentColor"></path>
      </svg>
      <span>访客管理</span>
    </el-menu-item>

    <!-- 我的宿舍菜单项 -->
    <el-menu-item v-if="this.judgeIdentity()===0" index="/myRoomInfo">
      <el-icon>
        <school/>
      </el-icon>
      <span>我的宿舍</span>
    </el-menu-item>

    <!-- 申请调宿菜单项 -->
    <el-menu-item v-if="this.judgeIdentity()===0" index="/applyChangeRoom">
      <el-icon>
        <takeaway-box/>
      </el-icon>
      <span>申请调宿</span>
    </el-menu-item>

    <!-- 报修申请菜单项 -->
    <el-menu-item v-if="this.judgeIdentity()===0" index="/applyRepairInfo">
      <el-icon>
        <set-up/>
      </el-icon>
      <span>报修申请</span>
    </el-menu-item>

    <!-- 个人信息菜单项 -->
    <el-menu-item index="/selfInfo">
      <el-icon>
        <setting/>
      </el-icon>
      <span>个人信息</span>
    </el-menu-item>
  </el-menu>
</template>


<script>
import request from "@/utils/request";
import {ElMessage} from "element-plus";

export default {
  name: "Aside", // 组件名称
  data() {
    return {
      user: {}, // 存储用户信息
      identity: '', // 存储用户身份
      path: this.$route.path // 当前路由路径
    }
  },
  created() {
    this.init() // 组件创建时初始化数据
  },
  methods: {
    init() {
      // 加载用户身份信息
      request.get("/main/loadIdentity").then((res) => {
        if (res.code !== "0") {
          ElMessage({
            message: '用户会话过期',
            type: 'error',
          });
          sessionStorage.clear() // 清除会话
          request.get("/main/signOut"); // 退出登录
        }
        window.sessionStorage.setItem("identity", JSON.stringify(res.data));
        this.identity = res.data // 设置身份信息
      });
      // 加载用户详细信息
      request.get("/main/loadUserInfo").then((result) => {
        // 检查响应状态码是否为 "0"，表示请求成功
        if (result.code !== "0") {
          // 如果请求失败，显示一个错误消息
          ElMessage({
            message: '用户会话过期',
            type: 'error',
          });

          // 调用退出登录接口
          request.get("/main/signOut");

          // 清除会话存储
          sessionStorage.clear();

          // 跳转到登录页面
          this.$router.replace({path: "/login"});
        }

        // 将用户信息存储到会话存储中
        window.sessionStorage.setItem("user", JSON.stringify(result.data));
        // Session Storage 是浏览器提供的一种临时数据存储机制，数据只存在于当前会话(session)中,当浏览器关闭后,存储的数据就会自动清除。

        // 将用户信息设置到组件的 data 属性中
        this.user = result.data;
      });
    },
    // 判断用户身份
    judgeIdentity() {
      if (this.identity === 'stu') {
        return 0 // 学生
      } else if (this.identity === 'dormManager') {
        return 1 // 宿管
      } else
        return 2 // 管理员
    }
  },
}
</script>



<style scoped>
/* 定义图标的样式 */
.icon {
  margin-right: 6px; /* 图标与文字之间的间距 */
}

/* 针对 el-sub-menu 内部的 el-menu-item 进行样式设置 */
.el-sub-menu .el-menu-item {
  height: 50px; /* 菜单项的高度 */
  line-height: 50px; /* 文字的行高,与高度一致使文字垂直居中 */
  padding: 0 45px; /* 文字距离左右边缘的距离 */
  min-width: 199px; /* 最小宽度 */
}
</style>