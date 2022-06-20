package net.maku.enterprise.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;


@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_org_prac_file")
public class SysOrgPracFileEntity extends BaseEntity {

  /**
   *区分公共/实习 文件
   */
  private long isCommon;

  /**
   *文件类型
   */
  private String fileType;

  /**
   *文件名
   */
  private String fileName;

  /**
   *文件真实名
   */
  private String fileRealame;

  /**
   *上传者
   */
  private String uploader;

  /**
   *上传时间
   */
  private java.sql.Timestamp uploadTime;

  /**
   *文件路径
   */
  private String fileAddr;


  /**
   *  leo
   */
  private long orgId;

  private long pracId;


}
