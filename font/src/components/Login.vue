<template>
  <div class="hello">
    姓名:<input type="text" v-model="name">
    密码:<input type="text" v-model="password">
    <input type="button" value="登录" @click="login">
    <Child></Child>

  </div>
</template>

<script>
  import axios from 'axios';

  var Child = {
    template: '<h1>自定义组件!</h1>'
  }
  export default {
    name: 'Login',
    components: {Child},
    data: function () {
      return {
        password: '123654',
        name: 'kakaUpate'
      }
    },
    methods: {
      login: function () {
        console.log("登录请求");
        axios.post(API_PATH + '/login',
          {
            name: this.name,
            password: this.password
          }
        ).then(
          res => {
            console.log(res)
          },
        );
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }
</style>
