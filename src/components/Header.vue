<template>
  <div class="main">
    <t-head-menu theme="light" v-model="menu1Value">
      <template #logo>
        <img width="80" src="../assets/logo.png" alt="logo" />
      </template>
      <t-menu-item value="item1" @click="stuCenter">学生中心</t-menu-item>
      <t-menu-item value="item2">学院管理</t-menu-item>
      <t-menu-item value="item3">企业管理</t-menu-item>
      <t-menu-item value="item4">后台管理</t-menu-item>
    </t-head-menu>
  </div>
</template>

<script>
import { Icon } from "tdesign-icons-vue";

export default {
  components: {
    Icon,
  },
  data() {
    return {
      menu1Value: "item1",
    };
  },
  methods: {
    stuCenter() {
      this.$router.push({ name: "studentCenter" });
    },
  },
};
</script>
<style scoped>
.main {
  border-bottom: 1px solid pink;
}
</style>