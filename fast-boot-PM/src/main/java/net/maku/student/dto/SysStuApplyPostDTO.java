package net.maku.student.dto;

import lombok.Data;

@Data
public class SysStuApplyPostDTO {
    private Long userId;
    private Long orgId;
    private Long pracId;
    private Long postId;
    private String name;
    private String stuNum;
    private String phonenum;
    private String email;
    private String postName;
}
