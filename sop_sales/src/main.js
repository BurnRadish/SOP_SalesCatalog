import Vue from 'vue'
import App from './App.vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import router from './router/index'
import { VBHoverPlugin } from 'bootstrap-vue'
import { VBTooltipPlugin } from 'bootstrap-vue'
import { BadgePlugin } from 'bootstrap-vue'

Vue.config.productionTip = false

//set up vue boothstrap
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(VBHoverPlugin)
Vue.use(VBTooltipPlugin)
Vue.use(BadgePlugin)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
