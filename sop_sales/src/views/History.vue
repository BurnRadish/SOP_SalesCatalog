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
            <h1 style="margin-left: 5%; font-size: 24px; color: white; margin-top: 0.5%">Avenger Assemble | ประวัติการทำรายการ</h1>
        </div>
        <div class="container">
            <div class="mt-5">
                <b-card class="mt-4">
                    <b-media>
                    <div>
                        <b-row>
                            <b-col cols="6"><strong>หมายเลขออเดอร์</strong></b-col>
                            <b-col cols="3"><strong>ราคารวม</strong></b-col>
                            <b-col cols="3"><strong style="float:right;margin-right:15%" >สถานะ</strong></b-col>
                        </b-row>
                        <div v-for="(items, i) in data" :key="i">
                            <b-row class="mt-5" v-for="(item, j) in items" :key="j">
                                <b-col cols="6"><a :href='"/history/"+ item.id ' >Order ID: {{item.id}}</a></b-col>
                                <b-col cols="3">{{item.priceResult}}</b-col>
                                <b-col cols="3"><p style="float:right;margin-right:15%">สำเร็จ</p></b-col>
                            </b-row>
                        </div>
                    </div>
                    </b-media>
                </b-card>
            </div>
        </div>
  </div>
</template>

<script>
import axios from "../plugin/axios"
export default {
    data(){
        return{
            data:[]
        }
    },
  mounted(){
        this.getHistory()
    },
    methods:{
        getHistory(){
            // let email = {
            //     email: localStorage.getItem("email")
            // }
            axios
            .get("/history")
            .then((res) => {
                this.data = res.data.history
                console.log(this.data)
            })
        }
    }
}
</script>

<style>

</style>