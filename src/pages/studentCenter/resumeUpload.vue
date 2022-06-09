<template>
  <div>
    <div
      style="
        margin-top: 20px;
        margin-left: 20px;

        font-size: 20px;
      "
    >
      <span>简历上传</span>
      <t-upload
        action="https://service-bv448zsw-1257786608.gz.apigw.tencentcs.com/api/upload-demo"
        style="display: inline-block"
      />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  components: {},
};
</script>

<style>
</style>