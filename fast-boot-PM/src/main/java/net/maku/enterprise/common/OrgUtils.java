package net.maku.enterprise.common;

import java.text.SimpleDateFormat;

/**
 * @description:
 * @author: 25652
 * @time: 2022/7/9 9:51
 */
public class OrgUtils {

    /**
     * 根据时间戳生成唯一id
     *
     */
    public static Long getIdByTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        String Id = sdf.format(System.currentTimeMillis());
        return  Long.valueOf(Id);
    }
}
