package net.maku.enterprise.dao;


import net.maku.enterprise.entity.interation.SysAllOrgPostEntity;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysOrgPracPostDao extends BaseDao<SysOrgPracPostEntity> {
    List<SysAllOrgPostEntity> getAllOrgPost();

}
