package net.maku.enterprise.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dao.SysOrgPracManageDao;
import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.service.SysOrgPracManageService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 企业实习总表管理
 * @author: 25652
 * @time: 2022/6/10 18:16
 */
@Service
@AllArgsConstructor
public class SysOrgPracManageServiceImpl extends BaseServiceImpl<SysOrgPracManageDao, SysOrgPracManageEntity> implements SysOrgPracManageService {

    @Override
    public SysOrgPracManageEntity getOnePracMessage(Long Id)
    {
        SysOrgPracManageEntity sysOrgPracManageEntity = baseMapper.selectById(Id);
        return sysOrgPracManageEntity;
    }

    @Override
    public List<SysOrgPracManageEntity> getAllPracMessage(Long orgId){
        List<SysOrgPracManageEntity> list = baseMapper.selectList(new QueryWrapper<SysOrgPracManageEntity>().eq("org_id", orgId));
        return list;
    }

    @Override
    public void update(SysOrgPracManageEntity sysOrgPracManageEntity) {
        baseMapper.update(sysOrgPracManageEntity,new QueryWrapper<SysOrgPracManageEntity>()
                .eq("org_id", sysOrgPracManageEntity.getOrgId())
                .eq("prac_id",sysOrgPracManageEntity.getPracId()));
    }

    @Override
    public void delete(Long Id) {
        baseMapper.deleteById(Id);
    }

}
