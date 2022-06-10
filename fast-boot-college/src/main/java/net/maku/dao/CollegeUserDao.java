package net.maku.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.system.entity.SysUserEntity;
import java.util.List;

public interface CollegeUserDao extends BaseDao<SysUserEntity> {

    List<SysUserEntity> getAllUserByRole();
}
