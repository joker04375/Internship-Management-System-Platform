package net.maku.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.framework.common.service.impl.BaseServiceImpl;

import net.maku.student.dao.SysStuExcusedDao;
import net.maku.student.entity.SysStuExcusedEntity;
import net.maku.student.service.SysStuExcusedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class SysStuExcusedServiceImpl extends BaseServiceImpl<SysStuExcusedDao, SysStuExcusedEntity> implements SysStuExcusedService {
    @Resource
    private final SysStuExcusedDao sysStuExcusedDao;

    @Override
    public void applyExcused(SysStuExcusedEntity sysStuExcusedEntity) {
        sysStuExcusedEntity.setStuId(sysStuExcusedEntity.getStuId());
        sysStuExcusedDao.insert(sysStuExcusedEntity);
    }

    @Override
    public List<SysStuExcusedEntity> selectExcuseds(Long stuId) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStuId,stuId);
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
    public List<SysStuExcusedEntity> selectCollegeExcusedsByColIdAndTimeId(Long colId, Long timeId) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();

        //状态0，id匹配
        queryWrapper.eq(SysStuExcusedEntity::getStatus,1);
        queryWrapper.eq(SysStuExcusedEntity::getColId,colId);
        queryWrapper.eq(SysStuExcusedEntity::getTimeId,timeId);
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedDao.selectList(queryWrapper);
        if(sysStuExcusedEntities==null){
            return Collections.emptyList();
        }
        return sysStuExcusedEntities;

    }

    @Override
    public List<SysStuExcusedEntity> selectEnterpriseExcusedsByOrgIdAndPracId(Long orgId, Long pracId) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();

        //状态0，id匹配
        queryWrapper.eq(SysStuExcusedEntity::getStatus,0);
        queryWrapper.eq(SysStuExcusedEntity::getOrgId,orgId);
        queryWrapper.eq(SysStuExcusedEntity::getPracId,pracId);
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedDao.selectList(queryWrapper);
        if(sysStuExcusedEntities==null){
            return Collections.emptyList();
        }
        return sysStuExcusedEntities;
    }

}
