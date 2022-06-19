package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysOrgPracManageService extends BaseService<SysOrgPracManageEntity> {

    SysOrgPracManageEntity getOnePracMessage(Long orgId, Long pracId);

    List<SysOrgPracManageEntity> getAllPracMessage(Long orgId);

    void update(SysOrgPracManageEntity sysOrgPracManageEntity);

    void delete(Long orgId,Long pracId);


}
