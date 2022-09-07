package net.maku.college.service;

import net.maku.college.entity.SysCollegePatternFileEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysCollegePatternFileService extends BaseService<SysCollegePatternFileEntity> {
    /**
     * 公司拿公司可见的公共文件
     * @param collegeId
     * @param timeId
     * @return lh
     */
    List<SysCollegePatternFileEntity> getAllOrgFile(Long collegeId, Long timeId);
}
