
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        name: 'Login',
        meta: { guess: true },
        component: () => import('../views/Login.vue')
    },
    {
        path: '/register',
        name: 'Regis',
        meta: { guess: true },
        component: () => import('../views/Regis.vue')
    },
    {
        path: '/',
        name: 'Catalog',
        component: () => import('../views/Catalog.vue')
    },
    {
        path: '/Detail/:id',
        name: 'Detail',
        component: () => import('../views/ProductDetail.vue')
    },    
    {
        path: '/Cart',
        name: 'Cart',
        meta: { member: true },
        component: () => import('../views/Cart.vue')
    },
    {
        path: '/checkout',
        name: 'Checkout',
        meta: { member: true },
        component: () => import('../views/Checkout.vue')
    },
    {
        path: '/history',
        name: 'History',
        meta: { member: true },
        component: () => import('../views/History.vue')
    },
    {
        path: '/history/:id',
        name: 'HistoryDetail',
        meta: { member: true },
        component: () => import('../views/HistoryDetail.vue')
    },
    {
        path: '/Admin',
        name: 'Admin',
        meta: { admin: "admin" },
        component: () => import('../views/Admin.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes // short for `routes: routes`
})

router.beforeEach((to, from, next) => {
    const isLoggedIn = !!localStorage.getItem('Token')
    const member = !!localStorage.getItem('Token')
    const admin = localStorage.getItem('role')

    if (to.meta.login && !isLoggedIn){
      alert('Please login first!')
      next({ path: '/login' })
    } else if (to.meta.guess && isLoggedIn){
      alert("You've already logged in")
      next({ path: '/'})
    } else if (to.meta.member && !member){
      alert('Please login first!')
      next({ path: '/login' })
    } else if (to.meta.admin && admin !== "admin"){
      alert("You don't have permission")
      next({ path: '/'})
    }
  
    next()
  })

export default router