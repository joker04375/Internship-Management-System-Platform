package net.maku.student.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SysStuPracEntity {
    /**
     * 公司id
     */
    Long orgId;

    /**
     * 实习id
     */
    Long pracId;

    /**
     * 岗位id
     */
    Long postId;

    /**
     * 学生id
     */
    Long stuId;

    /**
     * 岗位昵称
     */
    String post;

    /**
     * 公司名
     */
    String orgName;

    /**
     * 状态
     */
    Long status;

    /**
     * 日期
     */
    String YearAndMonth;
}
