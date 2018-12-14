<template>
  <swiper :options="swiperOption">
    <!-- slides -->
    <swiper-slide>
      <img class="swiper-img"
           src="http://img1.qunarzz.com/piao/fusion/1805/e5/59fad13a64807d02.jpg_750x200_713ae984.jpg"/>
    </swiper-slide>
    <swiper-slide>
      <img class="swiper-img"
           src="http://img1.qunarzz.com/piao/fusion/1804/f2/91b285a08ee21c02.jpg_750x200_8a73fd08.jpg"/>
    </swiper-slide>
    <swiper-slide>
      <img class="swiper-img"
           src="http://img1.qunarzz.com/piao/fusion/1805/a8/c49ed2bbbdbce402.jpg_750x200_818d911d.jpg"/>
    </swiper-slide>
    <!-- Optional controls -->
    <div class="swiper-pagination" slot="pagination"></div>
  </swiper>
</template>

<script>
  export default {
    name: 'HeaderSwiper',
    data: function () {
      return {
        swiperOption: {
          pagination:'.swiper-pagination',
          /*开启循环拉取*/
          loop:true
        }
      }
    }
  }
</script>

<style lang="stylus" scoped>
   .swiper-img
     width:100%
</style>
