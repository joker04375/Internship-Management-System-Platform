package net.maku.enterprise.common;

/**
 * @description:企业部分的一些常量
 * @author: 25652
 * @time: 2022/6/17 14:50
 */
public class OrgConstants {

    /**
     * 企业实习文件下载url
     */
    public static final String ORG_PRAC_FILE_URL = "D:\\";




    /**
     *企业实习岗位审查状态 ：不通过
     */
    public static final Integer POST_STATUS_OUT = -1;


    /**
     *企业实习岗位审查状态 ：通过
     */
    public static final Integer POST_STATUS_PASS = 1;


    /**
     *企业实习岗位审查状态 ：不通过
     */
    public static final Integer POST_STATUS_WAIT = 0;


    /**
     *学生申请岗位状态 ：淘汰
     */
    public static final Integer STU_STATUS_OUT = -1;

    /**
     *学生申请岗位状态 ：报名中
     */
    public static final Integer STU_STATUS_APPLY = 0;

    /**
     *学生申请岗位状态 ：面试或者笔试中
     */
    public static final Integer STU_STATUS_TEST = 1;

    /**
     *学生申请岗位状态 ：通过本轮笔试或者面试
     */
    public static final Integer STU_STATUS_ACCESS = 2;

    /**
     *学生申请岗位状态 ：成功录取
     */
    public static final Integer STU_STATUS_SUCCESS = 3;

    /**
     *学生申请岗位状态 ：正在实习
     */
    public static final Integer STU_STATUS_WORKING = 4;

    /**
     *学生申请岗位状态 ：实习结束
     */
    public static final Integer STU_STATUS_WORKEND = 5;

}