package net.maku.student.service;


import net.maku.framework.common.service.BaseService;
import net.maku.student.entity.SysStuPracEntity;

import java.util.List;

public interface SysStuPracService extends BaseService<SysStuPracEntity> {
    /**
     * 查询我的实习
     * @param userId
     * @return
     */
    List<SysStuPracEntity> getMyPracByUserId(Long userId);
}
