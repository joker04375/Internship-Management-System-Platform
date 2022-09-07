package net.maku.college.service;

import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.BaseService;
import org.springframework.web.multipart.MultipartFile;

public interface SysCollegeFileService extends BaseService<SysPublicFileEntity> {

    void UploadTemplateFile(int orgId, int pracId, MultipartFile file,String name);
}
