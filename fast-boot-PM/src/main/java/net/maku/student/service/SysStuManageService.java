package net.maku.student.service;


import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.student.entity.SysStuPracTimeEntity;

import java.util.List;

public interface SysStuManageService extends BaseService<SysOrgPracStuEntity> {
    /**
     * 查询我的实习
     * @param userId
     * @return
     */
    List<SysStuPracTimeEntity> getMyPracByUserId(Long userId);
}
