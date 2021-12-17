<template>
  <b-container
    fluid="xl"
    v-bind:style="{ background: 'linear-gradient(45deg, red, yellow)' }"
    style="overflow: hidden; padding-top: 20px"
  >
    <div class="mb-3" style="background: #ffff">
      <b-button size="lg" class="m-2" @click="goBack()">
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
          <h1>{{ productDetail.name }}</h1>
          <h3>{{ productDetail.description }}</h3>
          <h3
            style="
              background: #f5f5f5;
              width: 300px;
              border-radius: 15px;
              height: 30px;
              text-align: center;
              color: #fc9003;
            "
          >
            {{ productDetail.price }}฿
          </h3>
          <div class="mb-3">
            <b-input-group prepend="จำนวน" class="mb-3">
              <b-button style="width: 40px" @click="setAmount(0)"> - </b-button>
              <div style="width: 50px">
                <b-form-input v-model="amount"></b-form-input>
              </div>

              <b-button style="width: 40px" @click="setAmount(1)"> + </b-button>
            </b-input-group>
            <p style="font-size: 20px; color: #b5b5b5">
              จำนวนคงเหลือ : {{ productDetail.quantity }}
            </p>
            <b-button variant="warning" @click="addtoCart">
              <b-icon icon="cart-plus-fill" animation="throb" font-scale="1.5">
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
import axios from "../plugin/axios";
import Swal from "sweetalert2";
export default {
  data() {
    return {
      amount: 1,
      productDetail: {},
      Cart: [],
      addItem: {},
    };
  },
  mounted() {
    if (localStorage.getItem("Products")) {
      try {
        this.objCart = JSON.parse(localStorage.getItem("Products"));
      } catch (e) {
        localStorage.removeItem("Products");
      }
    }
  },
  created() {
    this.getProductDetail(this.$route.params.id);
  },
  methods: {
    setAmount: function (how) {
      if (how == 0) {
        if (this.amount <= 0) {
          this.amount = 0;
        } else {
          this.amount--;
        }
      } else {
        this.amount++;
      }
    },
    getProductDetail(id) {
      axios.get("/productDetail/" + id).then((res) => {
        console.log(res.data);
        this.productDetail = res.data;
      });
    },
    setCart() {
      this.Cart = JSON.parse(localStorage.getItem("Cart"));
    },
    goBack() {
      this.$router.push({ path: `/` });
    },
    addtoCart() {
      this.setCart();
      this.addItem = {
        id: this.productDetail._id,
        name: this.productDetail.name,
        description: this.productDetail.description,
        price: this.productDetail.price,
        quantity: this.productDetail.quantity,
        urlimage: this.productDetail.urlimage,
        group: this.productDetail.group,
        amounts: this.amount,
      };
      let count = 0;
      if (this.Cart.length > 0) {
        for (let i = 0; i < this.Cart.length; i++) {
          if (this.Cart[i].id == this.productDetail._id) {
            this.Cart[i].amounts += this.amount;
            localStorage.setItem("Cart", JSON.stringify(this.Cart));
            count++;
          }
        }
        if(count == 0){
            console.log("--Add new item--")
            this.setCart()
            this.Cart.push(this.addItem)
            localStorage.setItem("Cart", JSON.stringify(this.Cart))
            Swal.fire({
              icon: 'success',
              title: 'เพิ่มรายการสินค้าลงตะกร้าสำเร็จแล้ว!',
              confirmButtonColor: '#3085d6',
            }).then((result) => {
              if (result.isConfirmed) {
                this.$router.push('/')
              } else {
                this.$router.push('/')
              }
            })
          }
        Swal.fire({
          icon: "success",
          title: "เพิ่มรายการสินค้าลงตะกร้าสำเร็จแล้ว!",
          confirmButtonColor: "#3085d6",
        }).then((result) => {
          if (result.isConfirmed) {
            this.$router.push("/");
          } else {
            this.$router.push("/");
          }
        });
      } else {
        console.log("--Add first item--")
        this.Cart.push(this.addItem);
        localStorage.setItem("Cart", JSON.stringify(this.Cart));
        Swal.fire({
          icon: "success",
          title: "เพิ่มรายการสินค้าลงตะกร้าสำเร็จแล้ว!",
          confirmButtonColor: "#3085d6",
        }).then((result) => {
          if (result.isConfirmed) {
            this.$router.push("/");
          } else {
            this.$router.push("/");
          }
        });
      }
    },
  },
};
</script>

<style></style>
