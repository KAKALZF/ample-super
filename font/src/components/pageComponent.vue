<template>
  <div class="container">
    <ul class="pagination">
      <li class="page-item"><a class="page-link">Previous</a></li>
      <li class="page-item" v-for="n in totalPage">
        <a class="page-link">{{n}}</a>
      </li>
      <li class="page-item"><a class="page-link" href="#" @click="nextPage">Next</a></li>
    </ul>
  </div>
</template>

<script>
  import axios from 'axios';
  import $ from 'jquery';
  import bootstrap from 'bootstrap'
  import 'bootstrap/dist/css/bootstrap.min.css'

  export default {
    name: 'pageComponent',
    props: {
      totalPage: {require: true},
      initPage: {default: 1},
    },
  /*  data: function () {
      return {
        total: totalPage,
        page: initPage
      }
    },*/
    methods: {
      nextPage() {
        let page=this.initPage;
        ++page
        window.console.log("点击");
        window.console.log(page);
        /*   if (this.currPage >= this.totalPage) {
             return false;
           }*/
        this.$emit('change-page', page)
      }
    }

  }
</script>
