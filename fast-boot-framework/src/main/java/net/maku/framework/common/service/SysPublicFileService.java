package net.maku.framework.common.service;


import net.maku.framework.common.entity.SysPublicFileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SysPublicFileService extends BaseService<SysPublicFileEntity> {
    SysPublicFileEntity getFileById(int orgId,int pracId,String fileId);

//    String CreatePublicFile(MultipartFile file);

    List<SysPublicFileEntity> getAllFileByStuAndCollegeAndTimeId(long stuId, long collegeId, long timeId);
}
