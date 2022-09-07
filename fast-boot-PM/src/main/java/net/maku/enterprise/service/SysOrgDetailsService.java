package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

/**
 * 企业详情信息管理
 *
 * @author  LH
 */
public interface SysOrgDetailsService extends BaseService<SysOrgDetailsEntity>{

        /**
        * author: leo
        * */
        List<SysOrgDetailsEntity> getAllOrgDetails();

        /**
         * author: leo
         * */
        List<SysOrgDetailsEntity> getByQuery(String query);

        SysOrgDetailsEntity getDetails(Long Id);

        Boolean update(SysOrgDetailsEntity sysOrgDetailsEntity);

        Boolean delete(Long Id,Long orgId);

}
