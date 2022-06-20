package net.maku.service;

import net.maku.dto.SysStuResumeDTO;
import net.maku.entity.SysStuResumeEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.framework.common.utils.Result;
import net.maku.vo.SysStuResumeVO;

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
