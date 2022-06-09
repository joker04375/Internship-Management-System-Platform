import Vue from "vue";
import App from "./App.vue";
import TDesign from "tdesign-vue";
// 引入组件库全局样式资源
import "tdesign-vue/es/style/index.css";
import router from "./router/index";
import VueRouter from "vue-router";
Vue.use(VueRouter);

Vue.use(TDesign);
Vue.config.productionTip = false;

new Vue({
  render: (h) => h(App),
  router,
}).$mount("#app");
