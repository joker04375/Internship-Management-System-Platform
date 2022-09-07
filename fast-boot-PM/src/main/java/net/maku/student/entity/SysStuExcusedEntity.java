package net.maku.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

import java.util.Date;

@Data
@TableName("sys_stu_excused")
@EqualsAndHashCode(callSuper=false)
public class SysStuExcusedEntity extends BaseEntity {
    /**
     * 学生id
     */
    private long stuId;

    /**
     * 企业id
     */
    private long orgId;

    /**
     * 企业实习id
     */
    private long pracId;

    /**
     * 学院实习id
     */
    private long timeId;

    /**
     * 学院id
     */
    private long colId;

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
     * 紧急联系人
     */
    private String emContacts;

    /**
     * 紧急联系人电话
     */
    private String emContactsnum;

    /**
     * 实习单位名称
     */
    private String inContactsName;

    /**
     * 实习联络人
     */
    private String inContacts;

    /**
     * 请假类型
     */
    private String type;

    /**
     * 请假原因
     */
    private String excusedReason;

    /**
     * 请假说明
     */
    private String excusedDetails;

    /**
     * 文件路径
     */
    private String fileAddr;

    /**
     * 状态
     */
    private long status;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
}
