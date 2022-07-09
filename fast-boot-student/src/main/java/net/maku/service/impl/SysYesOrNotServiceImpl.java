package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.dao.SysStuExcusedDao;
import net.maku.entity.SysStuExcusedEntity;
import net.maku.service.SysYesOrNotService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysYesOrNotServiceImpl implements SysYesOrNotService {

    private final SysStuExcusedDao sysStuExcusedDao;

    @Override
    public void ColPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,1);
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(2);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }

    @Override
    public void ColUnPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,1);
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(-1);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }

    @Override
    public void EntPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,1);
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(2);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }

    @Override
    public void EntUnPassExcused(Long id) {
        LambdaQueryWrapper<SysStuExcusedEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuExcusedEntity::getStatus,0);
        SysStuExcusedEntity sysStuExcusedEntity = sysStuExcusedDao.selectOne(queryWrapper);
        sysStuExcusedEntity.setStatus(-1);
        sysStuExcusedDao.updateById(sysStuExcusedEntity);
    }
}
