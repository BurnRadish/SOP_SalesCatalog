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
        <div class="container">
            <div class="mt-5">
                <b-card class="mt-4">
                    <b-media>
                    <div>
                        <b-row>
                            <b-col cols="6"><strong>หมายเลขออเดอร์</strong></b-col>
                            <b-col cols="3"><strong>ราคารวม</strong></b-col>
                            <b-col cols="3"><strong>สถานะ</strong></b-col>
                        </b-row>
                        <b-row class="mt-5" v-for="(item) in data" :key="item.id">
                            <b-col cols="6"><a :href='"/history/" + item.order_id' >No.{{item.order_id}}</a></b-col>
                            <b-col cols="3">{{item.price}}</b-col>
                            <b-col cols="3">สำเร็จ</b-col>
                        </b-row>
                    </div>
                    </b-media>
                </b-card>
            </div>
        </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            data:[
                {
                    order_id: 1,
                    price: 1000,
                },
                {
                    order_id: 2,
                    price: 2000,
                }
            ]
        }
    }
}
</script>

<style>

</style>