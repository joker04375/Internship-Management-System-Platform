package net.maku.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class CollegeUserVo implements Serializable {
    private static final long serialVersionUID = 1L;


    @Schema(name = "姓名")
    private String realName;
    @Schema(name = "性别")
    private Integer gender;
    @Schema(name = "学号/工号")
    private String idNum;
    @Schema(name = "身份证号")
    private String idCard;
    @Schema(name = "所属单位")
    private String orgName;
}
