<template>
  <div class="main">
    <router-view></router-view>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.main {
  position: absolute;
  height: calc(100% - 10px);
  width: calc(100% - 252px);
  right: 10px;
  margin-left: 10px;
  border: 1px solid pink;
}
</style>