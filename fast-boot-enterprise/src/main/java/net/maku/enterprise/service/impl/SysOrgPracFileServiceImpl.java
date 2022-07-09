package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.common.OrgConstants;
import net.maku.enterprise.dao.SysOrgPracFileDAO;
import net.maku.enterprise.entity.SysOrgPracFileEntity;
import net.maku.enterprise.service.SysOrgPracFileService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.common.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @description:对实习文件进行管理操作
 * @author: 25652
 * @time: 2022/6/17 11:51
 */


@Service
@AllArgsConstructor
public class SysOrgPracFileServiceImpl extends BaseServiceImpl<SysOrgPracFileDAO, SysOrgPracFileEntity>
        implements SysOrgPracFileService {

    @Override
    public Boolean fileDownload(HttpServletResponse response, SysOrgPracFileEntity sysOrgPracFileEntity) {


        String fileRealame = sysOrgPracFileEntity.getFileRealame();
        String url= OrgConstants.ORG_PRAC_FILE_URL + fileRealame;

        String extension=fileRealame.substring(fileRealame.lastIndexOf(".")+1);
        String filename= sysOrgPracFileEntity.getFileName() + extension;
        filename =new String(filename.getBytes(StandardCharsets.ISO_8859_1));

        response.reset();
        response.setContentType("application/octet-stream;charset=UTF-8");

        ServletOutputStream outputStream = null;

        FileInputStream fileInputStream = null;
        try {

            outputStream = response.getOutputStream();


            response.setHeader("Content-Disposition", "attachment;filename="+filename);

            fileInputStream = new FileInputStream(url);
            byte[] bytes = new byte[1024];

            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (outputStream != null) {
                    outputStream.flush();
                }

                if (fileInputStream != null) {
                    fileInputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

    }


    @Override
    public Boolean fileUpload(@RequestBody MultipartFile upLoadFile){
        String uploadurl="..";
        File file = new File(uploadurl);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                log.error("创建文件夹异常");
                return false;
            }
        }
        try {
            upLoadFile.transferTo(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return false;
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

    @Override
    public List<SysOrgPracFileEntity> getAllFile(@PathVariable("orgId") Long orgId
                                                 , @PathVariable("pracId") Long pracId){
        List<SysOrgPracFileEntity> fileEntities = baseMapper.selectList(new QueryWrapper<SysOrgPracFileEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId));
        return fileEntities;
    }


}
