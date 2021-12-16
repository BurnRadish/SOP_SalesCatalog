<template>
<!-- ตะกร้า -->
        <b-container fluid="xl">
                <h1>This is Cart</h1>
                <div>
                    <b-row>
                        <b-button href="#" variant="primary" @click="goCheckout()"> Chect OUT  <b-icon icon="cart-check"> </b-icon></b-button>
                        <b-col
                        v-for="(item, index) in cart"
                        :key="index"
                        cols="3" 
                        class="mb-2">
                            <b-card
                                v-b-tooltip.hover.right="{title: item.description}"
                                style="height: 100%"
                                >
                                <b-card-img
                                :src="'https://' + item.urlimage"
                                img-alt="Card image"
                                img-top 
                                alt="Image"
                                height="200"
                                tag="article"
                                class="mb-2">
                                </b-card-img>
                            <div style="height: 150px; padding-top: 10px">
                                <b-card-title style="height: 50px">
                                {{ item.name }}
                                </b-card-title>
                                <b-card-text
                                class="mb-2"
                                style="height: 50px; padding-top: 10px"
                                >
                                {{ item.description }}
                                </b-card-text>
                            </div>
                                <b-card-text :class="'text-danger mb-2'">
                                {{ item.price }}฿
                                </b-card-text>
                            </b-card>
                        </b-col>
                    </b-row>
                    
                </div>
        </b-container>
</template>

<script>
import STOCK from "../dummy";

export default {
    name:"Cart",
    data() {
        return{
            //ลอง render
            Stock: STOCK,
            // Real Cart
            cart:[],


        }
    },
    methods: {
        setCart(){
            this.cart = JSON.parse(localStorage.getItem("Cart")) 
            console.log(this.cart)
        },
        goCheckout(){
            this.$router.push({ path: `/checkout/${this.cart}` });
        }
    },
    created(){
        this.setCart()
    }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Prompt&display=swap');

.main{
  font-family: 'Prompt', sans-serif;
}
</style>
