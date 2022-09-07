package net.maku.college.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PracVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 实习公司
    * */
    private String orgName;

    /**
     * 实习名称
    * */
    private String pracName;

    /**
     * 实习地址
     * */
    private String pracAddr;

    /**
     * 实习人数
     * */
    private long pracNum;

    /**
     * 实习状态
     * */
    private long pracStatus;

//    /**、
//     *  创建时间 （用来进行排序）
//     * */
//    private
}
