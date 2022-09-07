package net.maku.enterprise.service;


import net.maku.enterprise.entity.SysOrgCollegePracEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

/**
 * 企业与学院实习关联服务
 *
 * @author  LH
 */
public interface SysOrgCollegePracService extends BaseService<SysOrgCollegePracEntity> {
    // 学院用
    List<SysOrgCollegePracEntity> selectOrgByCollegeIdAndTimeID(Long collegeId, Long timeId);

    SysOrgCollegePracEntity selectCollegeIdAndTimeIDByOrgIdAndPracId(Long orgId,Long pracId);
}
