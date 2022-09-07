package net.maku.student.service;



import net.maku.framework.common.service.BaseService;
import net.maku.student.entity.SysStuExcusedEntity;

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
    List<SysStuExcusedEntity> selectExcuseds(Long stuId);


    /**
     * 删除请假
     * @param id
     */
    void deleteExcused(Long id);

    /**
     * 学院查询请假
     * @return
     */
    List<SysStuExcusedEntity> selectCollegeExcusedsByColIdAndTimeId(Long colId,Long timeId);

    /**
     * 企业查询请假
     * @return
     */
    List<SysStuExcusedEntity> selectEnterpriseExcusedsByOrgIdAndPracId(Long orgId, Long pracId);
}
