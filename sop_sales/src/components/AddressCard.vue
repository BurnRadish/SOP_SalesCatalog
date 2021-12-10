<template>
  <b-card class="mt-5">
        <b-media v-if="change === false">
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
                  <input type="radio" class="mt-4" name="select"  v-model="selectAddress" v-bind:value="{name: data.name, phone: data.phone, address: data.address}">
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
                <b-button class="regis w-25" @click="reset">Cancel</b-button>
                <b-button class="login w-25" @click="change = false">Confirm</b-button>
              </center>
          </div>        
        </b-media>
      </b-card>
</template>

<script>
export default {
  name: "AddressCard",
  props: {
    address: Array,
  },
  data(){
      return{
            change: false,
            selectAddress: {
                name: '',
                phone:'',
                address:''
            },
      }
  },
  mounted(){
        this.selectAddress.name = this.address[0].name
        this.selectAddress.phone = this.address[0].phone
        this.selectAddress.address = this.address[0].address
  },
  methods:{
      reset(){
            this.selectAddress.name = this.address[0].name
            this.selectAddress.phone = this.address[0].phone
            this.selectAddress.address = this.address[0].address
            this.change = false
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