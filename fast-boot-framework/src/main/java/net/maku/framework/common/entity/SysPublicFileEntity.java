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
     * 文件Id
     * */
    @TableField("file_id")
    String fileId;

    /*
     * 是否为公共文件
     * */
    @TableField("is_common")
    int isCommon;

    /*
     * 学生可用（0：不可用；1：可用）
     * */
    @TableField("student")
    int student;

    /*
     * 企业可用（0：不可用；1：可用）
     * */
    @TableField("enterprise")
    int enterprise;

    /*
     * 学院可用（0：不可用；1：可用）
     * */
    @TableField("college")
    int college;

    /*
     * 该文件是否通过（主要是用来进行企业对学院上传模板的审批）
     * */
    @TableField("passed")
    int passed;

    /*
     * 文件名称（可为NULL）
     * */
    @TableField("file_name")
    String fileName;
}
