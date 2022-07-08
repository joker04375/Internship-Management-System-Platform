package net.maku.framework.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.framework.common.dao.SysPublicFileDao;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.SysPublicFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class SysPublicFileServiceImpl extends BaseServiceImpl<SysPublicFileDao,SysPublicFileEntity> implements SysPublicFileService {

    String rootPath = "C:/Users/kameh/Desktop/jpg";

    @Override
    public SysPublicFileEntity getFileById(int orgId, int pracId, String fileId) {
        QueryWrapper<SysPublicFileEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("org_id",orgId);
        queryWrapper.eq("prac_id",pracId);
        queryWrapper.eq("file_id",fileId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public String CreatePublicFile(int orgId, int pracId, MultipartFile file) {

        File fileDir = new File(rootPath);
        if (!fileDir.exists() && !fileDir.isDirectory())
            fileDir.mkdirs();
        //使用uuid工具
        String uuid = UUID.randomUUID().toString();
        String storagePath = rootPath +"/"+uuid+"_"+file.getOriginalFilename();
        try {
            file.transferTo(new File(storagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileId = UUID.randomUUID().toString();
        SysPublicFileEntity fileEntity = new SysPublicFileEntity();
        fileEntity.setFileId(fileId);
        fileEntity.setFileUrl(storagePath);
        fileEntity.setOrgId(orgId);
        fileEntity.setPracId(pracId);
        baseMapper.insert(fileEntity);
        return fileId;
    }
}
