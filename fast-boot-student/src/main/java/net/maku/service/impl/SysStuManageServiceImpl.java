package net.maku.service.impl;

import net.maku.dao.SysStuManageDao;
import net.maku.entity.SysOrgPracStuEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.SysStuManageService;
import org.springframework.stereotype.Service;

/**
 * 实习申报
 */
@Service
public class SysStuManageServiceImpl extends BaseServiceImpl<SysStuManageDao, SysOrgPracStuEntity> implements SysStuManageService {
}
