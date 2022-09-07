package net.maku.college.service;

import net.maku.college.entity.SysCollegePracEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysCollegePracService extends BaseService<SysCollegePracEntity> {
    void postInternship(String year,String name,int collegeId);

    List<SysCollegePracEntity> getAllOrderByYear(long collegeId);


    /**
     *
     * @param collegeId
     * @return  Lh
     */
    Long getActivePracByCollegeId(Long collegeId);
}
