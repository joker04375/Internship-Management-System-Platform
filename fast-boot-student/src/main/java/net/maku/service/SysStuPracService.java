package net.maku.service;

import net.maku.entity.SysStuPracEntity;
import net.maku.framework.common.service.BaseService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface SysStuPracService extends BaseService<SysStuPracEntity> {
    /**
     * 查询我的实习
     * @param userId
     * @return
     */
    List<SysStuPracEntity> getMyPracByUserId(Long userId);
}
