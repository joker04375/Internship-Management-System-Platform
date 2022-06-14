package net.maku.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeUserDao extends BaseDao<SysUserEntity> {

    List<SysUserEntity> getAllUserByRole(String roleName);
}
