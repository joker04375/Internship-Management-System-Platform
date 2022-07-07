package net.maku.framework.common.utils;

import cn.hutool.core.lang.UUID;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.SysPublicFileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Component
public class FileUtils {

    public SysPublicFileService sysPublicFileService;

    public static final String rootPath = "C://Users/kameh/Desktop/leo";

    public static String uploadCommonFile(MultipartFile file) {
        File fileDir = new File(rootPath);
        if (!fileDir.exists() && !fileDir.isDirectory())
            fileDir.mkdirs();

        //使用uuid工具
        String uuid = UUID.randomUUID() +"";
        String storagePath = rootPath +"/"+uuid+"_"+file.getOriginalFilename();

        try {
            file.transferTo(new File(storagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storagePath;
    }

    public String DownLoadFile(int orgId, int pracId, String fileId, HttpServletResponse response) throws IOException {
        SysPublicFileEntity fileEntity = sysPublicFileService.getFileById(orgId, pracId, fileId);

        String path = fileEntity.getFileUrl();
        File file = new File(path);
        // 获取文件名
        String filename = file.getName();

        // 将文件写入输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStream fis = new BufferedInputStream(fileInputStream);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        // 清空response
        response.reset();
        // 设置response的Header
        response.setCharacterEncoding("UTF-8");
        //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
        //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
        // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        // 告知浏览器文件的大小
        response.addHeader("Content-Length", "" + file.length());
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        outputStream.write(buffer);
        outputStream.flush();

        return path;
    }
}
