package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SysOrgPracStuService extends BaseService<SysOrgPracStuEntity> {

    SysOrgPracStuEntity getOnePracStuMessage(Long Id);

    List<SysOrgPracStuEntity> getAllPracStuMessage(Long orgId, Long pracId);

    Boolean update(SysOrgPracStuEntity sysOrgPracStuEntity);

    Boolean delete(Long Id,Long orgId, Long pracId,Long stuId) ;

    List<SysOrgPracStuEntity> getAllApplyStu( Long orgId, Long pracId);

    List<SysOrgPracStuEntity> getAllWorkingStu(Long orgId, Long pracId);

    List<SysOrgPracStuEntity> getAllOutStu(Long orgId, Long pracId);
    //void addApplyStu(SysStuApplyPostDTO sysStuApplyPostDTO);


}
