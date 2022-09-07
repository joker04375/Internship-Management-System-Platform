package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dao.SysOrgCollegePracDao;
import net.maku.enterprise.entity.SysOrgCollegePracEntity;
import net.maku.enterprise.service.SysOrgCollegePracService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:学院实习与企业实习关联服务
 * @author: 25652
 * @time: 2022/7/10 21:07
 */
@Service
@AllArgsConstructor
public class SysOrgCollegePracServiceImpl extends BaseServiceImpl<SysOrgCollegePracDao, SysOrgCollegePracEntity>
        implements SysOrgCollegePracService {
    @Override
    public List<SysOrgCollegePracEntity> selectOrgByCollegeIdAndTimeID(Long collegeId, Long timeId) {
        List<SysOrgCollegePracEntity> entities = baseMapper.selectList(new QueryWrapper<SysOrgCollegePracEntity>()
                .eq("college_id", collegeId)
                .eq("time_id", timeId));
        return entities;
    }

    @Override
    public SysOrgCollegePracEntity selectCollegeIdAndTimeIDByOrgIdAndPracId(Long orgId, Long pracId) {
        SysOrgCollegePracEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgCollegePracEntity>()
                .eq("org_id", orgId)
                .eq("org_prac_id", pracId));
        return entity;
    }
}
