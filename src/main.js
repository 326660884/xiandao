import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import VCharts from 'v-charts'
import 'element-ui/lib/theme-chalk/index.css'
import 'reset-css'
import '@/assets/css/global.css'

Vue.use(ElementUI)
Vue.use(VCharts)
Vue.config.productionTip = false

// Vue.component('v-chart', ECharts)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
