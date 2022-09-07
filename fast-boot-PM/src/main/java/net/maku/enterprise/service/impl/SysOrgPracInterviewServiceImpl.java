package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dao.SysOrgPracInterviewDao;
import net.maku.enterprise.entity.SysOrgPracInterviewEntity;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.enterprise.service.SysOrgPracInterviewService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:笔试面试管理
 * @author: 25652
 * @time: 2022/6/18 10:38
 */

@Service
@AllArgsConstructor
public class SysOrgPracInterviewServiceImpl extends BaseServiceImpl<SysOrgPracInterviewDao, SysOrgPracInterviewEntity>
        implements SysOrgPracInterviewService {

    @Override
    public List<SysOrgPracInterviewEntity> getAllInterviews(Long orgId, Long pracId){
        List<SysOrgPracInterviewEntity> sysOrgPracInterviewEntities = baseMapper.selectList(
                new QueryWrapper<SysOrgPracInterviewEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId));
        return sysOrgPracInterviewEntities;
    }

    @Override
    public void update(SysOrgPracInterviewEntity sysOrgPracInterviewEntity) {
                baseMapper.update(sysOrgPracInterviewEntity,
                new QueryWrapper<SysOrgPracInterviewEntity>()
                        .eq("org_id", sysOrgPracInterviewEntity.getOrgId())
                        .eq("prac_id", sysOrgPracInterviewEntity.getPracId())
                        .eq("interview_id", sysOrgPracInterviewEntity.getInterviewId()));
    }

    @Override
    public void delete(Long Id) {
            baseMapper.deleteById(Id);
    }


}
