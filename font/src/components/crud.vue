<template>
  <div>
    <div class="container">
      <h2>CRUD</h2>
      <table class="table">
        <thead>
        <tr>
          <th>用户名</th>
          <th>年龄</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="user in userList">
          <td> {{user.name}}</td>
          <td>{{user.age}}</td>
          <td>
            <button type="button" class="btn btn-success" @click="add">增加</button>
            <button type="button" class="btn btn-warning">修改</button>
            <button type="button" class="btn btn-danger" @click="deleteUser">删除</button>
          </td>
        </tr>
        </tbody>
      </table>
      <div class="container" style="padding: 100px 50px 10px;" >
        <button type="button" class="btn btn-default" title="Popover title"
                data-container="body" data-toggle="popover" data-placement="left"
                data-content="左侧的 Popover 中的一些内容">
          左侧的 Popover
        </button>
        <button type="button" class="btn btn-primary" title="Popover title"
                data-container="body" data-toggle="popover" data-placement="top"
                data-content="顶部的 Popover 中的一些内容">
          顶部的 Popover
        </button>
        <button type="button" class="btn btn-success" title="Popover title"
                data-container="body" data-toggle="popover" data-placement="bottom"
                data-content="底部的 Popover 中的一些内容">
          底部的 Popover
        </button>
        <button type="button" class="btn btn-warning" title="Popover title"
                data-container="body" data-toggle="popover" data-placement="right"
                data-content="右侧的 Popover 中的一些内容">
          右侧的 Popover
        </button>
      </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  import $ from 'jquery';
  import bootstrap from  'bootstrap'
//  import 'bootstrap/dist/js/popover.js';
  import 'bootstrap/dist/css/bootstrap.min.css'

  $(function () {
    $("[data-toggle='popover']").popover();
  });

  var Child = {
    template: '<h1>自定义组件!</h1>'
  }
  export default {
    name: 'crud',
    components: {Child},
    data: function () {
      return {
        userList: [{"name": "林", "age": 18}, {"name": "卡卡", "age": 17}],
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
      add() {
        this.userList.push({"name": "kaka", "age": 22});
      },
      deleteUser() {
        this.userList.pop({"name": "kaka", "age": 22});
      }
    },
    mounted() {

//        window.console.log("已加载")
//        console.log($("#test"));
//        $("#test").popover();
   /*   $('[data-toggle="popover"]').popover()*/
    }
  }
</script>
