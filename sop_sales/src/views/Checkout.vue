<template>
  <div style="height: 6em; background-color: #ee4d2d">
    <div style="padding-top: 1.5%" class="container">
      <img
        src="../assets/avg-wh.png"
        alt=""
        width="50"
        height="50"
        style="position: absolute"
      />
      <h1 style="margin-left: 5%; font-size: 24px; color: white; margin-top: 0.5%">Avenger Assemble | ทำการสั่งซื้อ</h1>
    </div>
    <div class="container">
        <AddressCard :address="address"></AddressCard>
        <ItemsList :data="items"></ItemsList>

  <b-card class="mt-4 ">
    <b-media>
      <div>
         <b-row>
             <b-col><strong>วิธีชำระเงิน</strong></b-col>
         </b-row>
         <b-row>
             <b-col>
                  <input type="radio" class="mt-4" name="select2" checked disabled value=""><label for="select2" style="padding-left: 10px">GOS Wallet</label>
             </b-col>
         </b-row>
      </div>
      
    </b-media>

    <b-card class="mt-4">
        <b-media >
            <div>
                <b-row>
                    <b-col cols="11"><strong style="font-size:24px">ยอด Wallet คงเหลือ</strong></b-col>
                    <b-col><strong style="font-size:24px">20000</strong></b-col>
                </b-row>
                <b-row>
                    <b-col cols="11">ยอดรวมราคาสินค้า</b-col>
                    <b-col>{{total}}</b-col>
                </b-row>
                <b-row>
                    <b-col cols="11">ค่าจัดส่ง</b-col>
                    <b-col>+ 10</b-col>
                </b-row>
                <b-row>
                    <b-col cols="11">การชำระเงินทั้งหมด</b-col>
                    <b-col>{{total + 10}}</b-col>
                </b-row>
             </div>
        </b-media>
    </b-card>
    <b-button class="login w-25 mt-4" style="float:right">Confirm</b-button>
  </b-card>

    </div>
  </div>
</template>

<script>
import axios from "axios"
import ItemsList from "../components/ItemsList.vue"
import AddressCard from "../components/AddressCard.vue"
export default {
    components:{
        ItemsList,
        AddressCard
    },
    data(){
        return{
            change: false,
            payment: "wallet",
            total: 0,
            email:'',
            address: [],
            items: []
        }
    },
    mounted(){
        this.email = localStorage.getItem("email")
        this.getAddress()
        this.items = JSON.parse(localStorage.getItem("Cart"))
         for(let i = 0; i < this.items.length; i++){
            this.total += this.items[i].price*this.items[i].amounts
        }
    },
    methods:{
        getAddress(){
            axios
            .post("http://localhost:9003/information", {email:this.email})
            .then((res) => {
                console.log(res)
                this.address = res.data.information[0][0].address
                console.log(this.address)
            })
        },
    }
};
</script>

<style>

</style>
