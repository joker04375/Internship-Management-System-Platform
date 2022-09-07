package net.maku.enterprise.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_prac_interview")
public class SysOrgPracInterviewEntity extends BaseEntity {

  /**
   *企业id
   */
  private long orgId;

  /**
   *实习id
   */
  private long pracId;

  /**
   *实习id
   */
  private long interviewId;


  /**
   *面试类型  笔试/面试
   */
  private String type;

  /**
   *面试、笔试人数
   */
  private long num;

  /**
   *测试时间
   */
  private java.sql.Date time;

  /**
   *测试地址
   */
  private String address;

  /**
   *其他说明
   */
  private String explain;


}
