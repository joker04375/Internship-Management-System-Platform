package net.maku.service;

import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.BaseService;
import net.maku.system.entity.SysUserEntity;
import net.maku.vo.CollegeUserVo;

import java.util.List;


public interface CollegeUserService extends BaseService<SysUserEntity> {

    List<SysUserEntity> getAllUserByRole(String roleName);

    PageResult<CollegeUserVo> page(Query query);
}

