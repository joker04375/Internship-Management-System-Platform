package net.maku.dao;

import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.entity.SysStuPostEntity;
import net.maku.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysStuManageDao extends BaseDao<SysStuPostEntity> {
}
