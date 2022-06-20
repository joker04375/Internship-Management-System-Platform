package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.dao.SysStuDetailsDao;
import net.maku.entity.SysStuDetailsEntity;
import net.maku.entity.SysStuExcusedEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.SysStuDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysStuDetailsServiceImpl extends BaseServiceImpl<SysStuDetailsDao, SysStuDetailsEntity> implements SysStuDetailsService {
    private final SysStuDetailsDao sysStuDetailsDao;

    @Override
    public SysStuDetailsEntity getByStuNum(String stuNum) {
        LambdaQueryWrapper<SysStuDetailsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuDetailsEntity::getStuNum,stuNum);
        SysStuDetailsEntity sysStuDetailsEntity = sysStuDetailsDao.selectOne(queryWrapper);
        return sysStuDetailsEntity;
    }
}
