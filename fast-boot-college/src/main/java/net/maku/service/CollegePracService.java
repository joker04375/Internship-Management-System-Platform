package net.maku.service;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.entity.OrgPracManageEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.vo.PracVo;

import java.util.List;

public interface CollegePracService extends BaseService<OrgPracManageEntity> {
    List<OrgPracManageEntity> getAllPrac();
}
