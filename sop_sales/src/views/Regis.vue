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
        <h1 style="margin-left: 5%; font-size: 40px">Avenger Assemble</h1>
      </div>
    </div>
    <!--Content-->
    <div style="height: 86.5vh; background-color: #ee4d2d">
      <div class="container">
        <b-row>
          <b-col cols="7" class="mt-5">
            <center>
              <img src="../assets/avg-wh.png" alt="" width="500" height="500" />
            </center>
          </b-col>
          <b-col cols="5" class="mt-5">
            <Card :regis="true"></Card>
          </b-col>
        </b-row>
      </div>
    </div>
  </div>
</template>

<script>
import Card from "../components/Card.vue"
export default {
    components:{
        Card
    }
};
</script>

<style>
.center {
  display: flex;
  justify-content: center;
  align-items: center;
}
.login{
    background-color: #ee4d2d;
    border-color: #ee4d2d;
    color: white;
}
.login:hover{
    background-color: #ee2900;
}
</style>
