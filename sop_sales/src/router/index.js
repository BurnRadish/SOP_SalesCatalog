import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter)

const routes = [
    {
        path: '/Catalog',
        name: 'Catalog',
        component: () => import('../views/Catalog.vue')
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes // short for `routes: routes`
  })

export default router