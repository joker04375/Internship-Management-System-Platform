package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.dao.SysStuExcusedDao;
import net.maku.entity.SysStuExcusedEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.SysStuExcusedService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class SysStuExcusedServiceImpl extends BaseServiceImpl<SysStuExcusedDao, SysStuExcusedEntity> implements SysStuExcusedService {

    private final SysStuExcusedDao sysStuExcusedDao;

    @Override
    public void applyExcused(SysStuExcusedEntity sysStuExcusedEntity) {
        sysStuExcusedEntity.setStuId(SecurityUser.getUserId());
        sysStuExcusedDao.insert(sysStuExcusedEntity);
    }

    @Override
    public List<SysStuExcusedEntity> selectExcuseds() {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStuId,SecurityUser.getUserId());
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedDao.selectList(queryWrapper);
        if(sysStuExcusedEntities==null){
            return Collections.emptyList();
        }
        return sysStuExcusedEntities;
    }

    @Override
    public void deleteExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        //状态0，id匹配
        queryWrapper.eq(SysStuExcusedEntity::getStatus,0);
        queryWrapper.eq(SysStuExcusedEntity::getId,id);
        sysStuExcusedDao.delete(queryWrapper);
    }


    @Override
    public List<SysStuExcusedEntity> selectCollegeExcuseds() {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();

        //状态0，id匹配
        queryWrapper.eq(SysStuExcusedEntity::getStatus,1);
        queryWrapper.eq(SysStuExcusedEntity::getColId,SecurityUser.getUserId());
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedDao.selectList(queryWrapper);
        if(sysStuExcusedEntities==null){
            return Collections.emptyList();
        }
        return sysStuExcusedEntities;
    }

    @Override
    public List<SysStuExcusedEntity> selectEnterpriseExcuseds() {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();

        //状态0，id匹配
        queryWrapper.eq(SysStuExcusedEntity::getStatus,0);
        queryWrapper.eq(SysStuExcusedEntity::getOrgId,SecurityUser.getUserId());
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedDao.selectList(queryWrapper);
        if(sysStuExcusedEntities==null){
            return Collections.emptyList();
        }
        return sysStuExcusedEntities;
    }

}
