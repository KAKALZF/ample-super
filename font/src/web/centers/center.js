import 'core-js/es6/promise';
import axios from 'axios';
import Vue from 'vue';
import VRouter from 'vue-router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);
Vue.use(VRouter);

const login = resolve => require(['@/components/Login.vue'], resolve);


Vue.config.productionTip = false;

const router = new VRouter({
    routes: [
        {path: '*', redirect: '/login'},
        {name: 'login', path: '/login', component: login},
    ],
});
//响应拦截器
axios.interceptors.response.use(
    res => {
        window.mytips = mytips;
        if (res.data.code == 405) {
            window.location.href = "/index.html"
        } else if (res.data.code > 0) {
            console.log("返回的响应code>0");
            // window.location.href="/index.html";
            window.location.href = "/center.html#/cardList";
        } else if (res.data.code < 0) {
            console.log("返回的响应code<0")
        }
        return res;
    },
    error => {
        mytips('连接异常');
        return Promise.reject(error);
    }
);

var app = new Vue({
    el: '#app',
    router,
    data() {
        return {
            restNum: 1,
            username: '枫16叶',
            nav: ['login', 'basic'],
        }
    },
    methods: {
        handleSelect(key, keyPath) {
            //控制导航页的页面跳转
            console.log("控制导航页的页面跳转")
            this.$router.push(keyPath);
            // console.log(key, keyPath);
        },
        skip(a) {
            console.log(a);
            this.$router.push(a)
        },
        getUser() {
            axios({
                url: API_PATH + '/user'
            }).then(res => {
                if (res.data.code == 0) {
                    console.log(res);
                    this.username = res.data.data.username
                }
            })
        },
        hasPerm(perm) {
            return this.nav.indexOf(perm) > -1 ? true : false;
        },
        handleCommand(command) {
            if (command == 'index') {
                console.log("点击子菜单", command);
                this.$router.push("/index");
            } else if (command == 'logout') {
                window.location.href = "/index.html";
            } else if (command == 'realName') {
                this.$router.push("/basic")
            }
        },
    },
    watch: {
        $route(to, from) {
            console.log("to========");
            console.log(to);
            console.log(from);
            console.log('this.$router', this.$router);
            console.log('this.$route', this.$route);
        }
    },
    computed: {
        activeNav: function () {
            // return this.$router.current.fullPath
           // console.log('改变前', this.activeNav);
            return this.$route.path;
        }
    }
})
