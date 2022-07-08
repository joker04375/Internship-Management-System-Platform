package net.maku.service.impl;

import net.maku.dao.CollegeFileDao;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.CollegeFileService;
import org.springframework.web.multipart.MultipartFile;

public class CollegeFileServiceImpl extends BaseServiceImpl<CollegeFileDao, SysPublicFileEntity> implements CollegeFileService {

    @Override
    public void UploadTemplateFile(int orgId, int pracId, MultipartFile file, String name) {
        SysPublicFileEntity templateFile = new SysPublicFileEntity();
        templateFile.setPracId(pracId);
        templateFile.setOrgId(orgId);
        templateFile.setFileName(name);

    }
}
