package net.maku.college.service.impl;

import lombok.AllArgsConstructor;
import net.maku.college.dao.SysCollegeFileDao;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.college.service.SysCollegeFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class SysCollegeFileServiceImpl extends BaseServiceImpl<SysCollegeFileDao, SysPublicFileEntity> implements SysCollegeFileService {

    @Override
    public void UploadTemplateFile(int orgId, int pracId, MultipartFile file, String name) {
        SysPublicFileEntity templateFile = new SysPublicFileEntity();
        templateFile.setPracId(pracId);
        templateFile.setOrgId(orgId);
        templateFile.setFileName(name);

    }
}
