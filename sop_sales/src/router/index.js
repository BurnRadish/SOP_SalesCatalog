import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: () => import('../views/Login.vue')
    },
    {
        path: '/register',
        name: 'Regis',
        component: () => import('../views/Regis.vue')
    },
    {
        path: '/Catalog',
        name: 'Catalog',
        component: () => import('../views/Catalog.vue')
    },
    {
        path: '/Detail',
        name: 'Detail',
        component: () => import('../views/ProductDetail.vue')
    },    
    {
        path: '/Cart',
        name: 'Cart',
        component: () => import('../views/Cart.vue')
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes // short for `routes: routes`
  })

export default router