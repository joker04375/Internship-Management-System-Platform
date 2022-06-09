<template>
  <div class="box main">
    <t-menu
      theme="light"
      defaultValue=""
      expandMutex
      :defaultExpanded="expanded"
      height="550px"
      :collapsed="collapsed"
    >
      <t-menu-item value="info" @click="personalInformation">
        <template #icon>
          <icon name="user-circle" />
        </template>
        个人信息
      </t-menu-item>
      <t-submenu title="简历管理" value="3">
        <template #icon>
          <icon name="mail" />
        </template>
        <t-menu-item value="3-2">简历模板</t-menu-item>
        <t-menu-item value="3-3" @click="resumeUpload">简历上传</t-menu-item>
        <!-- <t-menu-item value="3-4">二级菜单内容</t-menu-item> -->
      </t-submenu>
      <t-submenu title="实习申报" value="4">
        <template #icon>
          <icon name="play-circle" />
        </template>
        <t-menu-item value="4-1">岗位浏览</t-menu-item>
        <t-menu-item value="4-2">岗位申报</t-menu-item>
      </t-submenu>
      <t-menu-item value="user-circle">
        <template #icon>
          <icon name="user-circle" />
        </template>
        实习管理
      </t-menu-item>
      <t-menu-item value="edit1" @click="vacate">
        <template #icon>
          <icon name="edit-1" />
        </template>
        请假
      </t-menu-item>
      <template #operations>
        <icon
          class="t-menu__operations-icon"
          name="view-list"
          @click.native="changeCollapsed"
        />
      </template>
    </t-menu>
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
      expanded: [],
      disabled: true,
      collapsed: false,
    };
  },
  methods: {
    changeCollapsed() {
      this.collapsed = !this.collapsed;
    },
    resumeUpload() {
      this.$router.push({ name: "resumeUpload" });
    },
    personalInformation() {
      this.$router.push({ name: "personalInformation" });
    },
    vacate() {
      this.$router.push({ name: "vacate" });
    },
  },
};
</script>
<style scoped>
.main {
  position: absolute;
  height: calc(100%);
}
</style>