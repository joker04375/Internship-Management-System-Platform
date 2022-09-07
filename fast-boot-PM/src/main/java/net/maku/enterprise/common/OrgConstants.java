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
     *企业实习状态 ：进行中
     */
    public static final Integer PRAC_STATUS_WORK = 1;

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
     *学生申请岗位状态 ：成功录取
     */
    public static final Integer STU_STATUS_SUCCESS = 2;

    /**
     *学生申请岗位状态 ：正在实习
     */
    public static final Integer STU_STATUS_WORKING = 3;

    /**
     *学生申请岗位状态 ：实习结束
     */
    public static final Integer STU_STATUS_WORKEND = 4;


    /**
     *学生笔试面试批次：默认
     */
    public static final Integer STU_INTERVIEW_DEFAULT = 0;

    /**
     *学生笔试面试批次：笔试
     */
    public static final Integer STU_INTERVIEW_WRITTEN = 1;

    /**
     *学生笔试面试批次：第一轮面试
     */
    public static final Integer STU_INTERVIEW_FACE_1 = 2;

    /**
     *学生笔试面试批次：第二轮面试
     */
    public static final Integer STU_INTERVIEW_FACE_2 = 3;

    /**
     *学生笔试面试批次：第三轮面试
     */
    public static final Integer STU_INTERVIEW_FACE_3 = 4;

    /**
     *岗位可见
     */
    public static final Integer POST_VISIBLE_TRUE = 1;

    /**
     *岗位不可见
     */
    public static final Integer POST_VISIBLE_FALSE = 0;



}