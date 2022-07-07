package net.maku.framework.common.service;


import net.maku.framework.common.entity.SysPublicFileEntity;

public interface SysPublicFileService extends BaseService<SysPublicFileEntity> {
    SysPublicFileEntity getFileById(int orgId,int pracId,String fileId);
}
