package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.entity.interation.SysAllOrgPracEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysOrgPracManageService extends BaseService<SysOrgPracManageEntity> {

    SysOrgPracManageEntity getOnePracMessage(Long Id);

    /**
     * 给企业
     * @param orgId
     * @return
     */
    List<SysOrgPracManageEntity> getAllPracMessage(Long orgId);

    Boolean update(SysOrgPracManageEntity sysOrgPracManageEntity);

    Boolean delete(Long Id,Long orgId,Long pracId);

    /**
     * 给学生
     * @return
     */
    List<SysAllOrgPracEntity> getAllPrac();

    Integer getAllPracNum(Long orgId);

}
