import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'

Vue.config.productionTip = false
axios.defaults.baseURL = 'http://35.232.11.175/TallerDevOps/services/Taller/'
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
