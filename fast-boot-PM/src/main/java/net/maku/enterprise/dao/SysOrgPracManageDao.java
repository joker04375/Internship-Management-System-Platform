package net.maku.enterprise.dao;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.dto.SysAllOrgPracDto;
import net.maku.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysOrgPracManageDao extends BaseDao<SysOrgPracManageEntity>{

    List<SysAllOrgPracDto> getAllPrac();

    /**
     * author: leo
     * */
    List<SysAllOrgPracDto> getByPracIds(List<Long> pracIds);

    /**
     * author: leo
     * */
    SysAllOrgPracDto getByOrgAndPracId(long orgId,long pracId);

    /**
     * author: leo
     * */
    List<SysAllOrgPracDto> search(Map<String, String> query);
}
