package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import net.maku.convert.SysUserConvert;
import net.maku.dao.CollegeUserDao;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.CollegeUserService;
import net.maku.system.entity.SysUserEntity;
import net.maku.vo.CollegeUserVo;

import java.sql.Wrapper;
import java.util.List;

public class CollegeUserServiceImpl extends BaseServiceImpl<CollegeUserDao, SysUserEntity> implements CollegeUserService {

    /*
    * 学院对用户管理（对老师，学生进行数据库上的筛选）
    * */
    @Override
    public List<CollegeUserVo> getAllUserByRole() {
        List<SysUserEntity> users = baseMapper.getAllUserByRole();
        return SysUserConvert.INSTANCE.convertList(users);
    }

    @Override
    public PageResult<CollegeUserVo> page(Query query) {
        IPage<SysUserEntity> page = baseMapper.selectPage(getPage(query), Wrappers.emptyWrapper());
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

}
