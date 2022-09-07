package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.dto.SysAllOrgPracDto;
import net.maku.enterprise.vo.SysOrgPracManageVo;
import net.maku.framework.common.service.BaseService;

import java.util.List;
import java.util.Map;

public interface SysOrgPracManageService extends BaseService<SysOrgPracManageEntity> {

    SysOrgPracManageEntity getOnePracMessage(Long Id);

    /**
     * 给企业
     * @param orgId
     * @return
     */
    List<SysOrgPracManageEntity> getAllPracMessage(Long orgId);

    Boolean update(SysOrgPracManageEntity sysOrgPracManageEntity);

    Boolean delete(Long Id,Long orgId,Long pracId);

    /**
     * 给学生
     * @return
     */
    List<SysAllOrgPracDto> getAllPrac();

    Integer getAllPracNum(Long orgId);

    /**
     * author: leo
     * */
    List<SysAllOrgPracDto> search(Map<String,String> conditions);

    /**
     * author: leo
     * */
    List<SysAllOrgPracDto> getByPracIds(List<Long> pracId);

    /**
     * author: leo
     * */
    SysAllOrgPracDto getByOrgAndPracId(long orgId,long pracId);

    Boolean savePracAndPost(SysOrgPracManageVo sysOrgPracManageVo);

}
