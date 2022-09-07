package net.maku.enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysStuPracDetailDto {
    /**
     *企业id
     */
    private long orgId;

    /**
     *企业名称
     */
    private String orgName;

    /**
     *实习id
     */
    private long pracId;

    /**
     *岗位id
     */
    private long postId;

    /**
     *岗位名称
     */
    private String postName;

    /**
     *学生学号
     */
    private String stuId;

    /**
     *学生姓名
     */
    private String stuName;

    /**
     *学生电话
     */
    private String stuPhone;

    /**
     *学生邮箱
     */
    private String stuEmail;

    /**
     *学生状态 -1为淘汰 0为报名中 1为正在本轮测试 2为通过本轮测试,3为成功，4为正在实习，5为实习结束
     */
    private long status;
}
