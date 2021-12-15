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
                <b-button variant="warning" >
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
export default {
  data() {
    return {
        amount: 0,
        productDetail : {},
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
      goBack(){
        this.$router.push({ path: `/Catalog` });
      }
  },
};
</script>

<style></style>
