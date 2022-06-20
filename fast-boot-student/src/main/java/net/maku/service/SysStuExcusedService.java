package net.maku.service;

import net.maku.entity.SysStuExcusedEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.framework.common.utils.Result;

import java.util.List;

public interface SysStuExcusedService extends BaseService<SysStuExcusedEntity> {
    /**
     * 添加请假
     * @param sysStuExcusedEntity
     */
    void applyExcused(SysStuExcusedEntity sysStuExcusedEntity);

    /**
     * 查询请假
     * @return
     */
    List<SysStuExcusedEntity> selectExcuseds();


    /**
     * 删除请假
     * @param id
     */
    void deleteExcused(Long id);


}
