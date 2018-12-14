<template>
  <div class="hello" style="background:#98bf21;height:100px;width:100px;position:absolute;">
    <input @click="submit2"> 点击获取2</input>
    <ul>
      <li v-for="user in userList">{{user.username}}</li>
    </ul>
    <h1>{{count}}</h1>
    <button>开始动画</button>
    <!--<customCom time=this.now></customCom>-->
    <!-- 动态props,通过v-bind绑定数据-->
    <customCom v-bind:time="now"></customCom>
  </div>

</template>

<script>
  import axios from 'axios';
  import Vue from 'vue'
  import jquery from '../../static/js/jquery.min'
  /*
    window.onload = function () {
      alert('文档加载完毕');
    }
  */
  Vue.component('customCom', {
    props: ['time'],
    template: '<h1>现在时间:{{time}}</h1>'
  })
  ;
  $(document).ready(function () {
    $("button").click(function () {
      $("div").animate({left: '250px'});
    });
  });
  export default {
    name: 'user',
    data: function () {
      return {
        userList: [],
        now: '',
        count: 10
      }
    },
    methods: {
      submit2: function () {
        let result = null;
        axios.get('/api/hello/kaka')
          .then(
            res => {
              this.userList = res.data.data;
              let time = new Date();
              this.now = time;
              let interval = setInterval(function () {
                this.count--;
              }, 1000)
            }
          )
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
