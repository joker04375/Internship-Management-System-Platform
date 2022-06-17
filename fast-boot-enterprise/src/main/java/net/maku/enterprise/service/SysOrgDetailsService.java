package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.system.vo.SysOrgVO;

/**
 * 企业详情信息管理
 *
 * @author  LH
 */
public interface SysOrgDetailsService extends BaseService<SysOrgDetailsEntity>{

       SysOrgDetailsEntity getDetails(Long orgId);

        void update(SysOrgDetailsEntity sysOrgDetailsEntity);

        void delete(Long orgId);


}
