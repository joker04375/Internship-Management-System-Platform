package net.maku.enterprise.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;


/**
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_prac_manage")
public class SysOrgPracManageEntity extends BaseEntity {

  /**
   *企业id
   */
  private long orgId;

  /**
   *实习id
   */
  private long pracId;

  /**
   *实习名称
   */
  private String pracName;

  /**
   *实习地点
   */
  private String pracAddr;

  /**
   *实习总人数
   */
  private long pracNum;

  /**
   *实习状态
   */
  private long pracStatus;


  /**
   *实习简介
   */
  private String pracIntro;


}
