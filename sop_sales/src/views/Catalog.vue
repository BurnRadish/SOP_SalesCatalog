<template>
  <b-container fluid="xl">
    <h1>My brand here สินค้า สุด Exclusive</h1>
    <!-- first section -->
    <div style="background-color: yellow" class="mb-3">
      <b-row>
        <b-col>
          <b-input-group class="mt-3">
            <b-form-input
              placeholder="ใส่ชื่อสินค้าที่ต้องการค้นหาที่นี้"
            ></b-form-input>
            <b-input-group-append>
              <b-button variant="info">ค้นหา</b-button>
            </b-input-group-append>
          </b-input-group>
        </b-col>
      </b-row>
    </div>
    <!-- Banner -->
    <div>
      <b-card
        overlay
        img-src="https://picsum.photos/900/250/?image=3"
        img-alt="Card Image"
        text-variant="white"
        title="Image Overlay"
        sub-title="Subtitle"
      >
        <b-card-text>
          Some quick example text to build on the card and make up the bulk of
          the card's content.
        </b-card-text>
      </b-card>
    </div>
    <!-- Catalog -->
    <h1>รายการสินค้า</h1>
    <div class="mb-3">
      <b-row>
        <b-col v-for="(n, index) in 10" :key="index" cols="3" class="mb-2">
          <b-card
            v-b-tooltip.hover.right="'พบกับความน่ารักของ Siba inu ได้ที่งาน Shiba World'"
            border-variant=""
            title="Shiba Inu"
            img-src="https://cdn.pixabay.com/photo/2018/10/04/19/46/dog-3724261_960_720.jpg"
            img-alt="Image"
            img-top
          >
            <b-card-text>
              Shiba inu, เป็นหมาน้อยสุดน่ารักชนิดหนึ่งถิ่นกำเนิดอยู่ที่ญี่ปุ่น
            </b-card-text>

            <b-card-text :class="'text-danger'">
              20000฿
            </b-card-text>
          </b-card>
        </b-col>
      </b-row>
    </div>
  </b-container>
</template>

<script>
export default {
  name: "Catalog",
  data() {
      return {
        
      }
    },
    methods: {

    }
};
</script>

<style>

</style>
