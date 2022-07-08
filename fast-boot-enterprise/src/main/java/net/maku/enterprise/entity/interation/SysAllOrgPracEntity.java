package net.maku.enterprise.entity.interation;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: 25652
 * @time: 2022/6/19 13:24
 */

@Data
@AllArgsConstructor
public class SysAllOrgPracEntity {

    /**
     *企业id
     */
    private long orgId;

    /**
     *实习id
     */
    private long pracId;

    /**
     *实习名称
     */
    private String pracName;

    /**
     *实习地点
     */
    private String pracAddr;

    /**
     *实习总人数
     */
    private long pracNum;

    /**
     *实习状态
     */
    private long pracStatus;


    /**
     *实习简介
     */
    private String pracIntro;
}
