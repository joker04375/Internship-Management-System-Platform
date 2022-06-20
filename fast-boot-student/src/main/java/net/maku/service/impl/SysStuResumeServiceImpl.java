package net.maku.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.dao.SysStuResumeDao;
import net.maku.dto.SysStuResumeDTO;
import net.maku.entity.SysStuResumeEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.SysStuResumeService;
import net.maku.vo.SysStuResumeVO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysStuResumeServiceImpl extends BaseServiceImpl<SysStuResumeDao, SysStuResumeEntity> implements SysStuResumeService {
    private SysStuResumeDao sysStuResumeDao;

    @Override
    public SysStuResumeEntity selectByUserId(Long userId) {
        //根据当前用户id
        LambdaQueryWrapper<SysStuResumeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuResumeEntity::getUserId,userId);
        SysStuResumeEntity sysStuResumeEntity = sysStuResumeDao.selectOne(queryWrapper);
        return sysStuResumeEntity;
    }


    @Override
    public void deleteResumeByUserId() {
        //根据当前用户id
        LambdaQueryWrapper<SysStuResumeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuResumeEntity::getUserId,SecurityUser.getUserId());

        //删除
        sysStuResumeDao.delete(queryWrapper);
    }
}
