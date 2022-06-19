package net.maku.service;

import net.maku.entity.SysStuExcusedEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.framework.common.utils.Result;

import java.util.List;

public interface SysStuExcusedService extends BaseService<SysStuExcusedEntity> {
    void applyExcused(SysStuExcusedEntity sysStuExcusedEntity);

    List<SysStuExcusedEntity> selectExcuseds();

    void deleteExcused(Long id);
}
