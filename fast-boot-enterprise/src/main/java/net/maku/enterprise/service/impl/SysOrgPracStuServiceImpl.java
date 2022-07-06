package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.common.OrgConstants;
import net.maku.enterprise.dao.SysOrgPracStuDao;
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
    public Boolean update(SysOrgPracStuEntity sysOrgPracStuEntity) {
        SysOrgPracStuEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("id",sysOrgPracStuEntity.getId())
                .eq("org_id", sysOrgPracStuEntity.getOrgId())
                .eq("prac_id",sysOrgPracStuEntity.getPracId())
                .eq("stu_id", sysOrgPracStuEntity.getStuId()));
        if(entity==null) {
            return false;
        }
        baseMapper.update(sysOrgPracStuEntity,new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", sysOrgPracStuEntity.getOrgId())
                .eq("prac_id",sysOrgPracStuEntity.getPracId())
                .eq("stu_id", sysOrgPracStuEntity.getStuId()));
        return true;
    }

    @Override
    public Boolean delete(Long Id,Long orgId, Long pracId,Long stuId) {
        SysOrgPracStuEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("id", Id)
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("stu_id", stuId));
        if(entity==null) {
            return false;
        }
        baseMapper.deleteById(Id);
        return true;
    }

    @Override
    public List<SysOrgPracStuEntity> getAllApplyStu(Long orgId, Long pracId) {
        List<SysOrgPracStuEntity> stuEntities = baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("status",OrgConstants.STU_STATUS_APPLY));
        return stuEntities;
    }



    @Override
    public List<SysOrgPracStuEntity> getAllWorkingStu(Long orgId, Long pracId) {
        List<SysOrgPracStuEntity> stuEntities = baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("status",OrgConstants.STU_STATUS_WORKING));
        return stuEntities;
    }

    @Override
    public List<SysOrgPracStuEntity> getAllOutStu(Long orgId, Long pracId) {
        List<SysOrgPracStuEntity> stuEntities = baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("status",OrgConstants.STU_STATUS_OUT));
        return stuEntities;
    }

   /* @Override
    public void addApplyStu(SysStuApplyPostDTO DTO) {
        SysOrgPracStuEntity stuEntity = new SysOrgPracStuEntity(DTO);
        baseMapper.insert(stuEntity);
    }*/



}
