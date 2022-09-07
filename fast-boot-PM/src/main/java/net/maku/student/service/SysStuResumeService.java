package net.maku.student.service;


import net.maku.framework.common.service.BaseService;
import net.maku.student.entity.SysStuResumeEntity;

public interface SysStuResumeService extends BaseService<SysStuResumeEntity> {
    /**
     * 查询简历
     * @param userId
     * @return
     */
    SysStuResumeEntity selectByUserId(Long userId);

    /**
     * 删除简历
     */
    void deleteResumeByUserId();

}
