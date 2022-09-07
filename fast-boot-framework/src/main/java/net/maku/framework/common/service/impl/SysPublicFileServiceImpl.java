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
import java.util.List;
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

//    @Override
//    public String CreatePublicFile(MultipartFile file) {
//
//        File fileDir = new File(rootPath);
//        if (!fileDir.exists() && !fileDir.isDirectory())
//            fileDir.mkdirs();
//        //使用uuid工具
//        String uuid = UUID.randomUUID().toString();
//        String storagePath = rootPath +"/"+uuid+"_"+file.getOriginalFilename();
//        try {
//            file.transferTo(new File(storagePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String fileId = UUID.randomUUID().toString();
//        return fileId;
//    }

    @Override
    public List<SysPublicFileEntity> getAllFileByStuAndCollegeAndTimeId(long stuId, long collegeId, long timeId) {
        return baseMapper.selectList(new QueryWrapper<SysPublicFileEntity>().eq("stu_id",stuId).eq("college_id",collegeId).eq("time_id",timeId));
    }
}
