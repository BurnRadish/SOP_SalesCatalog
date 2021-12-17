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
            <h1 style="margin-left: 5%; font-size: 24px; color: white; margin-top: 0.5%">GOS Shop&Sales | ประวัติการทำรายการ</h1>
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
                      <b-row>
                        <b-col cols="6">ที่อยู่ในการจัดส่ง</b-col>
                        <b-col><p style="float: right;margin-right: 1%">{{address}}</p></b-col>
                      </b-row>
                    </div>
                </b-media>
            </b-card>
        </div>
    </div>
</template>

<script>
import axios from "../plugin/axios"
import ItemsList from "../components/ItemsList.vue"
export default {
    components:{
        ItemsList
    },
    data(){
        return{
            total: 0,
            address:'',
            data: []
        }
    },
    created() {
    this.getHistoryDetail(this.$route.params.id);
    },
    methods:{
        getHistoryDetail(id){
            // let email = {
            //     email: localStorage.getItem("email"),
            // }
            axios
            .get(`/history/${id}`)
            .then((res) => {
                console.log(res)
                this.data = res.data.history.tran
                this.total = res.data.history.priceResult
                this.address = res.data.history.address
            })
        }
    }
}
</script>

<style>

</style>