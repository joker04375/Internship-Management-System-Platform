package net.maku.college.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class EnterpriseResultVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(name = "企业id")
    private Long orgId;
    @Schema(name = "企业名称")
    private String Name;
    @Schema(name = "公司简介")
    private String intro;
    @Schema(name = "地址")
    private String Address;
    @Schema(name = "类型")
    private String Type;
}
