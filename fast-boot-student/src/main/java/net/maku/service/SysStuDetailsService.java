package net.maku.service;

import net.maku.entity.SysStuDetailsEntity;
import net.maku.framework.common.service.BaseService;

public interface SysStuDetailsService extends BaseService<SysStuDetailsEntity> {
    SysStuDetailsEntity getByStuNum(String stuNum);
}
