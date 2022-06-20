package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javafx.print.PaperSource;
import lombok.AllArgsConstructor;
import net.maku.enterprise.common.OrgConstants;
import net.maku.enterprise.dao.SysOrgPracStuDao;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.enterprise.service.SysOrgPracStuService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: 25652
 * @time: 2022/6/15 21:32
 */

@Service
@AllArgsConstructor
public class SysOrgPracStuServiceImpl extends BaseServiceImpl<SysOrgPracStuDao, SysOrgPracStuEntity>
        implements SysOrgPracStuService {


    @Override
    public SysOrgPracStuEntity getOnePracStuMessage(Long Id) {
        SysOrgPracStuEntity sysOrgPracStuEntity = baseMapper.selectById(Id);
        return sysOrgPracStuEntity;
    }

    @Override
    public List<SysOrgPracStuEntity> getAllPracStuMessage(Long orgId, Long pracId) {
        List<SysOrgPracStuEntity> list = baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id",orgId)
                .eq("prac_id",pracId));
        return list;
    }

    @Override
    public void update(SysOrgPracStuEntity sysOrgPracStuEntity) {
        baseMapper.update(sysOrgPracStuEntity,new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", sysOrgPracStuEntity.getOrgId())
                .eq("prac_id",sysOrgPracStuEntity.getPracId())
                .eq("post_id",sysOrgPracStuEntity.getPostId())
                .eq("stu_id", sysOrgPracStuEntity.getStuId()));
    }

    @Override
    public void delete(Long Id) {
        baseMapper.deleteById(Id);
    }

    @Override
    public List<SysOrgPracStuEntity> getAllAccessOrTestStu(Long orgId, Long pracId) {
        List<SysOrgPracStuEntity> stuEntities = baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .between("status", OrgConstants.STU_STATUS_TEST, OrgConstants.STU_STATUS_SUCCESS));
        return stuEntities;
    }
}
