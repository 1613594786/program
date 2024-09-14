import { createStore } from 'vuex'
//ͳһ��״̬�������

// ����һ��Vuex״̬�����storeʵ��
export default createStore({
    // state�������洢Ӧ�ó����״̬���ݵ�
    state: {
        // isLogin��ʾ�û��Ƿ��¼��״̬
        isLogin: false,
        // identity��ʾ�û�����ݱ�ʶ
        identity: ''
    },
    // mutations�������������state״̬�ķ����ģ�ͻ��
    mutations: {
        // login�������ڽ�isLogin״̬����Ϊtrue,��ʾ�û��ѵ�¼
        login(state) {
            state.isLogin = true
        }
    },
    // actions����������ִ���첽�����������ύmutations�ķ�����
    actions: {
    },

    modules: {
        // ������Զ������ģ��
    }
})


/**
 *
 * Vuex�ṩ��һ��ͳһ��״̬�������,�������º��ĸ���:
 *
 * State��Ӧ�ü���״̬���д洢��Vuex��store�С�
 * Mutation������ Vuex store �е�״̬��Ψһ�������ύmutation��
 * Action��Action �����ύ mutation,���԰��������첽������
 *
 * **/