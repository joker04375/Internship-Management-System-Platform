package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dao.SysOrgDetailsDao;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.enterprise.service.SysOrgDetailsService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.system.entity.SysUserRoleEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public void update(SysOrgDetailsEntity sysOrgDetailsEntity) {
        updateById(sysOrgDetailsEntity);
    }

    @Override
    public void delete(Long Id) {
       baseMapper.deleteById(Id);
    }

}
