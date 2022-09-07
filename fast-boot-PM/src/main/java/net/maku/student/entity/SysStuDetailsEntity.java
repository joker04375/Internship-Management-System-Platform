package net.maku.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.maku.framework.common.entity.BaseEntity;

@Data
@AllArgsConstructor
@TableName("sys_stu_details")
public class SysStuDetailsEntity extends BaseEntity {
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
     * 电话
     */
    private String phonenum;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;
}
