package net.maku.framework.common.controller;

import lombok.AllArgsConstructor;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.SysPublicFileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping("/upload")
@AllArgsConstructor
public class PublicFileController {

    public final SysPublicFileService sysPublicFileService;

    @GetMapping("/{orgId}/{pracId}/{fileId}")
    public void UploadFile(HttpServletResponse response, @PathVariable("orgId") int orgId, @PathVariable("pracId") int pracId, @PathVariable("fileId") String fileId){
        SysPublicFileEntity fileEntity = sysPublicFileService.getFileById(orgId, pracId, fileId);

        String path = fileEntity.getFileUrl();
        File file = new File(path);
        // 获取文件名
        String filename = file.getName();

        // 将文件写入输入流
        FileInputStream fileInputStream = null;
        byte[] buffer = new byte[0];
        try {
            fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 清空response
        response.reset();
        // 设置response的Header
        response.setCharacterEncoding("UTF-8");
        //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
        //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
        // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
        try {
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 告知浏览器文件的大小
        response.addHeader("Content-Length", "" + file.length());
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
