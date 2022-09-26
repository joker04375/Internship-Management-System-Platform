package net.maku.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;

import net.maku.framework.common.service.impl.BaseServiceImpl;

import net.maku.student.dao.SysStuDetailsDao;
import net.maku.student.dto.SysStuApplyPostDTO;
import net.maku.student.entity.SysStuDetailsEntity;
import net.maku.student.service.SysStuDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysStuDetailsServiceImpl extends BaseServiceImpl<SysStuDetailsDao, SysStuDetailsEntity> implements SysStuDetailsService {
    private SysStuDetailsDao sysStuDetailsDao;

    @Override
    public SysStuApplyPostDTO getStuAndPostByStuNum(Long stuNum) {
        return sysStuDetailsDao.getStuAndPostByStuNum(stuNum);
    }

    @Override
    public SysStuDetailsEntity selectByUserId(Long userId) {
        LambdaQueryWrapper<SysStuDetailsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuDetailsEntity::getStuId,userId);
        return sysStuDetailsDao.selectOne(queryWrapper);
    }

    @Override
    public void updateByUserId(SysStuDetailsEntity sysStuDetailsEntity) {
        LambdaQueryWrapper<SysStuDetailsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuDetailsEntity::getStuId, sysStuDetailsEntity.getStuId());
        sysStuDetailsDao.update(sysStuDetailsEntity,queryWrapper);
    }

}
