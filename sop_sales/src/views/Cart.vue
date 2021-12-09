<template>
<!-- ตะกร้า -->
        <b-container fluid="xl">
                <h1>Hello world</h1>
                <h2>Cart</h2>
                <div>
                    <b-row>
                        <b-col v-for="(n,index) in 10" :key="index" cols="2" class="mb-3">
                            <b-card
                            title="มังคุด"
                            img-src="https://xn--42cf4bmgda2bxzc3nlh5a2d2rncd.com/wp-content/uploads/2020/04/4-1.jpg"
                            img-alt="Image"
                            img-top
                            tag="article"
                            style="max-width: 20rem;"
                            class="mb-2"
                            >
                            <b-card-text>
                            มังคุดอร่อยๆ
                            </b-card-text>
                            <b-card-text :class="'text-danger'">
                            500฿
                            </b-card-text>
                            <b-button href="#" variant="primary">Go somewhere <b-icon icon="cart-check"> </b-icon></b-button>
                            </b-card>
                        </b-col>
                    </b-row>
                    
                </div>
        </b-container>
</template>

<script>
export default {
    name:"Cart",
    data() {
        return{

        }
    },
    methods: {
        
    },
};
</script>