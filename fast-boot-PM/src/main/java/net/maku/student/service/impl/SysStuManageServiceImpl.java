package net.maku.student.service.impl;


import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.student.dao.SysStuManageDao;
import net.maku.student.entity.SysStuPracTimeEntity;
import net.maku.student.service.SysStuManageService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 我的实习
 */
@Service
@AllArgsConstructor
public class SysStuManageServiceImpl extends BaseServiceImpl<SysStuManageDao, SysOrgPracStuEntity> implements SysStuManageService {
    private final SysStuManageDao sysStuManageDao;
    public List<SysStuPracTimeEntity> getMyPracByUserId(Long userId){
        Date date = new Date();
        List<SysStuPracTimeEntity> sysStuPracEntities = sysStuManageDao.getMyPracByUserId(userId);
        for (SysStuPracTimeEntity sysStuPracEntity : sysStuPracEntities) {
            sysStuPracEntity.setYearAndMonth(sysStuPracEntity.getPracId());
        }
        return sysStuPracEntities;
    }
}
