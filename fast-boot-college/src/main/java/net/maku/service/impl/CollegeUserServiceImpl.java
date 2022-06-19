package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.convert.SysUserConvert;
import net.maku.dao.CollegeUserDao;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.CollegeUserService;
import net.maku.system.entity.SysUserEntity;
import net.maku.vo.CollegeUserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CollegeUserServiceImpl extends BaseServiceImpl<CollegeUserDao, SysUserEntity> implements CollegeUserService {

    @Override
    public List<SysUserEntity> getAllUserByRole(String roleName) {
        List<SysUserEntity> users = baseMapper.getAllUserByRole(roleName);
        return users;
    }


    @Override
    public PageResult<CollegeUserVo> page(Query query) {
        IPage<SysUserEntity> page = baseMapper.selectPage(getPage(query), Wrappers.emptyWrapper());
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

}
