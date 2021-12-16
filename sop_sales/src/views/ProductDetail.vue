<template>
  <b-container
    fluid="xl"
    v-bind:style="{ background: 'linear-gradient(45deg, red, yellow)' }"
    style="overflow: hidden;padding-top:20px"
  >
    <div class="mb-3" style="background: #ffff">
      <b-button size="lg"  class="mb-2" @click="goBack()">
        <b-icon animation="cylon" icon="box-arrow-in-left" aria-hidden="true">
        </b-icon>
        Go back
      </b-button>
        <b-row>
            <b-col cols="4">
                <b-img thumbnail fluid :src="'https://' + productDetail.urlimage">
                </b-img>
            </b-col>
            <b-col cols="8">
                <h1>{{productDetail.name}}</h1>
                <h3>{{productDetail.description}}</h3>
                <h3 style="background:#f5f5f5;width: 300px;border-radius: 15px;height: 30px;text-align: center;color: #fc9003">{{productDetail.price}}฿</h3>
                <div class="mb-3">
                    <b-input-group prepend="จำนวน" class="mb-3">
                    <b-button style="width: 40px;" @click="setAmount(0)">
                        -
                    </b-button>
                    <div style="width: 50px;">
                        <b-form-input  v-model="amount" ></b-form-input>
                    </div>
                    
                    <b-button style="width: 40px;" @click="setAmount(1)">
                        +
                    </b-button>
                </b-input-group>
                <p style="font-size: 20px; color:#b5b5b5">
                    จำนวนคงเหลือ : {{productDetail.quantity}}
                </p>
                <b-button variant="warning"  @click="addtoCart">
                    <b-icon icon="cart-plus-fill" font-scale="1.5">
                        
                    </b-icon>
                    <span>เพิ่มลงตะกร้าสินค้า</span>
                </b-button>
                </div>
                
            </b-col>
        </b-row>
    </div>
  </b-container>
</template>

<script>
import axios from 'axios';
import Swal from 'sweetalert2'
export default {
  data() {
    return {
        amount: 0,
        productDetail : {},
        Cart: [],
        addItem: {},
    };
  },
  created(){
    this.getProductDetail(this.$route.params.id);
  },
  methods:{
      setAmount : function(how){
          if(how == 0){
              if(this.amount <= 0){
                  this.amount = 0
              }
              else{
                  this.amount--
              }
          } 
          else{
              this.amount++
          }
      },
      getProductDetail(id){
        axios.get("http://localhost:4000/productDetail/" + id)
        .then((res=>{
          console.log(res.data)
          this.productDetail = res.data
        }))
      },
      setCart(){
        this.Cart = JSON.parse(localStorage.getItem("Cart"))
      },
      goBack(){
        this.$router.push({ path: `/Catalog` });
      },
      addtoCart(){
        this.addItem={
          id : this.productDetail._id,
          name : this.productDetail.name,
          description : this.productDetail.description,
          price : this.productDetail.price,
          quantity : this.productDetail.quantity,
          urlimage : this.productDetail.urlimage,
          group : this.productDetail.group,
          amounts: this.amount,
        }
        let count = 0
        
        if(this.amount == 0){
          Swal.fire({
            icon:'warning',
            text:'You have to add 1 or greater'
          })
          return 0;
        }
        else {
          if(this.Cart.length > 0){

            console.log("---this is cart---")
            console.log(this.Cart)
            for (var i=0; i<=this.Cart.length; i++){
              //ติดตรงนี้รันผ่านเพิ่มซ่ำได้แต่เพิ่มใหม่ไม่ได้ cannot read error
              if(this.Cart[i].id === this.productDetail._id){
                console.log("found same id")
                this.Cart[i].amounts += this.amount
                console.log(this.Cart[i].amounts)
                console.log(this.Cart)
                localStorage.setItem("Cart", JSON.stringify(this.Cart))
                count++
                console.log(count)
              }
            }
            //ติด error จะสิ้นจุดนี้ ไม่เพิ่ม item ใหม่
            /* console.log("---This is count after loop---")
            console.log(count)
            if(count == 0){

              this.Cart.push(this.addItem)
              localStorage.setItem("Cart", JSON.stringify(this.Cart))
            } */
          }
          console.log("---This is count after loop---")
          console.log(count)
          if(count == 0){
              this.setCart()
              this.Cart.push(this.addItem)
              localStorage.setItem("Cart", JSON.stringify(this.Cart))
            }
          } 
          /* this.objCart.push(this.Cart); */

          /* this.saveCart(); */
          // // let i = []
          // this.objCart = JSON.parse(localStorage.getItem("Product"))
          // this.Arrcart = {
          //   Product:this.productDetail,
          //   Amount :this.amount
          // }
          // // i.push(this.Arrcart)
          // this.objCart.push(this.Arrcart)
          // console.log("Hello world "+ JSON.stringify(this.productDetail))
          // localStorage.setItem("Product", JSON.stringify(this.objCart))
          // // this.objCart = localStorage.getItem("Product")
        
      },
      /* saveCart(){
        const parsed = JSON.stringify(this.objCart);
        localStorage.setItem('Products', parsed)
      } */
  },
};
</script>

<style></style>
