package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracInterviewEntity;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SysOrgPracInterviewService extends BaseService<SysOrgPracInterviewEntity> {

   List<SysOrgPracInterviewEntity> getAllInterviews(Long orgId, Long pracId);

   void update(SysOrgPracInterviewEntity sysOrgPracInterviewEntity);

   void delete(Long Id) ;
}
