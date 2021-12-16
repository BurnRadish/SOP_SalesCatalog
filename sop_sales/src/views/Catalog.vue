<template>
  <b-container
    class="main"
    fluid="xl"
    v-bind:style="{ background: 'linear-gradient(135deg, #ff8000, #e06046)' }"
  >
    <!-- Banner -->
    <div class="mb-3">
      <b-card
        overlay
        img-src="https://picsum.photos/900/250/?image=26"
        img-alt="Card Image"
        text-variant="white"
      >
        <b-card-title style="font-size: 80px">
          To another level of handmade
        </b-card-title>
        <b-card-text style="font-size: 40px">
          ก้าวไปอีกระดับกับสินค้า handemade สุด exculsive
          <p>- GOS</p>
        </b-card-text>
      </b-card>
    </div>
     <!-- search section -->
    <div class="mb-3">
      <b-row>
        <b-col>
          <b-input-group class="mt-3">
            <b-form-input
              placeholder="ใส่ชื่อสินค้าที่ต้องการค้นหาที่นี้"
              v-model="searchHolder"
            ></b-form-input>
            <b-input-group-append>
              <b-button variant="warning" @click="searchStock()"><b-icon icon="search" /></b-button>
            </b-input-group-append>
          </b-input-group>
        </b-col>
      </b-row>
    </div>
    <!-- search result -->
    <div class="mb-3" v-show="search">
      <b-row>
        <b-col
                v-for="(item, index) in SearchResult"
                :key="index"
                cols="3"
                class="mb-2"
              >
                <b-card
                  v-b-tooltip.hover.right="{ title: item.description }"
                  border-variant=""
                  style="height: 100%; cursor:pointer;"
                >
                  <b-card-body style="height: 80%">
                    <b-card-img
                      :src="'https://'+item.urlimage"
                      img-alt="Card image"
                      img-top
                      alt="Image"
                      height="200"
                      class="mb-2"
                    >
                    </b-card-img>
                    <b-card-title>
                      {{ item.name }}
                    </b-card-title>
                    <b-card-text class="mb-2">
                      {{ item.description }}
                    </b-card-text>
                  </b-card-body>

                  <b-card-body>
                    <b-card-text :class="'text-danger mb-2'">
                      {{ item.price }}฿
                    </b-card-text>
                    <a class="card-link" @click="viewDetail(item._id)">ดูรายละเอียดเพิ่มเติม</a>
                  </b-card-body>
                </b-card>
              </b-col>
      </b-row>
    </div>
    
    <!-- Catalog -->
    <div
      style="
        background: #fff;
        width: 25%;
        text-align: center;
        border-radius: 15px;
      "
    >
      <h2>รายการสินค้า</h2>
    </div>
    <div class="mb-3">
      <b-card no-body>
        <b-tabs card justified active-nav-item-class="text-warning">
          <b-tab title="เสื้อผ้า" active>
            <b-row>
              <b-col
                v-for="(item, index) in Cloths"
                :key="index"
                cols="3"
                class="mb-2"
              >
                <b-card
                  v-b-tooltip.hover.right="{ title: item.description }"
                  border-variant=""
                  style="height: 100%; cursor:pointer;"
                >
                  <b-card-body style="height: 80%">
                    <b-card-img
                      :src="'https://'+item.urlimage"
                      img-alt="Card image"
                      img-top
                      alt="Image"
                      height="200"
                      class="mb-2"
                    >
                    </b-card-img>
                    <b-card-title>
                      {{ item.name }}
                    </b-card-title>
                    <b-card-text class="mb-2">
                      {{ item.description }}
                    </b-card-text>
                  </b-card-body>

                  <b-card-body>
                    <b-card-text :class="'text-danger mb-2'">
                      {{ item.price }}฿
                    </b-card-text>
                    <a class="card-link" @click="viewDetail(item._id)">ดูรายละเอียดเพิ่มเติม</a>
                  </b-card-body>
                </b-card>
              </b-col>
            </b-row>
          </b-tab>
          <b-tab title="เครื่องประดับ">
            <b-row>
              <b-col
                v-for="(item, index) in Accessories"
                :key="index"
                cols="3"
                class="mb-2"
              >
                <b-card
                  v-b-tooltip.hover.right="{ title: item.description }"
                  border-variant=""
                  style="height: 100%; cursor:pointer;"
                >
                  <b-card-body style="height: 80%">
                    <b-card-img
                      :src="'https://' + item.urlimage"
                      img-alt="Card image"
                      img-top
                      alt="Image"
                      height="200"
                      class="mb-2"
                    >
                    </b-card-img>
                    <b-card-title >
                      {{ item.name }}
                    </b-card-title>
                    <b-card-text class="mb-2">
                      {{ item.description }}
                    </b-card-text>
                  </b-card-body>

                  <b-card-body>
                    <b-card-text :class="'text-danger mb-2'">
                      {{ item.price }}฿
                    </b-card-text>
                    <a class="card-link" @click="viewDetail(item._id)">ดูรายละเอียดเพิ่มเติม</a>
                  </b-card-body>
                </b-card>
              </b-col>
            </b-row>
          </b-tab>
        </b-tabs>
      </b-card>
    </div>
  </b-container>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      Cloths: [],
      Accessories: [],
      SearchResult: [],
      search: false,
      searchHolder: '',
    };
  },
  mounted(){
    this.getStock()
    if(localStorage.getItem("Cart") != null){
      console.log("Cart already created")
    }
    else{
       localStorage.setItem("Cart", JSON.stringify([]))
    }
  }
  ,
  methods:{
    getStock(){
      axios.get("http://localhost:4000/product")
      .then((res)=>{
        this.Cloths = res.data.filter((item) => item.group === "cloths")
        this.Accessories = res.data.filter((item) => item.group === "Accessories")
      })
      .catch((err)=>{
        console.log(err)
      })
    },
    searchStock(){
      if(this.searchHolder != ''){
        axios.get("http://localhost:4000/product/" + this.searchHolder)
        .then((res)=>{
          console.log(res.data)
          this.SearchResult = res.data
          this.search = true
        }).catch((err)=>{
          console.log(err)
        })
      }
    },
    viewDetail(id) {
      this.$router.push({ path: `/Detail/${id}` });
    }
  }
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Prompt&display=swap");

.main {
  font-family: "Prompt", sans-serif;
}
</style>
