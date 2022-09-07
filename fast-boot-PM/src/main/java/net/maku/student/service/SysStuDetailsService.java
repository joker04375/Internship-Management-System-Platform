package net.maku.student.service;


import net.maku.framework.common.service.BaseService;
import net.maku.student.dto.SysStuApplyPostDTO;
import net.maku.student.entity.SysStuDetailsEntity;

public interface SysStuDetailsService extends BaseService<SysStuDetailsEntity> {
    SysStuApplyPostDTO getStuAndPostByStuNum(String stuNum);

    SysStuDetailsEntity selectByUserId(Long userId);

    void updateByUserId(SysStuDetailsEntity sysStuDetailsEntity);
}
