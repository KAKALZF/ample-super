import 'core-js/es6/promise';
import Vue from 'vue';
import axios from 'axios';

const login = resolve => require(['@/components/Login.vue'], resolve);

Vue.config.productionTip = false;

new Vue({
  el: '#app',
  components: {login},
});
