package net.maku.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

@Data
@TableName("sys_stu_excused")
@EqualsAndHashCode(callSuper=false)
public class SysStuExcusedEntity extends BaseEntity {
    /**
     * 用户id
     */
    private long userId;

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
     *请假类型
     */
    private String type;

    /**
     * 请假时间
     */
    private String time;

    /**
     * 请假原因
     */
    private String excusedReason;

    /**
     * 请假去处
     */
    private String excusedAddress;

    /**
     * 相关附件
     */
    private String file;

    /**
     * 审核状态
     */
    private long process;

    /**
     * 完成状态
     */
    private long status;
}
