<template>
  <div>
    <!--Header-->
    <div style="height: 6em;">
      <div style="padding-top: 1.5%" class="container">
        <img
          src="../assets/avg.png"
          alt=""
          width="50"
          height="50"
          style="position: absolute"
        />
        <h1 style="margin-left: 5%; font-size: 40px">GOS shop&sales</h1>
      </div>
    </div>
    <!--Content-->
    <div style="height: 86.5vh; background-color: #ff7e33">
      <div class="container">
        <b-row>
          <b-col cols="7" class="mt-5">
            <center>
              <img src="../assets/avg-wh.png" alt="" width="500" height="500" />
            </center>
          </b-col>
          <b-col cols="5" class="mt-5">
            <Card :regis="false"></Card>
          </b-col>
        </b-row>
      </div> 
    </div>
  </div>
</template>

<script>
import Card from "../components/InputCard.vue"

export default {
  components: {
        Card
  },
  
};
</script>

<style>
.center {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
