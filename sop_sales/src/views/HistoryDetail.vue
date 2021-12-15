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
            <h1 style="margin-left: 5%; font-size: 24px; color: white; margin-top: 0.5%">Avenger Assemble | ประวัติการทำรายการ</h1>
        </div>
        <div class="container mt-5">
            <ItemsList :data="items"></ItemsList>
            <b-card class="mt-4">
                <b-media >
                    <div>
                        <b-row>
                            <b-col cols="11">ช่องทางการชำระเงิน</b-col>
                            <b-col>GOS Wallet</b-col>
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
        </div>
        
    </div>
</template>

<script>
import ItemsList from "../components/ItemsList.vue"
export default {
    components:{
        ItemsList
    },
    data(){
        return{
            total: 0,
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
        for(let i = 0; i < this.items.length; i++){
            this.total += this.items[i].price*this.items[i].quantity
        }
    }
}
</script>

<style>

</style>