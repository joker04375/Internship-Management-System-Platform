package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dto.SysStuPracDetailDto;
import net.maku.enterprise.common.OrgConstants;
import net.maku.enterprise.dao.SysOrgPracStuDao;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.enterprise.service.SysOrgPracStuService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * author:lzm
     */
    @Override
    public List<SysOrgPracStuEntity> getAllStusByPracs(List<Long> pracId) {
        return baseMapper.getAllStusByPracs(pracId);
    }

    /**
     * author:lzm
     */
    @Override
    public List<SysStuPracDetailDto> getAllStuPracByOrgAndPracId(Long orgId, Long pracId) {
        return baseMapper.getAllStuPracByOrgAndPracId(orgId, pracId);
    }

    /**
     * author:lzm
     */
    @Override
    public List<SysOrgPracStuEntity> getAllStuPracByOrgAndPracAndPostId(Long orgId, Long pracId, Long postId) {
        return baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id",orgId)
                .eq("prac_id",pracId)
                .eq("post_id",postId));
    }

    /**
     * author:lzm
     */
    @Override
    public List<SysOrgPracStuEntity> getStusByConditions(Map<String, String> map) {
        return baseMapper.getStusByConditions(map);
    }

    @Override
    public Boolean changeInterviewTime(Long orgId, Long pracId, Long stuId,Integer interview) {
        SysOrgPracStuEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("stu_id", stuId));
        if(entity==null) {
            return false;
        } else {
            entity.setStatus(OrgConstants.STU_STATUS_TEST);
            entity.setInterview(interview);
            entity.setUpdateTime(new Date());
            update(entity);
            return true;
        }
    }

    @Override
    public Boolean changeStuStatus(Long orgId, Long pracId, Long stuId, Integer status) {
        SysOrgPracStuEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("stu_id", stuId));
        if(entity==null) {
            return false;
        } else {
            entity.setStatus(status);
            entity.setInterview(OrgConstants.STU_INTERVIEW_DEFAULT);
            entity.setUpdateTime(new Date());
            update(entity);
            return true;
        }
    }

    @Override
    public List<SysOrgPracStuEntity> getAllStuByInterType(Long orgId, Long pracId, Integer interType) {
        List<SysOrgPracStuEntity> list = baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("status", OrgConstants.STU_STATUS_TEST)
                .eq("interview", interType));
        return list;
    }

   /* @Override
    public void addApplyStu(SysStuApplyPostDTO DTO) {
        SysOrgPracStuEntity stuEntity = new SysOrgPracStuEntity(DTO);
        baseMapper.insert(stuEntity);
    }*/



}
