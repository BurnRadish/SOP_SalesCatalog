<template>
  <div id="app">
  <b-navbar toggleable="lg" type="light" variant="warning" v-if="$route.name !== 'Login' && $route.name !== 'Regis' && $route.name !== 'Checkout'&& $route.name !== 'History'&& $route.name !== 'HistoryDetail'">
    <div style="padding-right:100px"> </div>
    <b-navbar-brand to="/" class="py-2">SHOP</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
    <div style="padding-right: 70%"> </div>
    <b-collapse id="nav-collapse" is-nav right>
      <b-navbar-nav>
        <b-nav-item to="Cart" >Cart</b-nav-item>
        <b-nav-item to="Checkout">Checkout</b-nav-item>
        <div v-if="role === 'admin'" >
              <b-nav-item to="Admin">Admin</b-nav-item>
        </div>
        
      </b-navbar-nav>


      <b-navbar-nav class="ml-auto"  style="float: right;">

        <b-nav-item-dropdown v-if="login === true" class="dropleft">

          <template #button-content>
            <em>User</em>
          </template>
              <b-dropdown-text > สถานนะ :{{ role }} </b-dropdown-text>
              <b-dropdown-text > User: {{ email }} </b-dropdown-text>
              <b-dropdown-item @click="$router.push({ path: `/history`})">History</b-dropdown-item>
              <b-dropdown-item @click="signOut">Sign Out</b-dropdown-item>

              <!-- <b-dropdown-item @click="signIn">Sign in</b-dropdown-item> -->
        </b-nav-item-dropdown>
        <div v-else>
            <b-button variant="success" @click="signIn">Sign in </b-button>
        </div>
        
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
        email:null,
        role:null,
        login: false
      }
  },
  created() {
    this.email = localStorage.getItem("email")
    this.role = localStorage.getItem("role")
    console.log("helo "+this.email)
    console.log("helo2 "+this.role)
  },
  // mounted() {
  // },
  watch:{
    email: function(val){
        console.log("watch new 1 "+val + "watch old 2 "+ val)
        this.login = !this.login

    },
  },
  methods: {
    signOut(){
      localStorage.clear();
      // this.$router.push({ path: `/`})
      this.email = '';
      this.role = '';
    },
    signIn(){
      this.$router.push({ path: `/login`})
      // this.email = '';
      // this.role = '';
    
    }
  },
}
</script>

<style>
body {
  background-image: url('https://images.pexels.com/photos/1323550/pexels-photo-1323550.jpeg');
}
</style>
