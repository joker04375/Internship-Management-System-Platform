package net.maku.security.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    SysUserEntity CheckUser(@Param("username") String name, @Param("password") String password);
}
