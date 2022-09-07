package net.maku.college.dao;

import net.maku.framework.common.dao.BaseDao;
import net.maku.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysCollegeUserDao extends BaseDao<SysUserEntity> {

    List<SysUserEntity> getAllUserByRoleAndOrg(String roleName,long orgId);
}
