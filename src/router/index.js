import VueRouter from "vue-router";

import login from "../components/login.vue";
import homepage from "../components/homepage.vue";
import studentCenter from "../pages/studentCenter/studentCenter.vue";
import collegeCenter from "../pages/collegeCenter/collegeCenter.vue";
import resumeUpload from "../pages/studentCenter/resumeUpload.vue";
import personalInformation from "../pages/studentCenter/personalInformation.vue";
import vacate from "../pages/studentCenter/vacate.vue";

//获取原型对象上的push函数
const originalPush = VueRouter.prototype.push;
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => err);
};

const router = new VueRouter({
  mode: "history",
  routes: [
    {
      name: "login",
      path: "/",
      component: login,
    },
    {
      name: "homepage",
      path: "/homepage",
      component: homepage,
      children: [
        {
          name: "studentCenter",
          path: "studentCenter",
          component: studentCenter,
          children: [
            {
              name: "resumeUpload",
              path: "resumeUpload",
              component: resumeUpload,
            },
            {
              name: "personalInformation",
              path: "personalInformation",
              component: personalInformation,
            },
            {
              name: "vacate",
              path: "vacate",
              component: vacate,
            },
          ],
        },
        {
          name: "collegeCenter",
          path: "collegeCenter",
          component: collegeCenter,
        },
      ],
    },
  ],
});

export default router;
