package net.maku.enterprise.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;


/**
 * 企业实习学生管理表
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_prac_stu")
public class SysOrgPracStuEntity extends BaseEntity {

  /**
   *企业id
   */
  private long orgId;

  /**
   *实习id
   */
  private long pracId;

  /**
   *岗位id
   */
  private long postId;

  /**
   *学生学号
   */
  private long stuId;

  /**
   *学生姓名
   */
  private String stuName;

  /**
   *学生电话
   */
  private String stuPhone;

  /**
   *学生邮箱
   */
  private String stuEmail;

  /**
   *岗位
   */
  private String post;

  /**
   *学生状态 -1为淘汰 0为报名中 1为正在进行本轮测试 2为通过本轮测试 3为已录取 4为正在实习
   */
  private long status;

}
