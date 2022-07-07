package net.maku.framework.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_public_file")
public class SysPublicFileEntity {

    int id;
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
}
