import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/users',
    name: 'users',
    component: () => import('../components/User/UserList.vue')
  },
  {
    path: '/users/:id',
    name: 'user-details',
    component: () => import('../components/User/UserDetails.vue')
  },
  {
    path: '/add',
    name: 'add',
    component: () => import('../components/User/AddUser.vue')
  },
  {
    path: '/signin',
    name: 'signin',
    component: () => import('../components/Auth/Login.vue')
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('../components/Auth/Register.vue')
  },
  {
    path: '/adminView',
    name: 'adminView',
    component: () => import('../components/AdminView.vue')
  },
  {
    path: '/categories',
    name: 'category',
    component: () => import('../components/Booking/CategoryView.vue')
  },
  {
    path: '/features',
    name: 'feature',
    component: () => import('../components/Booking/FeaturesView.vue')
  },
  {
    path: '/roomAvailable',
    name: 'available',
    component: () => import('../components/Booking/RoomAvailable.vue')
  },
  {
    path: '/bookRoom',
    name: 'bookroom',
    component: () => import('../components/Booking/BookRoom.vue')
  },
  {
    path: '/bookingView',
    name: 'booking',
    component: () => import('../components/Booking/BookingView.vue')
  },
  {
    path: '/usersView',
    name: 'usersView',
    component: () => import('../components/UserView.vue')
  },
  {
    path: '/',
    name: 'home',
    component: () => import('../components/Home.vue')
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../components/Home.vue')
  },
  {
    path: '/roomManagement',
    name: 'roomManagement',
    component: () => import('../components/Admin/RoomManagement.vue')
  },
  {
    path: '/addRoom',
    name: 'addRoom',
    component: () => import('../components/Admin/AddRoom.vue')
  },
  {
    path: '/component',
    name: 'component',
    component: () => import('../components/Component.vue')
  },
  {
    path: '/profile',
    name: 'profile',
    component: () => import('../components/Profile.vue')
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
