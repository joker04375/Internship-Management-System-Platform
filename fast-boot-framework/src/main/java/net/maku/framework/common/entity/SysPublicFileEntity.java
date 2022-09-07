package net.maku.framework.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_public_file")
public class SysPublicFileEntity extends BaseEntity{

    /*
     * 企业Id
     * */
    @TableField("org_id")
    int orgId;

    /*
     * 实习项目Id
     * */
    @TableField("prac_id")
    int pracId;

    /*
     * 文件路径
     * */
    @TableField("file_url")
    String fileUrl;

    /*
     * 文件类型（0：周报；1：简历；2：学院任务）
     * */
    @TableField("file_type")
    String fileType;

    /*
     * 文件Id
     * */
    @TableField("file_id")
    String fileId;

    /*
     * 文件名称（可为NULL）
     * */
    @TableField("file_name")
    String fileName;

    /*
     * 是否为学生上传（1:是；0:不是）
     * */
    @TableField("is_stu")
    int isStu;

    /*
     * 学生id
     * */
    @TableField("stu_id")
    long stuId;

    /*
     * 学院id
     * */
    @TableField("college_id")
    long collegeId;

    /*
     * 学院实习id
     * */
    @TableField("time_id")
    long timeId;

    /*
     * 公司是否可见
     * */
    @TableField("is_org_read")
    long isOrgRead;

    /*
     * 该文件是否通过（主要是用来进行企业对学院上传模板的审批）（0:待审批；1：通过；2：不通过）
     * */
    @TableField("passed")
    int passed;

}
