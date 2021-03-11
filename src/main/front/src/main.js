import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue/dist/bootstrap-vue.esm';
import App from './App.vue'


Vue.config.productionTip = false
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import Slider from '@jeremyhamm/vue-slider'
Vue.use(BootstrapVue);
Vue.use(Slider)

new Vue({
  render: h => h(App),
}).$mount('#app')
