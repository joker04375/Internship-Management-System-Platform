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
      <t-submenu title="用户管理" value="3">
        <template #icon>
          <icon name="mail" />
        </template>
        <t-menu-item value="3-2">简历模板</t-menu-item>
        <t-menu-item value="3-3">简历上传</t-menu-item>
        <!-- <t-menu-item value="3-4">二级菜单内容</t-menu-item> -->
      </t-submenu>
      <t-submenu title="实习管理" value="4">
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
        业务审核
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
  },
};
</script>
<style scoped>
.main {
  position: absolute;
  height: calc(100%);
}
</style>