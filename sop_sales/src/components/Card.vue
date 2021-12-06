<template>
  <div>
    <b-card
      title="เข้าสู่ระบบ"
      style="max-width: 25rem"
      class="mb-2 mt-5"
      v-if="regis === false">
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
        <b-col cols="5"><hr /></b-col>
        <b-col>หรือ</b-col>
        <b-col cols="5"><hr /></b-col>
      </b-row>
      <b-button
        href="#"
        class="w-100 mt-2 regis"
        @click="$router.push('register')"
        >Sign Up</b-button
      >
      <center class="mt-2">
        <b-form-text
          >ลืมรหัสผ่านงั้นหรอ
          <a href="/register" style="text-decoration: none; color: #ee4d2d">สมัครใหม่</a> สิ555555</b-form-text
        >
      </center>
    </b-card>

    <b-card title="สมัครสมาชิก" style="max-width: 25rem" class="mb-2 mt-5" v-else>
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

          <label for="text-conpassword" class="mt-3">Confirm Password</label>
          <b-form-input
            type="password"
            id="text-conpassword"
            placeholder="Enter your password again"
          ></b-form-input>
        </b-form>
      </b-card-text>

      <b-button href="#" variant="primary" class="w-100 mt-3 login"
        >Confirm</b-button
      >
    </b-card>
  </div>
</template>

<script>
export default {
  name: "Card",
  props: {
    regis: Boolean,
  },
};
</script>

<style></style>
