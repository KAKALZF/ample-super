import Vue from 'vue'
import Router from 'vue-router'
import User from '@/components/User'
import Login from '@/components/Login'
import crud from '@/components/crud'
import page from '@/components/page'
import basic from '@/components/basic'
import Home from '@/page/home/Home'
import navigation from '@/components/navigation'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/user',
      name: 'user',
      component: User
    },
    {
      path: '/crud',
      name: 'crud',
      component: crud
    },
    {
      path: '/page',
      name: 'page',
      component: page
    },
    {
      path: '/basic',
      name: 'basic',
      component: basic
    },
    {
      path: '/navigation',
      name: 'navigation',
      component: navigation
    }
  ]
})
