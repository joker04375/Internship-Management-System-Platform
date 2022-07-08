package net.maku.framework.common.service;


import net.maku.framework.common.entity.SysPublicFileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SysPublicFileService extends BaseService<SysPublicFileEntity> {
    SysPublicFileEntity getFileById(int orgId,int pracId,String fileId);

    String CreatePublicFile(int orgId, int pracId, MultipartFile file);
}
