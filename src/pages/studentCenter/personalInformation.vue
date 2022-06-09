<template>
  <div class="info">
    <div style="margin-top: 20px; margin-left: 20px; font-size: 20px">
      个人信息
    </div>
    <t-table
      row-key="index"
      :data="[
        { index: '学号', platform: '123' },
        { index: '姓名', platform: '123' },
        { index: '学院', platform: '0' },
        { index: '专业', platform: '0' },
        { index: '班级', platform: '0' },
        { index: '电话', platform: '0' },
        { index: '邮箱', platform: '0' },
        { index: '身份证', platform: '0' },
        { index: '紧急联系人电话', platform: '0' },
        { index: '是否上传简历', platform: `${this.is}` },
        { index: '是否上传实习申请表', platform: `${this.is}` },
      ]"
      :columns="[
        {
          align: 'center',
          width: '100',
          colKey: 'index',
          title: '',
        },
        {
          width: 100,
          colKey: 'platform',
          title: '',
        },
      ]"
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      is: undefined,
    };
  },
};
</script>

<style scoped>
.info {
  margin-top: 20px;
}
</style>>