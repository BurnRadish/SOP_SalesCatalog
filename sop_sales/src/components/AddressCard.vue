<template>
  <b-card class="mt-5">
        <b-media v-if="change === false && addNew === false">
          <h5 class="m-2"><b-icon icon="geo-alt-fill"></b-icon> ที่อยู่ในการจัดส่ง</h5>
          <b-row class="m-2">
              <b-col cols="3" class="mt-2">
                  <strong><p>{{selectAddress.name}}<br>{{selectAddress.phone}}</p></strong>
              </b-col>
              <b-col cols="8" class="mt-2">
                  {{selectAddress.address}}
              </b-col>
              <b-col cols="1">
                  <a type="button" @click="change = true">เปลี่ยน</a>
              </b-col>
          </b-row>
        </b-media>

        <!--เลือกที่อยู่จัดส่ง-->
        <b-media v-if="change === true">
          <h5 class="m-2"><b-icon icon="geo-alt-fill"></b-icon> ที่อยู่ในการจัดส่ง</h5>
          <b-row class="m-2" v-for="(data, i) in address" :key="data.id">
              <b-col cols="1">
                  <input type="radio" class="mt-4" name="select" @click='passEvent'  v-model="selectAddress" v-bind:value="{name: data.name, phone: data.phone, address: data.address}">
              </b-col>
              <b-col cols="3" class="mt-2">
                  <strong><p>{{i+1}}. {{data.name}}<br>{{data.phone}}</p></strong>
              </b-col>
              <b-col cols="8" class="mt-2">
                  {{data.address}}
              </b-col>
          </b-row>
          <div class="mt-2">
              <center>
                <b-button class="regis w-25" @click="addNew = true, change = false" v-if="addNew === false">Add new address</b-button>
                <b-button class="regis w-25" @click="reset">Cancel</b-button>
                <b-button class="login w-25" @click="change = false">Confirm</b-button>
              </center>
          </div>        
        </b-media>

        <!--เพิ่มที่อยู่-->
        <b-media v-if="addNew === true">
          <h5 class="m-2"><b-icon icon="geo-alt-fill"></b-icon> ที่อยู่ในการจัดส่ง</h5>
          <b-row class="m-2" >
              <b-col>
                    <label>ชื่อผู้รับ</label>
                    <b-form-input type="text" placeholder="กรอกชื่อผู้รับ" required v-model="name" :state="addressState" aria-describedby="input-live-help"></b-form-input>
              </b-col>
              <b-col>
                    <label>เบอร์ติดต่อ</label>
                    <b-form-input type="text" placeholder="กรอกชื่อเบอร์โทรศัพท์ที่สามารถติดต่อได้" :state="addressState" aria-describedby="input-live-help" required v-model="phone"></b-form-input>
              </b-col>
          </b-row>
          <b-row class="m-2">
                <b-col>
                    <label>สถานที่จัดส่ง</label>
                    <b-form-input type="text" placeholder="กรอกที่อยู่" :state="addressState" aria-describedby="input-live-help" required v-model="newAddress"></b-form-input>
                  <b-form-invalid-feedback id="input-live-help">
                    Please fill in all fields
                  </b-form-invalid-feedback>
                </b-col>
          </b-row>

          <div class="mt-3">
              <center>
                <b-button class="regis w-25" @click="reset, change = false, addNew = false">Cancel</b-button>
                <b-button class="login w-25" @click="addNewPersonal">Confirm</b-button>
              </center>
          </div>        
        </b-media>
      </b-card>
</template>

<script>
import axios from '../plugin/axios'
import Swal from 'sweetalert2'
export default {
  name: "AddressCard",
  props: {
    address: Array,
  },
  data(){
      return{
            change: false,
            addNew: false,
            selectAddress: {
                name: '',
                phone:'',
                address:''
            },
            email:'',
            name: '',
            phone:'',
            newAddress:''
      }
  },
  created() {
    this.email = localStorage.getItem("email")
  },
  computed: {
    addressState() {
      return this.name.length > 0 && this.phone.length > 0 && this.newAddress.length > 0 ? true : false
    },
  },
  methods:{
    reset(){
        this.change = false
        this.selectAddress.name = this.address[0].name
        this.selectAddress.phone = this.address[0].phone
        this.selectAddress.address = this.address[0].address
    },
    addNewPersonal(){
        if(this.addressState === true){
          let data = {
            email: this.email,
            name: this.name,
            phone: this.phone,
            address: this.newAddress
          }
          axios
              .post("/information/new", data)
              .then((res) => {
                if(res.data === true){
                  console.log("Success")
                  Swal.fire({
                    icon: 'success',
                    title: 'Success!',
                    confirmButtonColor: '#3085d6',
                  }).then((result) => {
                    if (result.isConfirmed) {
                      document.location.reload(true)
                    } else {
                      document.location.reload(true)
                    }
                  })
                }
              })
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
          })
        }
    },
    passEvent()
    {
      this.$emit('changeTitle', this.selectAddress)
    }
  },
  watch:{
    address: function (){
      this.selectAddress.name = this.address[0].name
      this.selectAddress.phone = this.address[0].phone
      this.selectAddress.address = this.address[0].address
    },
    selectAddress: function (){
      this.passEvent()
    }
  }
}
</script>

<style>
.login{
    background-color: #ee4d2d;
    border-color: #ee4d2d;
    color: white;
}
.login:hover{
    background-color: #ee2900;
}
.regis{
    background-color:white; 
    color: black;
    border-color: #ee4d2d;
    margin-right: 2%;
}
.regis:hover{
    background-color: #ee4d2d;
    color: white;
    border-color: #ee4d2d;
}
</style>