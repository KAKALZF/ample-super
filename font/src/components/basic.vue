<template>
  <div>
    <div>
      <h1 v-show="isLogin">若隐若现 {{number}}</h1>
      <button type="button" @click="changeStatus">点击</button>
      {{fullName}}
    </div>
    <div>
      千米：<input type="text" v-model="kilometer"/>
      米：<input type="text" v-model="meter"/>
    </div>
  </div>

</template>

<script>
  import axios from 'axios';
  import $ from 'jquery';
  import bootstrap from 'bootstrap'
  import 'bootstrap/dist/css/bootstrap.min.css'


  export default {
    name: 'basic',
    data: function () {
      return {
        userList: [{"name": "林", "age": 18}, {"name": "卡卡", "age": 17}],
        isLogin: true,
        number: 0,
        firstName: "kaka",
        lastName: "Ricardo",
        meter: 0,
        kilometer: 0
      }
    },
    methods: {
      changeStatus: function () {
        let random = Math.random();
        this.number = random;
        this.isLogin = !this.isLogin;
        this.fullName = "lin 泽 风"
      }
    },
    computed: {
      fullName: {
        get: function () {
          return this.firstName + this.lastName;
        },
        set: function (newName) {
          let names = newName.split(" ");
          this.firstName = names[0];
          this.lastName = names[names.length - 1];
        }
      }

    },
    watch: {
      meter: function (val) {
        this.meter = val;
        this.kilometer = val / 1000;
      },
      kilometer: function (val) {
        this.kilometer = val;
        this.meter = val * 1000;
      }
    }
  };
/*  this.$watch(this.kilometer, function (newValue, oldValue) {
    document.write("新值:" + newValue);
    document.write("旧值:" + oldValue);
  })*/

</script>
