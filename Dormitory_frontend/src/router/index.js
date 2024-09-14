// 导入 Layout 组件作为主页面的布局组件
import Layout from '../layout/Layout.vue'

// 导入 Vue Router 相关的函数
import {createRouter, createWebHistory} from "vue-router";

// 定义应用程序的路由配置
export const constantRoutes = [
    // 登录页面路由
    {path: '/Login', name: 'Login', component: () => import("@/views/Login")}, //在这个例子中,组件是通过 () => import("@/views/Login") 动态导入的。这种动态导入的方式可以实现路由组件的按需加载,提高应用程序的性能。
    // 主页面布局路由
    {
        path: '/Layout', name: 'Layout', component: Layout, children: [
            // 主页面的子路由,包括学生信息、宿舍管理员信息等
            {path: '/home', name: 'Home', component: () => import("@/views/Home")},
            {path: '/stuInfo', name: 'StuInfo', component: () => import("@/views/StuInfo")},
            {path: '/dormManagerInfo', name: 'DormManagerInfo', component: () => import("@/views/DormManagerInfo")},
            {path: '/buildingInfo', name: 'BuildingInfo', component: () => import("@/views/BuildingInfo")},
            {path: '/roomInfo', name: 'RoomInfo', component: () => import("@/views/RoomInfo")},
            {path: '/noticeInfo', name: 'NoticeInfo', component: () => import("@/views/NoticeInfo")},
            {path: '/adjustRoomInfo', name: 'AdjustRoomInfo', component: () => import("@/views/AdjustRoomInfo")},
            {path: '/repairInfo', name: 'RepairInfo', component: () => import("@/views/RepairInfo")},
            {path: '/visitorInfo', name: 'VisitorInfo', component: () => import("@/views/VisitorInfo")},
            // 个人信息相关的子路由
            {path: '/myRoomInfo', name: 'MyRoomInfo', component: () => import("@/views/MyRoomInfo")},
            {path: '/applyRepairInfo', name: 'ApplyRepairInfo', component: () => import("@/views/ApplyRepairInfo")},
            {path: '/applyChangeRoom', name: 'ApplyChangeRoom', component: () => import("@/views/ApplyChangeRoom")},
            {path: '/selfInfo', name: 'SelfInfo', component: () => import("@/views/SelfInfo")},
        ]
    },
];

// 创建 Vue Router 实例
const router = createRouter({
    routes: constantRoutes, // 包含的一个静态的路由数组
    history: createWebHistory(process.env.BASE_URL)
});

// 添加路由守卫，用来判断是否跳转页面
router.beforeEach((to, from, next) => {
    // 从 sessionStorage 获取用户信息
    const user = window.sessionStorage.getItem('user');

    // 如果访问的是登录页面,直接放行
    if (to.path === '/Login') {
        return next();
    }

    // 如果用户未登录,强制跳转到登录页面
    if (!user) {
        return next('/Login');
    }

    // 如果用户已登录,且访问的是根路径,则跳转到 home 页面
    if (to.path === '/' && user) {
        return next('/home');
    }

    // 其他情况下直接放行，就直接到下一个路由的位置
    next();
});

// 导出 Vue Router 实例
export default router;