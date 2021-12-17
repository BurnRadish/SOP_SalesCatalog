<template>
  <div id="app">
  <b-navbar toggleable="lg" type="light" variant="warning" v-if="$route.name !== 'Login' && $route.name !== 'Regis' && $route.name !== 'Checkout'&& $route.name !== 'History'&& $route.name !== 'HistoryDetail'">
    <b-navbar-brand to="/" class="mb-0">SHOP</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/">Home</b-nav-item>
        <b-nav-item to="Cart" >Cart</b-nav-item>
        <b-nav-item to="Checkout">Checkout</b-nav-item>
        <div v-if="role === 'admin'" >
              <b-nav-item to="Admin">Admin</b-nav-item>
        </div>
        
      </b-navbar-nav>


      <b-navbar-nav class="ml-auto"  style="float: right;">

        <b-nav-item-dropdown right>

          <template #button-content>
            <em>User</em>
          </template>
          <b-dropdown-item > {{ role }} </b-dropdown-item>
          <b-dropdown-item > {{ email }} </b-dropdown-item>
          <b-dropdown-item @click="signOut">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>

  </b-navbar>

  <router-view :key="$route.fullPath" />

  </div>
</template>

<script>


export default {
  name: 'App',
  data() {
      return{
        email:'',
        role:'',
      }
  },
  created() {
    this.email = localStorage.getItem("email")
    this.role = localStorage.getItem("role")
    console.log("helo "+this.email)
    console.log("helo2 "+this.role)
  },
  methods: {
    signOut(){
      localStorage.clear();
      this.$router.push({ path: `/login`})
    }
  },
}
</script>

<style>
body {
  background-image: url('https://images.pexels.com/photos/1323550/pexels-photo-1323550.jpeg');
}
</style>
