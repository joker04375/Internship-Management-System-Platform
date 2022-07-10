package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.dao.SysStuDetailsDao;
import net.maku.dto.SysStuApplyPostDTO;
import net.maku.entity.SysStuDetailsEntity;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.SysStuDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysStuDetailsServiceImpl extends BaseServiceImpl<SysStuDetailsDao, SysStuDetailsEntity> implements SysStuDetailsService {
    private SysStuDetailsDao sysStuDetailsDao;

    @Override
    public SysStuApplyPostDTO getStuAndPostByStuNum(String stuNum) {
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
        queryWrapper.eq(SysStuDetailsEntity::getStuId, SecurityUser.getUserId());
        sysStuDetailsDao.update(sysStuDetailsEntity,queryWrapper);
    }

}
