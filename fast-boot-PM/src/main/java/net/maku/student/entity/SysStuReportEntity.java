package net.maku.student.entity;

import lombok.Data;
import net.maku.framework.common.entity.BaseEntity;

@Data
public class SysStuReportEntity extends BaseEntity {
    /**
     * 学院id
     */
    Long collegeId;

    /**
     * 学院实习id
     */
    Long timeId;

    /**
     * 学生id
     */
    Long stuId;

    /**
     * 周次
     */
    Integer weeks;

    /**
     * 文件路径
     */
    String fileAddr;

    /**
     * 文件名字
     */
    String fileName;
}
