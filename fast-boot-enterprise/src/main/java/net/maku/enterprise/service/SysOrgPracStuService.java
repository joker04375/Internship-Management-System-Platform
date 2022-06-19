package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysOrgPracStuService extends BaseService<SysOrgPracStuEntity> {

    SysOrgPracStuEntity getOnePracStuMessage(Long orgId, Long pracId, Long postId,Long stuId);

    List<SysOrgPracStuEntity> getAllPracStuMessage(Long orgId, Long pracId, Long postId);

    void update(SysOrgPracStuEntity sysOrgPracStuEntity);

    void delete(Long orgId, Long pracId,Long postId,Long stuId) ;
}
