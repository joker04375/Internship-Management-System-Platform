package net.maku.dao;

import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.framework.common.dao.BaseDao;
import net.maku.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnterpriseMangerDao extends BaseDao<SysOrgDetailsEntity> {

    List<SysUserEntity> getAllUserByRole(String roleName);

    List<SysOrgDetailsEntity> getAllEnterprise();
}
