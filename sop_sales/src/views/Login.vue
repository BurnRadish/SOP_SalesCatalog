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
            <b-card title="เข้าสู่ระบบ" style="max-width: 25rem" class="mb-2">
              <b-card-text class="mt-3">
                <b-form @submit.stop.prevent>
                  <label for="text-username">Username</label>
                  <b-form-input
                    type="text"
                    id="text-username"
                    placeholder="Enter your username"
                  ></b-form-input>

                  <label for="text-password" class="mt-3">Password</label>
                  <b-form-input
                    type="password"
                    id="text-password"
                    placeholder="Enter your password"
                  ></b-form-input>
                </b-form>
              </b-card-text>

              <b-button href="#" class="w-100 mt-3 login">Sign In</b-button>
              <b-row class="mt-3">
                  <b-col cols="5"><hr></b-col>
                  <b-col>หรือ</b-col>
                  <b-col cols="5"><hr></b-col>
              </b-row>
              <b-button href="#" class="w-100 mt-2 regis" @click="$router.push('register')">Sign Up</b-button>
              <center class="mt-2"><b-form-text >ลืมรหัสผ่านงั้นหรอ <a href="/register" style="text-decoration: none; color: #ee4d2d">สมัครใหม่</a> สิ555555</b-form-text></center>
            </b-card>
          </b-col>
        </b-row>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.center {
  display: flex;
  justify-content: center;
  align-items: center;
}
.regis{
    background-color:white; 
    color: black;
    border-color: #ee4d2d;
}
.regis:hover{
    background-color: #ee4d2d;
    color: white;
    border-color: #ee4d2d;
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
