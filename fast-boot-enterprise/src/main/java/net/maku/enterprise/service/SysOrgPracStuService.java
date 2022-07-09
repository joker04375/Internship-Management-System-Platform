package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SysOrgPracStuService extends BaseService<SysOrgPracStuEntity> {

    SysOrgPracStuEntity getOnePracStuMessage(Long Id);

    List<SysOrgPracStuEntity> getAllPracStuMessage(Long orgId, Long pracId);

    void update(SysOrgPracStuEntity sysOrgPracStuEntity);

    void delete(Long Id) ;

    List<SysOrgPracStuEntity> getAllAccessOrTestStu(@PathVariable("orgId") Long orgId,
                                               @PathVariable("pracId") Long pracId);



}
