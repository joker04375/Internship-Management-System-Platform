package net.maku.enterprise.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;


/**
 * @author 25652
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_details")
public class SysOrgDetailsEntity extends BaseEntity {

  /**
   * 企业id
   */
  private Long orgId;

  /**
   * 企业名称
   */
  private String name;

  /**
   * 统一信用代码
   */
  private String code;

  /**
   * 企业地址
   */
  private String address;

  /**
   * 企业招聘邮箱
   */
  private String email;

  /**
   * 企业类型
   */
  private String type;

  /**
   * 企业业务范围
   */
  private String business;

  /**
   * 企业规模
   */
  private String scale;

  /**
   * 企业联系人
   */
  private String relationName;

  /**
   * 企业联系人电话
   */
  private String relationPhone;

  /**
   * 企业简介
   */
  private String intro;

}
