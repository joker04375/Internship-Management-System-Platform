package net.maku.student.entity;

import lombok.Data;
import net.maku.framework.common.entity.BaseEntity;

@Data
public class CollegeModelFileEntity extends BaseEntity {

    /**
     * 学院id
     */
    Long collegeId;

    /**
     * 学院实习id
     */
    Long timeId;

    /**
     * 任务id
     */
    Long patternId;

    /**
     * 学生id
     */
    Long stuId;

    /**
     * 文件名
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
     * 是否为需要上传 0只读，1需要要上传
     */
    Long isNeed;

    /**
     * 公司是否可见
     */
    Long isOrgRead;

    /**
     * 学生是否可见
     */
    Long isStuRead;

    /**
     * 是否为公共文件
     */
    Long isCommon;
}
