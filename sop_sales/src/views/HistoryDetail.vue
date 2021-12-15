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
            <ItemsList :data="data"></ItemsList>
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
import axios from 'axios'
import ItemsList from "../components/ItemsList.vue"
export default {
    components:{
        ItemsList
    },
    data(){
        return{
            total: 0,
            data: []
        }
    },
    mounted(){
        for(let i = 0; i < this.items.length; i++){
            this.total += this.items[i].price*this.items[i].quantity
        }
    },
    created() {
    this.getHistoryDetail(this.$route.params.id);
    },
    methods:{
        getHistoryDetail(id){
            let email = {
                email: localStorage.getItem("email"),
            }
            axios
            .post(`http://localhost:9002/history/${id}`, email)
            .then((res) => {
                console.log(res)
                this.data = res.data.history.item
                this.total = res.data.history.total
            })
        }
    }
}
</script>

<style>

</style>