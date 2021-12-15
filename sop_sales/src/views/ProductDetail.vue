<template>
  <b-container
    fluid="xl"
    v-bind:style="{ background: 'linear-gradient(45deg, red, yellow)' }"
    style="overflow: hidden;padding-top:20px"
  >
    <div class="mb-3" style="background: #ffff">
      <b-button size="lg"  class="mb-2">
        <b-icon animation="cylon" icon="box-arrow-in-left" aria-hidden="true">
        </b-icon>
        Go back
      </b-button>
        <b-row>
            <b-col cols="4">
                <b-img thumbnail fluid src="https://cdn.pixabay.com/photo/2018/10/04/19/46/dog-3724261_960_720.jpg" alt="Image 1">
                </b-img>
            </b-col>
            <b-col cols="8">
                <h1>ชิบะ อิจิ</h1>
                <h3>คำอธิบายตรงนี้ : หมาชนิดหนึ่ง มีถิ่นดำเนิดในญี่ปุ่น</h3>
                <h3 style="background:#f5f5f5;width: 300px;border-radius: 15px;height: 30px;text-align: center;color: #fc9003">150000฿</h3>
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
                    จำนวนคงเหลือ : 9999
                </p>
                <b-button variant="warning">
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
export default {
  data() {
    return {
        amount: 0,
      dummyStock: [
        {
          name: "Shiba อิจิ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "10000฿",
          shop: "shiba festival อิจิ",
        },
        {
          name: "Shiba นิ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "20000฿",
          shop: "shiba festival นิ",
        },
        {
          name: "Shiba ซัน",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "30000฿",
          shop: "shiba festival ซัน",
        },
        {
          name: "Shiba ย่ง",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "40000฿",
          shop: "shiba festival ย่ง",
        },
        {
          name: "Shiba โก๊ะ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "50000฿",
          shop: "shiba festival โก๊ะ",
        },
        {
          name: "Shiba โรกุ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "60000฿",
          shop: "shiba festival โรกุ",
        },
        {
          name: "Shiba นาหน่า",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "70000฿",
          shop: "shiba festival นาหน่า",
        },
        {
          name: "Shiba ฮาจิ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "80000฿",
          shop: "shiba festival ฮาจิ",
        },
        {
          name: "Shiba คิว",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "90000฿",
          shop: "shiba festival คิว",
        },
        {
          name: "Shiba ขู",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "100000฿",
          shop: "shiba festival ขู",
        },
      ],
    };
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
      }
  },
};
</script>

<style></style>
