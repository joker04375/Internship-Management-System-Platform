package net.maku.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class CollegeUserVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(name = "账号")
    private String username;
    @Schema(name = "姓名")
    private String realName;
    @Schema(name = "类别")
    private Integer roleName;
    @Schema(name = "性别")
    private Integer gender;
    @Schema(name = "身份证号")
    private String idCard;
    @Schema(name = "机构名称")
    private String orgName;
    @Schema(name = "状态")
    private Integer status;
}
