<template>
  <div>
    <button @click="login1">student</button>
    <button @click="login2">college</button>
  </div>
</template>

<script>
export default {
  methods: {
    login1() {
      this.$router.push({ name: "studentCenter" });
    },
    login2() {
      this.$router.push({ name: "collegeCenter" });
    },
  },
};
</script>
<style>
</style>