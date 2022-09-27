package net.maku.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.student.dao.SysStuExcusedDao;
import net.maku.student.entity.SysStuExcusedEntity;
import net.maku.student.service.SysYesOrNotService;
import net.maku.security.utils.UserHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
/**
 * 审批功能
 */
public class SysYesOrNotServiceImpl implements SysYesOrNotService {


    private final SysStuExcusedDao sysStuExcusedDao;

    @Override
    public void ColPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,1);
        queryWrapper.eq(SysStuExcusedEntity::getStuId, id);
        queryWrapper.eq(SysStuExcusedEntity::getColId, UserHolder.getUser().getOrgId());
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(2);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }

    @Override
    public void ColUnPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,1);
        queryWrapper.eq(SysStuExcusedEntity::getStuId,id);
        queryWrapper.eq(SysStuExcusedEntity::getColId, UserHolder.getUser().getOrgId());
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(-1);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }

    @Override
    public void EntPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,0);
        queryWrapper.eq(SysStuExcusedEntity::getStuId,id);
        queryWrapper.eq(SysStuExcusedEntity::getOrgId, UserHolder.getUser().getOrgId());
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(1);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }

    @Override
    public void EntUnPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,0);
        queryWrapper.eq(SysStuExcusedEntity::getStuId,id);
        queryWrapper.eq(SysStuExcusedEntity::getOrgId, UserHolder.getUser().getOrgId());
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(-1);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }
}
