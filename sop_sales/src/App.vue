<template>
  <div id="app">
  <b-navbar toggleable="lg" type="light" variant="warning" v-if="$route.name !== 'Login' && $route.name !== 'Regis' && $route.name !== 'Checkout'&& $route.name !== 'History'&& $route.name !== 'HistoryDetail'">
    <div style="padding-right:30px"> </div>
    <b-navbar-brand to="/" class="py-2">SHOP</b-navbar-brand>

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

        <b-nav-item-dropdown right v-if="login === true">

          <template #button-content>
            <em>User</em>
          </template>
              <b-dropdown-text > สถานนะ :{{ role }} </b-dropdown-text>
              <b-dropdown-text > User: {{ email }} </b-dropdown-text>
              <b-dropdown-item @click="signOut">Sign Out</b-dropdown-item>

              <!-- <b-dropdown-item @click="signIn">Sign in</b-dropdown-item> -->
        </b-nav-item-dropdown>
        <div v-if="!login">
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
        email:'',
        role:'',
        login: false
      }
  },
  created() {
    this.email = localStorage.getItem("email")
    this.role = localStorage.getItem("role")
    console.log("helo "+this.email)
    console.log("helo2 "+this.role)
    this.login = true;
  },
  // mounted() {
  // },
  // watch:{
  //   email: function(val, oldval){
  //       console.log("watch new 1 "+val + "watch old 2 "+ oldval)
  //       this.email = val
  //   },
  // },
  methods: {
    signOut(){
      localStorage.clear();
      // this.$router.push({ path: `/`})
      this.login = false;
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
