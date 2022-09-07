package net.maku.student.entity;

public class UpLoadFileEntity {
    /**
     * 公司id
     */
    Long orgId;

    /**
     * 实习id
     */
    Long pracId;

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
     * 文件名
     */
    String fileName;

    /**
     * 文件类型
     */
    String fileType;

    /**
     * 文件路径
     */
    String fileUrl;

    /**
     * 是否为学生上传 0只读，1需要要上传
     */
    Long isStu;

    /**
     * 公司是否可见
     */
    Long passed;

}
