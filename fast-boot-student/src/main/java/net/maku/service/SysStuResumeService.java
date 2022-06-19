package net.maku.service;

import net.maku.dto.SysStuResumeDTO;
import net.maku.entity.SysStuResumeEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.framework.common.utils.Result;
import net.maku.vo.SysStuResumeVO;

public interface SysStuResumeService extends BaseService<SysStuResumeEntity> {
    SysStuResumeEntity selectByUserId(Long userId);

    void deleteResumeByUserId();
}
