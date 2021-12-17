<template>
  <div>
    <b-card
      title="เข้าสู่ระบบ"
      style="max-width: 25rem"
      class="mb-2 mt-5"
      v-if="regis === false">
      <b-card-text class="mt-3">
        <b-form @submit.stop.prevent>
          <label for="text-username">Username</label>
          <b-form-input
            type="text"
            id="text-username"
            placeholder="Enter your username"
            v-model="email"
          ></b-form-input>

          <label for="text-password" class="mt-3">Password</label>
          <b-form-input
            type="password"
            id="text-password"
            placeholder="Enter your password"
            v-model="password"
          ></b-form-input>
        </b-form>
      </b-card-text>

      <b-button href="#" class="w-100 mt-3 login" @click="login">Sign In</b-button>
      <b-row class="mt-3">
        <b-col cols="5"><hr /></b-col>
        <b-col>หรือ</b-col>
        <b-col cols="5"><hr /></b-col>
      </b-row>
      <b-button
        href="#"
        class="w-100 mt-2 regis"
        @click="$router.push('register')"
        >Sign Up</b-button
      >
      <center class="mt-2">
        <b-form-text
          >ลืมรหัสผ่านงั้นหรอ
          <a href="/register" style="text-decoration: none; color: #ee4d2d">สมัครใหม่</a> สิ555555</b-form-text
        >
      </center>
    </b-card>

    <b-card title="สมัครสมาชิก" style="max-width: 25rem" class="mb-2 mt-5" v-else>
      <b-card-text class="mt-3">
        <b-form @submit.stop.prevent>
          <label for="text-username">Username</label>
          <b-form-input
            type="text"
            id="text-username"
            placeholder="Enter your username"
            v-model="email"
          ></b-form-input>

          <label for="text-password" class="mt-3">Password</label>
          <b-form-input
            type="password"
            id="text-password"
            placeholder="Enter your password"
            v-model="password"
          ></b-form-input>

          <label for="text-conpassword" class="mt-3">Confirm Password</label>
          <b-form-input
            type="password"
            id="text-conpassword"
            placeholder="Enter your password again"
          ></b-form-input>
        </b-form>
      </b-card-text>

      <b-button href="#" variant="primary" class="w-100 mt-3 login" @click="register"
        >Confirm</b-button
      >
    </b-card>
  </div>
</template>

<script>
import axios from "../plugin/axios";
import Swal from 'sweetalert2'
export default {
  name: "Card",
  props: {
    regis: Boolean,
  },
  data(){
    return{
      email:'',
      password:'',
    }
  },
  methods:{
    login(){
      axios
          .post('/auth/login', { email: this.email, password: this.password})
          .then((res) => {
            localStorage.setItem("Token", res.data.accessToken)
            localStorage.setItem("email", res.data.email)
            localStorage.setItem("role", res.data.role)
            if(res.status === 200){
              this.$router.push('/')
            } else {
              Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Your email or password is incorrect',
              })
            }

            console.log(res)
          })
    },
    register(){
      axios
          .post('/auth/register', { email: this.email, password: this.password})
          .then((res) => {
            if(res.data.success === true){
              Swal.fire({
                    icon: 'success',
                    title: 'Success!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        this.$router.push('login')
                    } else {
                        this.$router.push('login')
                    }
              })
            } else {
              Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Your email is already used',
              })
            }
            console.log(res.data.success)
          })
    }
  }
};
</script>

<style>
.regis{
    background-color:white; 
    color: black;
    border-color: #ee4d2d;
}
.regis:hover{
    background-color: #ee4d2d;
    color: white;
    border-color: #ee4d2d;
}
.login{
    background-color: #ee4d2d;
    border-color: #ee4d2d;
    color: white;
}
.login:hover{
    background-color: #ee2900;
}
</style>
