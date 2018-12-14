<template>
  <div class="hello">
    <home-header></home-header>
    <header-swiper></header-swiper>
    <navigation></navigation>
  </div>
</template>

<script>
  import HomeHeader from './components/Header.vue'
  import HeaderSwiper from './components/Swiper.vue'

  export default {
    name: 'Home',
    components: {
      HomeHeader,
      HeaderSwiper,
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }
</style>
