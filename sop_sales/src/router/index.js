
import Vue from "vue";
import VueRouter from "vue-router";
import Swal from "sweetalert2";

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
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Please login first',
        }).then((result) => {
            if (result.isConfirmed) {
                this.$router.push('/login')
            } else {
                this.$router.push('/login')
            }
        })
      next({ path: '/login' })
    } else if (to.meta.guess && isLoggedIn){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'You\'ve already logged in',
        }).then((result) => {
            if (result.isConfirmed) {
                this.$router.push('/')
            } else {
                this.$router.push('/')
            }
        })
      next({ path: '/'})
    } else if (to.meta.member && !member){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Please login first',
        }).then((result) => {
            if (result.isConfirmed) {
                this.$router.push('/login')
            } else {
                this.$router.push('/login')
            }
        })
      next({ path: '/login' })
    } else if (to.meta.admin && admin !== "admin"){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: "You don't have permission",
        }).then((result) => {
            if (result.isConfirmed) {
                this.$router.push('/login')
            } else {
                this.$router.push('/login')
            }
        })
      alert("You don't have permission")
      next({ path: '/'})
    }
  
    next()
  })

export default router