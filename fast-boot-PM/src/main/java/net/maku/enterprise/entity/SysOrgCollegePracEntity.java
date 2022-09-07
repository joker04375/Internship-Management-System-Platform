package net.maku.enterprise.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.maku.framework.common.entity.BaseEntity;


/**
 * 企业与学院实习关联实体类
 *
 * @author  LH
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_college_prac")
@AllArgsConstructor
@NoArgsConstructor
public class SysOrgCollegePracEntity extends BaseEntity {

  /**
   * 公司ID
   */
  private long orgId;

  /**
   * 公司实习ID
   */
  private long orgPracId;

  /**
   * 学院ID
   */
  private long collegeId;


  /**
   * 学院实习ID
   */
  private long timeId;

}
