package net.maku.enterprise.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 企业实习学生管理表
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_prac_stu")
public class SysOrgPracStuEntity {

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
   *学生状态
   */
  private long status;

}
