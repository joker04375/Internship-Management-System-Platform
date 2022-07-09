package net.maku.service;

import net.maku.dto.SysStuApplyPostDTO;
import net.maku.entity.SysStuDetailsEntity;
import net.maku.framework.common.service.BaseService;

public interface SysStuDetailsService extends BaseService<SysStuDetailsEntity> {
    SysStuApplyPostDTO getStuAndPostByStuNum(String stuNum);

    SysStuDetailsEntity selectByUserId(Long userId);
}
