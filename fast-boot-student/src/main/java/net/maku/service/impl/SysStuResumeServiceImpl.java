package net.maku.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import lombok.AllArgsConstructor;
import net.maku.dao.SysStuResumeDao;

import net.maku.entity.SysStuResumeEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.SysStuResumeService;

import org.springframework.stereotype.Service;

/**
 * 学生简历功能
 */
@Service
@AllArgsConstructor
public class SysStuResumeServiceImpl extends BaseServiceImpl<SysStuResumeDao, SysStuResumeEntity> implements SysStuResumeService {
    private SysStuResumeDao sysStuResumeDao;

    @Override
    public SysStuResumeEntity selectByUserId(Long userId) {
        //根据当前用户id
        LambdaQueryWrapper<SysStuResumeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuResumeEntity::getStuId,userId);
        SysStuResumeEntity sysStuResumeEntity = sysStuResumeDao.selectOne(queryWrapper);
        return sysStuResumeEntity;
    }


    @Override
    public void deleteResumeByUserId() {
        //根据当前用户id
        LambdaQueryWrapper<SysStuResumeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuResumeEntity::getStuId,SecurityUser.getUserId());

        //删除
        sysStuResumeDao.delete(queryWrapper);
    }
}
