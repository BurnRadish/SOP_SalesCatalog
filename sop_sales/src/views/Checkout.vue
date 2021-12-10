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
                <b-button class="regis w-25" @click="mount()">Cancel</b-button>
                <b-button class="login w-25" @click="change = false">Confirm</b-button>
              </center>
          </div>        
        </b-media>
      </b-card>

  <b-card class="mt-4">
    <b-media>
      <div>
          <b-row>
              <b-col cols="6"><strong>ชื่อสินค้า</strong></b-col>
              <b-col cols="2"><strong>ราคาต่อหน่วย</strong></b-col>
              <b-col cols="2"><strong>จำนวน</strong></b-col>
              <b-col cols="2"><strong>ราคารวม</strong></b-col>
          </b-row>
          <b-row class="mt-5" v-for="(data) in items" :key="data.id">
              <b-col cols="6">
                  <img
                    :src="data.url"
                    alt=""
                    width="50"
                    height="50"
                    style="display: inline-block"
                    />
                  <h5 class="ml-5" style="display: inline-block; margin-left: 2%">{{data.name}}</h5>
              </b-col>
              <b-col cols="2">{{data.price}}</b-col>
              <b-col cols="2">{{data.quantity}}</b-col>
              <b-col cols="2">{{data.price*data.quantity}}</b-col>
          </b-row>
      </div>
      
    </b-media>
  </b-card>

  <b-card class="mt-4">
    <b-media>
      <div>
         <b-row>
             <b-col><strong>วิธีชำระเงิน</strong></b-col>
         </b-row>
         <b-row>
             <b-col>
                 <b-col >
                  <input type="radio" class="mt-4" name="select2" checked disabled value=""><label for="select2" style="padding-left: 10px">GOS Wallet</label>
                 </b-col>
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
    <b-button class="login w-25 mt-5" style="float:right">Confirm</b-button>
  </b-card>

    </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            change: false,
            payment: "wallet",
            total: 0,
            selectAddress: {
                name: '',
                phone:'',
                address:''
            },
            address: [
                {
                    id: 1,
                    name: "test",
                    phone: "0123456789",
                    address: "2018  THOROUGHBRED HENDERSON NV 89002-8765 USA"
                },
                {
                    id: 2,
                    name: "test",
                    phone: "0123456789",
                    address: "996  PERFECT BERM HENDERSON NV 89002-3318 USA"
                },
                {
                    id: 3,
                    name: "test",
                    phone: "0123456789",
                    address: "625  WHITNEY RANCH HENDERSON NV 89014-2628 USA"
                }
            ],
            items: [
                {
                    id: 1,
                    name: "ถุงยาง",
                    price: 99,
                    quantity: 3,
                    url: "https://medthai.com/images/2015/10/%E0%B8%96%E0%B8%B8%E0%B8%87%E0%B8%A2%E0%B8%B2%E0%B8%87.jpg"
                },
                {
                    id: 2,
                    name: "กางเกงในใจเกเร",
                    price: 999,
                    quantity: 1,
                    url: "https://cf.shopee.co.th/file/969e0b7969e7c88add4931893caf4657"
                },
            ]
        }
    },
    mounted(){
        this.selectAddress.name = this.address[0].name
        this.selectAddress.phone = this.address[0].phone
        this.selectAddress.address = this.address[0].address
        for(let i = 0; i < this.items.length; i++){
            this.total += this.items[i].price*this.items[i].quantity
        }
    }
};
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
