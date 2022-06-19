package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.service.BaseService;
import net.maku.system.query.SysUserQuery;
import net.maku.system.vo.SysUserVO;

import java.util.List;

public interface SysOrgPracManageService extends BaseService<SysOrgPracManageEntity> {

    SysOrgPracManageEntity getOnePracMessage(Long Id);

    List<SysOrgPracManageEntity> getAllPracMessage(Long orgId);

    void update(SysOrgPracManageEntity sysOrgPracManageEntity);

    void delete(Long Id);

}
