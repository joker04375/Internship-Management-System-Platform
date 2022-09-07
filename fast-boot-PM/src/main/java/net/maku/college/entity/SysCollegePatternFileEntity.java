package net.maku.college.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_college_pattern_file")
public class SysCollegePatternFileEntity extends BaseEntity {

    /**
     * 任务id
     */
    long patternId;

    /**
     * 学院id
     */
    long collegeId;

    /**
     * 学院实习批次id
     */
    long timeId;

    /**
     * 文件名称
     */
    String fileName;

    /**
     * 文件类型
     */
    String fileType;

    /**
     * 文件地址
     */
    String fileAddr;

    /**
     * 文件是否需要上传（0:只读；1:需要上传）
     */
    int isNeed;

    /**
     * 公司是否可见
     */
    int isOrgRead;

    /**
     * 学生是否可见
     */
    int isStuRead;

    /**
     * 是否为公共文件（0:不是；1:是）
     */
    int isCommon;
}

