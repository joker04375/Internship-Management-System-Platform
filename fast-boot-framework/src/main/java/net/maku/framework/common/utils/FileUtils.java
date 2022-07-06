package net.maku.framework.common.utils;

import cn.hutool.core.lang.UUID;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static final String rootPath = "D:\\Atest";

    public static String uploadCommonFile(MultipartFile file) {
        File fileDir = new File(rootPath);
        if (!fileDir.exists() && !fileDir.isDirectory())
            fileDir.mkdirs();

        //使用uuid工具
        String uuid = UUID.randomUUID() +"";
        String storagePath = rootPath +"\\"+uuid+"_"+file.getOriginalFilename();

        try {
            file.transferTo(new File(storagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storagePath;
    }
}
