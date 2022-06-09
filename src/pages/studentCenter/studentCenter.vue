<template>
  <div>
    <studentGuide />
    <Content />
  </div>
</template>

<script>
import Content from "../../components/Content.vue";
import studentGuide from "./studentGuide.vue";
export default {
  components: {
    Content,
    studentGuide,
  },
};
</script>

<style>
</style>