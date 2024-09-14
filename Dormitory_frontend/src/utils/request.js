import axios from 'axios'

let token = '';

/* 统一给请求加上/api前缀 */
const request = axios.create({
    baseURL: '/api',
    timeout: 5000
})

/* request 拦截器，自请求发送前对请求做一些处理，比如统一加token，对请求参数统一加密 */
{
    let onAccepted = function (config) {
        let user = JSON.parse(window.sessionStorage.getItem('access-user'));
        if (user) {
            token = user.token;
        }
        config.headers.common['token'] = token;
        //console.dir(config);
        return config;
    };

    let onRejected = function (error) {
        // Do something with request error
        console.info("error: ");
        console.info(error);
        return Promise.reject(error);
    }

    axios.interceptors.request.use(onAccepted, onRejected);
}

/* response 拦截器，可以在接口响应后统一处理结果 */
{
    let onAccepted = function (response) {
        let res = response.data;
        // 如果是返回的文件
        if (response.config.responseType === 'blob') {
            return res
        }
        // 兼容服务端返回的字符串数据
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        return res;
    }

    let onRejected = function (error) {
        console.log('err' + error) // for debug
        return Promise.reject(error)
    }

    request.interceptors.response.use(onAccepted, onRejected)
}

// 暴漏request
export default request
