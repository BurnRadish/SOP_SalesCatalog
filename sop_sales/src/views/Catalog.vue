<template>
  <b-container
    class="main"
    fluid="xl"
    v-bind:style="{ background: 'linear-gradient(135deg, #ff8000, #e06046)' }"
  >
    <!-- first section -->
    <div class="mb-3">
      <b-row>
        <b-col>
          <b-input-group class="mt-3">
            <b-form-input
              placeholder="ใส่ชื่อสินค้าที่ต้องการค้นหาที่นี้"
            ></b-form-input>
            <b-input-group-append>
              <b-button variant="warning"><b-icon icon="search" /></b-button>
            </b-input-group-append>
          </b-input-group>
        </b-col>
      </b-row>
    </div>
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
        <b-tabs card justified>
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
                  style="height: 100%"
                >
                  <b-card-img
                    :src="item.Urlimage"
                    img-alt="Card image"
                    img-top
                    alt="Image"
                    height="200"
                  >
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
                  style="height: 100%"
                >
                  <b-card-img
                    :src="item.Urlimage"
                    img-alt="Card image"
                    img-top
                    alt="Image"
                    height="200"
                  >
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
          </b-tab>
        </b-tabs>
      </b-card>
      <!-- <b-row>
        <b-col
          v-for="(item, index) in dummyStock"
          :key="index"
          cols="3"
          class="mb-2"
        >
          <b-card
            v-b-tooltip.hover.right="{ title: item.shop }"
            border-variant=""
            img-src="https://cdn.pixabay.com/photo/2018/10/04/19/46/dog-3724261_960_720.jpg"
            img-alt="Image"
            img-top
          >
            <b-card-title>
              {{ item.name }}
            </b-card-title>
            <b-card-text>
              {{ item.description }}
            </b-card-text>

            <b-card-text :class="'text-danger'">
              {{ item.price }}
            </b-card-text>
          </b-card>
        </b-col>
      </b-row> -->
    </div>
  </b-container>
</template>

<script>
import STOCK from "../dummy";

export default {
  data() {
    return {
      Cloths: STOCK.filter((item) => item.group === "cloths"),
      Accessories: STOCK.filter((item) => item.group === "Accessories"),
    };
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Prompt&display=swap");

.main {
  font-family: "Prompt", sans-serif;
}
</style>
