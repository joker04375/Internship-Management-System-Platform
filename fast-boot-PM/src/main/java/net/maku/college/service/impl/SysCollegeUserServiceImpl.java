package net.maku.college.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import net.maku.college.convert.SysUserConvert;
import net.maku.college.dao.SysCollegeUserDao;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.college.service.SysCollegeUserService;
import net.maku.system.entity.SysUserEntity;
import net.maku.college.vo.CollegeUserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SysCollegeUserServiceImpl extends BaseServiceImpl<SysCollegeUserDao, SysUserEntity> implements SysCollegeUserService {

    @Override
    public List<SysUserEntity> getAllUserByRoleAndOrg(String roleName, long orgId) {
        List<SysUserEntity> users = baseMapper.getAllUserByRoleAndOrg(roleName,orgId);
        return users;
    }


    @Override
    public PageResult<CollegeUserVo> page(Query query) {
        IPage<SysUserEntity> page = baseMapper.selectPage(getPage(query), Wrappers.emptyWrapper());
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

}
