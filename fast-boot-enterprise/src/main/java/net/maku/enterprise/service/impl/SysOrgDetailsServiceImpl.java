package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dao.SysOrgDetailsDao;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.enterprise.service.SysOrgDetailsService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: 25652
 * @time: 2022/6/10 18:16
 */
@Service
@AllArgsConstructor
public class SysOrgDetailsServiceImpl extends BaseServiceImpl<SysOrgDetailsDao, SysOrgDetailsEntity> implements SysOrgDetailsService {

    @Override
    public List<SysOrgDetailsEntity> getAllOrgDetails() {
        return baseMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public SysOrgDetailsEntity getDetails(Long Id) {
        SysOrgDetailsEntity sysOrgDetailsEntity = baseMapper.selectOne(new QueryWrapper<SysOrgDetailsEntity>()
                .eq("org_id",Id));
        return sysOrgDetailsEntity;
    }

    @Override
    public Boolean update(SysOrgDetailsEntity sysOrgDetailsEntity) {
        SysOrgDetailsEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgDetailsEntity>()
                .eq("id", sysOrgDetailsEntity.getId())
                .eq("org_id", sysOrgDetailsEntity.getOrgId()));
        if(entity==null)
        {
            return false;
        }
        updateById(sysOrgDetailsEntity);
        return true;
    }

    @Override
    public Boolean delete(Long Id,Long orgId) {
        SysOrgDetailsEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgDetailsEntity>()
                .eq("id", Id)
                .eq("org_id", orgId));
        if(entity==null)
        {
            return false;
        }
        baseMapper.delete(new QueryWrapper<SysOrgDetailsEntity>()
                .eq("id", Id)
                .eq("org_id", orgId));
        return true;
    }

}
