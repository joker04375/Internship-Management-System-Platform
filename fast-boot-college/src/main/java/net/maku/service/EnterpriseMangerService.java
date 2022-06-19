package net.maku.service;

import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.vo.EnterpriseResultVo;

import java.util.List;

public interface EnterpriseMangerService extends BaseService<SysOrgDetailsEntity> {
    List<SysOrgDetailsEntity> getAllEnterprise();
}
