package net.maku.enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 25652
 * @time: 2022/6/17 15:55
 */


@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class SysAllOrgPostDto {
    /**
     * 企业id
     */
    private Long orgId;

    /**
     * 企业名称
     */
    private String name;


    /**
     *实习id
     */
    private long pracId;

    /**
     *实习名称
     */
    private String pracName;

    /**
     *岗位id
     */
    private long postId;

    /**
     *岗位名字
     */
    private String postName;

    /**
     *岗位需求数量
     */
    private long postNumb;

    /**
     *岗位所需技能
     */
    private String postAbility;

    /**
     *岗位简介
     */
    private String postIntro;

    /**
     *岗位地址
     */
    private String postAddr;

    /**
     *岗位薪资待遇
     */
    private String postTreatment;

    /**
     *岗位其他说明
     */
    private String postOthers;

}
