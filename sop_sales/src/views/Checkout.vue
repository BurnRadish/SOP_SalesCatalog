<template>
  <div style="height: 6em; background-color: #ee4d2d">
    <div style="padding-top: 1.5%" class="container">
      <a href="/">
        <img
            src="../assets/avg-wh.png"
            alt=""
            width="50"
            height="50"
            style="position: absolute"
        />
      </a>

      <h1 style="margin-left: 5%; font-size: 24px; color: white; margin-top: 0.5%">GOS Shop&Sales | ทำการสั่งซื้อ</h1>
    </div>
    <div class="container">
        <AddressCard :address="address" @changeTitle="ChangeT($event)"></AddressCard>
        <ItemsList :data="items"></ItemsList>

  <b-card class="mt-4 ">
    <b-media>
      <div>
         <b-row>
             <b-col><strong>วิธีชำระเงิน</strong></b-col>
         </b-row>
         <b-row>
             <b-col>
                  <input type="radio" class="mt-4" name="select2" checked disabled value=""><label style="padding-left: 10px">GOS Wallet</label>
             </b-col>
         </b-row>
      </div>
      
    </b-media>

    <b-card class="mt-4">
        <b-media >
            <div>
                <b-row v-if="wallet >= total">
                    <b-col cols="10"><strong style="font-size:20px; color: lime">ยอด Wallet คงเหลือ</strong></b-col>
                    <b-col><strong style="font-size:20px;color: lime; float: right;">{{ wallet }}</strong></b-col>
                </b-row>
                <b-row v-else>
                  <b-col cols="11"><strong style="font-size:20px; color: red">ยอด Wallet คงเหลือไม่เพียงพอ</strong></b-col>
                  <b-col><strong style="font-size:20px;color: red">{{ wallet }}</strong></b-col>
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
    <b-button class="login w-25 mt-4" style="float:right" @click="confirmOrder()">Confirm</b-button>
  </b-card>

    </div>
  </div>
</template>

<script>
import axios from "../plugin/axios"
import ItemsList from "../components/ItemsList.vue"
import AddressCard from "../components/AddressCard.vue"
import Swal from "sweetalert2";
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
            wallet: 0,
            navWallet: 0,
            selectAddress:{
              name:'',
              phone:'',
              address:''
            },
            items: []
        }
    },
    mounted(){
        this.email = localStorage.getItem("email")
        this.getData()
        this.items = JSON.parse(localStorage.getItem("Cart"))
         for(let i = 0; i < this.items.length; i++){
            this.total += this.items[i].price*this.items[i].amounts
        }
    },
    methods:{
        getData(){
            axios
            .get("/information")
            .then((res) => {
              this.wallet = res.data.information[0][0].wallet
                this.address = res.data.information[0][0].address
            })
        },
        confirmOrder() {
          if(this.wallet >= this.total){
            console.log("Click confirm")
            let data = {
              tran: this.items,
              address: this.selectAddress.address,
              resultPrice: this.total,
              email: this.email,
            };
            axios
                .post("/finish", data)
                .then((res) => {
                  console.log(res);
                  if (res.status === 200) {
                    Swal.fire({
                      icon: "success",
                      title: "สั่งซื้อสำเร็จ",
                      text: "ชำระเงินเสร็จแล้ว รอการติดต่อจากทางร้านได้เลย!!",
                      confirmButtonText: "กลับไปหน้าหลัก",
                    }).then((result) => {
                      /* Read more about isConfirmed, isDenied below */
                      if (result.isConfirmed) {
                        //ใส่เงื่อนไขตรงนี้ pushhh
                        localStorage.setItem("Cart", JSON.stringify([]))
                        this.navWallet = localStorage.getItem("wallet")
                        this.navWallet = this.navWallet-this.total
                        localStorage.setItem("wallet", this.navWallet)
                        location.replace("http://localhost:8080")
                      }
                    })
                  }
                })
          } else {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text:'Your money in wallet is not enough'
            })
          }
      },
      ChangeT(address)
      {
        this.selectAddress = address;
      }
    },
  watch:{
      address: function (){
        this.selectAddress.name = this.address[0].name
        this.selectAddress.phone = this.address[0].phone
        this.selectAddress.address = this.address[0].address
      }
  }
};
</script>

<style>

</style>
