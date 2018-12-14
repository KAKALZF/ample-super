<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>{{password}}</h2>
    姓名:<input type="text" v-model="username">
    {{username}}
    密码:<input type="text" v-model="password">
    {{password}}
    <br>
    <input type="button" value="注册" @click="register">
    <ul>
      <li v-for="city in citise">
        {{city.name}}
      </li>
    </ul>
    <input @click="submit"> 点击获取1</input>
    <input @click="submit2"> 点击获取2</input>
    <Child></Child>

    <div class="container">
      <h2>表格</h2>
      <p> .table 为任意表格添加基本样式 (只有横向分隔线):</p>
      <table class="table">
        <thead>
        <tr>
          <th>id</th>
          <th>用户名</th>
          <th>注册时间</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="user in userList">
          <td> {{user.id}}</td>
          <td>{{user.username}}</td>
          <td>{{user.registerTime}}</td>
        </tr>
        </tbody>
      </table>
    </div>
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
        citise: [],
        userList: [],
        username: "",
        password: 'judian3321',
        msg: 'hello.vue'
      }
    },
    methods: {
      submit: function () {
        let result = null;
        alert('hello haha');
        axios.get('/static/mock/city.json')
          .then(
            res => {
              let result = res.data.data.hotCities;
              console.log(result[0]);
              this.username = result[0].name;
              this.age = result[0].spell;
              this.citise = result;
            }
          )
      },
      clickHandler: function (firstName) {
        this.age = firstName;
      },
      submit2: function () {
        let result = null;
        axios.get('/api/user/findAll')
          .then(
            res => {
              let pwd = res.data.data[0].password
              console.log(pwd);
              this.password = pwd;
              this.userList = res.data.data;
            }
          )
      },
      register: function () {
        axios({
          method: 'post',
          url: API_PATH + '/register',
          dataType: 'json',
          params: {
            username: this.username,
            password: this.password
          }
        }).then(
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
