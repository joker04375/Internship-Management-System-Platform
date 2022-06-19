package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javafx.print.PaperSource;
import lombok.AllArgsConstructor;
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
    public SysOrgPracStuEntity getOnePracStuMessage(Long orgId, Long pracId, Long postId,Long stuId) {
        SysOrgPracStuEntity sysOrgPracStuEntity = baseMapper.selectOne(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("post_id",postId)
                .eq("stu_id",stuId));
        return sysOrgPracStuEntity;
    }

    @Override
    public List<SysOrgPracStuEntity> getAllPracStuMessage(Long orgId, Long pracId, Long postId) {
        List<SysOrgPracStuEntity> list = baseMapper.selectList(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id",orgId)
                .eq("prac_id",pracId)
                .eq("post_id",postId));
        return list;
    }

    @Override
    public void update(SysOrgPracStuEntity sysOrgPracStuEntity) {
        baseMapper.update(sysOrgPracStuEntity,new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", sysOrgPracStuEntity.getOrgId())
                .eq("prac_id",sysOrgPracStuEntity.getPracId())
                .eq("post_id",sysOrgPracStuEntity.getPostId())
                .eq("stu_id", sysOrgPracStuEntity.getPracId()));
    }

    @Override
    public void delete(Long orgId, Long pracId, Long postId, Long stuId) {
        baseMapper.delete(new QueryWrapper<SysOrgPracStuEntity>()
                .eq("org_id", orgId)
                .eq("prac_id",pracId)
                .eq("post_id",postId)
                .eq("stu_id", stuId));
    }
}
