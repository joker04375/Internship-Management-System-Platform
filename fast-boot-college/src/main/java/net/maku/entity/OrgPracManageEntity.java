package net.maku.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import net.maku.framework.common.entity.BaseEntity;

@Data
public class OrgPracManageEntity extends BaseEntity {

    /**
     *企业id
     */
    private long orgId;

    /**
     *企业名称
     */
    @TableField(exist = false)
    private String orgName;

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
