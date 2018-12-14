<template>
  <div class="header">
    <div class="header-left">
      <span class="iconfont">&#xe624;</span>
    </div>
    <div class="header-input">
      <span class="iconfont">&#xe632;</span>
      输入城市/景点/主题
    </div>
    <div class="header-right">
      省份<span class="iconfont">&#xe62d;</span>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'HomeHeader',
    data () {
      return {
        msg: 'hello.vue'
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="stylus" scoped>
  @import '~@/assets/styles/variable.styl'
  .header
    line-height: 1.86rem
    background: $bgColor
    color: #fff
    display: flex
    .header-left
      float: left
    .header-input
      flex:1
      background:#fff
      color: #ccc
      margin-top: .2rem
      margin-left: .2rem
      margin-right: .2rem
      margin-bottom: .2rem
    .header-right
       float: right
       text-align:center

</style>
