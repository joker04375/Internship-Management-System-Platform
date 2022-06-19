package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysAllOrgPostEntity;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysOrgPracPostService extends BaseService<SysOrgPracPostEntity> {


    SysOrgPracPostEntity getOnePracPostMessage(Long orgId, Long pracId,Long postId);

    List<SysOrgPracPostEntity> getAllPracPostMessage(Long orgId,Long pracId);

    void update(SysOrgPracPostEntity sysOrgPracPostEntity);

    void delete(Long orgId, Long pracId,Long postId) ;

    List<SysAllOrgPostEntity> getAllOrgPost();
}
