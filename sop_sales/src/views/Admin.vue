<template>
  <b-container>
    <b-row>
      <b-col cols="12">
        <b-card>
          <b-button v-b-toggle.sidebar-1
            ><img
              src="https://img.icons8.com/ios-glyphs/30/000000/menu--v1.png"
          /></b-button>
          <b-sidebar id="sidebar-1" title="Sidebar" shadow>
            <div class="px-3 py-2">
              <nav class="mb-3">
                <b-nav vertical>
                  <b-nav-item active>Product</b-nav-item>
                  <b-nav-item href="#link-1">Setting</b-nav-item>
                  <b-nav-item href="#link-2">Logout</b-nav-item>
                </b-nav>
              </nav>
            </div>
          </b-sidebar>
        </b-card>
        <b-card style="margin-top: 3%">
          <h1>Product</h1>
          <b-table-simple>
            <b-thead>
              <b-tr>
                <b-th>Product ID</b-th>
                <b-th>Product Name</b-th>
                <b-th>Quantity</b-th>
                <b-th>Price</b-th>
                <b-th>Action</b-th>
              </b-tr>
            </b-thead>
            <b-thead v-for="(item, index) in data" :key="index">
              <b-tr>
                <b-td>{{ item._id }}</b-td>
                <b-td>{{ item.name }}</b-td>
                <b-td>{{ item.quantity }}</b-td>
                <b-td>{{ item.price }}</b-td>
                <b-td
                  ><b-button v-b-modal="modal(index)" v-on:click="assign(index)"
                    >Edit</b-button
                  ></b-td
                >
              </b-tr>
            </b-thead>
          </b-table-simple>
          <div v-for="(item, index) in data" :key="index">
            <b-modal :id="'modal-' + index" title="Form Detail">
              <h3 class="text-center">{{ item.name }}</h3>
              <label>Quantity</label>
              <b-form-input
                v-model="pro_quan"
                :placeholder="item.quantity"
              ></b-form-input>
              <label>Price</label>
              <b-form-input
                v-model="pro_price"
                :placeholder="item.price"
              ></b-form-input>
              <template #modal-footer="{ cancel, ok }">
                <!-- Emulate built in modal footer ok and cancel button actions -->
                <b-button size="sm" variant="success" @click="ok()" v-on:click="Edit()">
                  OK
                </b-button>
                <b-button size="sm" variant="danger" @click="cancel()">
                  Cancel
                </b-button>
              </template>
            </b-modal>
          </div>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import axios from "../plugin/axios";
export default {
  data() {
    return {
      data: [],
      pro_name: "",
      pro_quan: 0,
      pro_price: 0,
      pro_id: "",
      // Note `isActive` is left out and will not appear in the rendered table
    };
  },
  methods: {
    modal(i) {
      return "modal-" + i;
    },
    assign(i) {
      this.pro_quan = this.data[i].quantity;
      this.pro_price = this.data[i].price;
      this.pro_id = this.data[i]._id;
    },
    Edit() {
      console.log(this.pro_id);
      axios
        .get(
          "/product/update/" +
            this.pro_id +
            "/" +
            this.pro_quan +
            "/" +
            this.pro_price
        )
        .then(() => {
          axios.get("/product/").then((res) => {
            this.data = res.data;
            console.log(this.data);
          });
        });
    },
  },
  created() {
    axios.get("/product/").then((res) => {
      this.data = res.data;
      console.log(this.data);
    });
  },
};
</script>

<style></style>
