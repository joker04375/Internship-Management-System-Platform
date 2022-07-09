package net.maku.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "简历管理")
public class SysStuResumeQuery {
    @Schema(description = "学生名称")
    private String name;
}
