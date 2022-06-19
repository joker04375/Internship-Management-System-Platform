package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dao.SysOrgPracFileDAO;
import net.maku.enterprise.entity.SysOrgPracFileEntity;
import net.maku.enterprise.service.SysOrgPracFileService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.common.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description:
 * @author: 25652
 * @time: 2022/6/17 11:51
 */


@Service
@AllArgsConstructor
public class SysOrgPracFileServiceImpl extends BaseServiceImpl<SysOrgPracFileDAO, SysOrgPracFileEntity>
        implements SysOrgPracFileService {

    @Override
    public void fileDownload(HttpServletResponse response, String downLoadUrl) {
        response.setContentType("application/octet-stream;charset=UTF-8");

        ServletOutputStream outputStream = null;

        FileInputStream fileInputStream = null;
        try {
            outputStream = response.getOutputStream();

            response.addHeader("Content-Disposition", "attachment;filename=test.txt");

            fileInputStream = new FileInputStream("D:\\test.txt");
            byte[] bytes = new byte[1024];

            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }

                if (outputStream != null) {
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void fileUpload(@RequestBody MultipartFile upLoadFile){
        File file = new File("D:\\test2.txt");
        try {
            upLoadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Result<SysOrgPracFileEntity> getOneFileMessage(Long orgId,Long pracId,Long postId,Long stuId)
    {
        SysOrgPracFileEntity filemessage = baseMapper.selectOne(new QueryWrapper<SysOrgPracFileEntity>().
                eq("org_id", orgId).
                eq("prac_id", pracId).
                eq("post_id", postId).
                eq("stu_id", stuId));

        return Result.ok(filemessage);
    }


}
