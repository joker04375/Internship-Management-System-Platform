package net.maku.college.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.BaseService;
import net.maku.system.entity.SysUserEntity;
import net.maku.college.vo.CollegeUserVo;

import java.util.List;


public interface SysCollegeUserService extends BaseService<SysUserEntity> {

    List<SysUserEntity> getAllUserByRoleAndOrg(String roleName, long orgId);

    PageResult<CollegeUserVo> page(Query query);
}

