<template>
  <b-card class="mt-4">
    <b-media>
      <div>
          <b-row>
              <b-col cols="6"><strong>ชื่อสินค้า</strong></b-col>
              <b-col cols="2"><strong>ราคาต่อหน่วย</strong></b-col>
              <b-col cols="2"><strong>จำนวน</strong></b-col>
              <b-col cols="2"><strong>ราคารวม</strong></b-col>
          </b-row>
          <b-row class="mt-5" v-for="(item) in data" :key="item.id">
              <b-col cols="6">
                  <img
                    :src="item.url"
                    alt=""
                    width="50"
                    height="50"
                    style="display: inline-block"
                    />
                  <h5 class="ml-5" style="display: inline-block; margin-left: 2%">{{item.name}}</h5>
              </b-col>
              <b-col cols="2">{{item.price}}</b-col>
              <b-col cols="2">{{item.quantity}}</b-col>
              <b-col cols="2">{{item.price*item.quantity}}</b-col>
          </b-row>
      </div>
      
    </b-media>
  </b-card>
</template>

<script>
export default {
  name: "ItemsList",
  props: {
    data: Object
  },
};
</script>

<style>

</style>