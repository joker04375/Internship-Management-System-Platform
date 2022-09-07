package net.maku.student.vo;

import lombok.Data;

@Data
public class SysStuResumeVO {
    /**
     * 学生id
     */
    private Long stuId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 学院
     */
    private String college;

    /**
     * 学号
     */
    private String stuNum;

    /**
     * 专业
     */
    private String major;

    /**
     * 电话号码
     */
    private String phonenum;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 学习情况
     */
    private String contentStudy;

    /**
     * 项目经历
     */
    private String contentWork;

    /**
     * 个人能力
     */
    private String contentSpecialty;
}
