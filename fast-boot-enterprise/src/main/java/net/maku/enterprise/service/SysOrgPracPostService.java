package net.maku.enterprise.service;


import net.maku.enterprise.entity.interation.SysAllOrgPostEntity;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysOrgPracPostService extends BaseService<SysOrgPracPostEntity> {


    SysOrgPracPostEntity getOnePracPostMessage(Long Id);

    List<SysOrgPracPostEntity> getAllPracPostMessage(Long orgId,Long pracId);

    void update(SysOrgPracPostEntity sysOrgPracPostEntity);

    void delete(Long Id) ;

    List<SysAllOrgPostEntity> getAllOrgPost();

    void changePostStatus(Integer id,Integer status);
}
