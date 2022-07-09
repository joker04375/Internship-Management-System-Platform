package net.maku.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.maku.framework.common.entity.BaseEntity;

@Data
@AllArgsConstructor
@TableName("sys_stu_details")
public class SysStuDetailsEntity extends BaseEntity {
    private Long userId;
    private String name;
    private String age;
    private String college;
    private String stuNum;
    private String major;
    private String phonenum;
    private String email;
    private String address;
}
