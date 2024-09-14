import { createStore } from 'vuex'
//统一的状态管理机制

// 创建一个Vuex状态管理的store实例
export default createStore({
    // state是用来存储应用程序的状态数据的
    state: {
        // isLogin表示用户是否登录的状态
        isLogin: false,
        // identity表示用户的身份标识
        identity: ''
    },
    // mutations是用来定义更改state状态的方法的，突变
    mutations: {
        // login方法用于将isLogin状态设置为true,表示用户已登录
        login(state) {
            state.isLogin = true
        }
    },
    // actions是用来定义执行异步操作并可以提交mutations的方法的
    actions: {
    },

    modules: {
        // 这里可以定义各种模块
    }
})


/**
 *
 * Vuex提供了一个统一的状态管理机制,包括以下核心概念:
 *
 * State：应用级的状态集中存储在Vuex的store中。
 * Mutation：更改 Vuex store 中的状态的唯一方法是提交mutation。
 * Action：Action 用于提交 mutation,可以包含任意异步操作。
 *
 * **/