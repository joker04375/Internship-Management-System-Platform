package net.maku.enterprise.dao;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.entity.interation.SysAllOrgPracEntity;
import net.maku.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysOrgPracManageDao extends BaseDao<SysOrgPracManageEntity>{

    List<SysAllOrgPracEntity> getAllPrac();

}
