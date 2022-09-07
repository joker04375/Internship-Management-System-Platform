package net.maku.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

@Data
@TableName("sys_stu_post")
@EqualsAndHashCode(callSuper=false)
public class SysStuPostEntity extends BaseEntity {
    /**
     * 学生id
     */
    Long stuId;

    /**
     * 实习id
     */
    Long pracId;

    /**
     * 岗位id
     */
    Long postId;
}
