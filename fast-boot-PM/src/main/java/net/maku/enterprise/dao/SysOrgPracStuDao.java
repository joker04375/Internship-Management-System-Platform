package net.maku.enterprise.dao;

import net.maku.enterprise.dto.SysStuPracDetailDto;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.dao.BaseDao;
import net.maku.student.entity.SysStuPostEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 25652
 * @time: 2022/6/15 21:29
 */
@Mapper
public interface SysOrgPracStuDao extends BaseDao<SysOrgPracStuEntity> {
    List<SysOrgPracStuEntity> getAllStusByPracs(List<Long> pracId);

    List<SysStuPracDetailDto> getAllStuPracByOrgAndPracId(@Param("orgId")long orgId, @Param("pracId")long pracId);


    List<SysOrgPracStuEntity> getStusByConditions(Map<String,String> map);


}
