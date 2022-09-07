package net.maku.student.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SysStuPracTimeEntity {
    /**
     * 公司id
     */
    Long orgId;

    /**
     * 岗位实习id
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
     * 学院Id
     */
    Long colId;

    /**
     * 学院实习Id
     */
    Long timeId;

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
    Long YearAndMonth;
}
