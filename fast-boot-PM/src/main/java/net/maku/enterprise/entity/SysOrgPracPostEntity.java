package net.maku.enterprise.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;


/**
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_prac_post")
public class SysOrgPracPostEntity extends BaseEntity {

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
   *岗位名字
   */
  private String postName;

  /**
   *岗位需求数量
   */
  private long postNumb;

  /**
   *岗位是否高位
   */
  private long postSafe;

  /**
   *岗位所需技能
   */
  private String postAbility;

  /**
   *岗位简介
   */
  private String postIntro;

  /**
   *岗位地址
   */
  private String postAddr;

  /**
   *岗位薪资待遇
   */
  private String postTreatment;

  /**
   *岗位其他说明
   */
  private String postOthers;

  /**
   * 审查状态
   */
  private Integer status;

  /**
   * 当前岗位是否可见
   */
  private Integer visible;

}
