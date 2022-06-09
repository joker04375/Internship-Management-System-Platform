<template>
  <div>
    <div>请假理由</div>
    <div class="tdesign-demo-block-column" style="max-width: 500px">
      <t-input
        clearable
        v-model="value"
        placeholder="请输入"
        @clear="onClear"
      />
    </div>
    <span>开始时间</span>
    <div class="tdesign-demo-item--datepicker timeSelect">
      <t-date-picker
        mode="date"
        format="YYYY-MM-DD HH:mm:ss"
        enableTimePicker
        defaultValue="2021-12-31 00:00:00"
      />
    </div>
    <span>结束时间</span>
    <div class="tdesign-demo-item--datepicker timeSelect">
      <t-date-picker
        mode="date"
        format="YYYY-MM-DD HH:mm:ss"
        enableTimePicker
        defaultValue="2021-12-31 00:00:00"
      />
    </div>
    <div>情况说明</div>
    <t-textarea v-model="description" rows="8"></t-textarea>
    <button>上传</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: "",
      description: "",
    };
  },
};
</script>

<style scoped>
div {
  font-size: 14px;
}
.timeSelect {
  display: inline-block;
  width: 20%;
}
</style>