<template>
  <b-container
    class="main"
    fluid="xl"
    v-bind:style="{ background: 'linear-gradient(135deg, #ff8000, #e06046)' }"
  >
    <h1 style="color: #000000">My brand here สินค้า สุด Exclusive</h1>
    <!-- first section -->
    <div class="mb-3">
      <b-row>
        <b-col>
          <b-input-group class="mt-3">
            <b-form-input
              placeholder="ใส่ชื่อสินค้าที่ต้องการค้นหาที่นี้"
            ></b-form-input>
            <b-input-group-append>
              <b-button variant="warning" ><b-icon icon="search"
                  /></b-button>
            </b-input-group-append>
          </b-input-group>
        </b-col>
      </b-row>
    </div>
    <!-- Banner -->
    <div class="mb-3">
      <b-jumbotron bg-variant="warning" text-variant="white" border-variant="dark" class="rounded" style="padding: 4rem 2rem;">
        <template #header>Brand GOS uwu</template>

        <template #lead>
          พบกับสินค้าสุด exculsive
        </template>

        <hr class="my-4" />

        <p>
          หาไม่ได้ที่ไหนอีกแล้ว ที่นี้ ที่เดียวเท่านั้น -GOS
        </p>
      </b-jumbotron>
    </div>
    <!-- Catalog -->
    <div style="background: #fff;width:25%; text-align: center; border-radius: 15px">
      <h2>รายการสินค้า</h2>
    </div>
    
    <div class="mb-3">
      <b-row>
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
      </b-row>
    </div>
  </b-container>
</template>

<script>
export default {
  data() {
    return {
      dummyStock: [
        {
          name: "Shiba อิจิ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "10000฿",
          shop: "shiba festival อิจิ",
        },
        {
          name: "Shiba นิ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "20000฿",
          shop: "shiba festival นิ",
        },
        {
          name: "Shiba ซัน",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "30000฿",
          shop: "shiba festival ซัน",
        },
        {
          name: "Shiba ย่ง",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "40000฿",
          shop: "shiba festival ย่ง",
        },
        {
          name: "Shiba โก๊ะ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "50000฿",
          shop: "shiba festival โก๊ะ",
        },
        {
          name: "Shiba โรกุ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "60000฿",
          shop: "shiba festival โรกุ",
        },
        {
          name: "Shiba นาหน่า",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "70000฿",
          shop: "shiba festival นาหน่า",
        },
        {
          name: "Shiba ฮาจิ",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "80000฿",
          shop: "shiba festival ฮาจิ",
        },
        {
          name: "Shiba คิว",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "90000฿",
          shop: "shiba festival คิว",
        },
        {
          name: "Shiba ซู",
          description: "สุนัขพันธุ์หนึ่งที่มีถิ่นกำเนิดใน Japan",
          price: "100000฿",
          shop: "shiba festival ขู",
        },
      ],
    };
  },
};


</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Prompt&display=swap');

.main{
  font-family: 'Prompt', sans-serif;
}
</style>
