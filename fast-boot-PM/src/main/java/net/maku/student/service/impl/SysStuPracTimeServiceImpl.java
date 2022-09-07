package net.maku.student.service.impl;

import lombok.AllArgsConstructor;

import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.student.dao.SysStuPracTimeDao;
import net.maku.student.entity.SysStuPracTimeEntity;
import net.maku.student.service.SysStuPracTimeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SysStuPracTimeServiceImpl extends BaseServiceImpl<SysStuPracTimeDao, SysStuPracTimeEntity> implements SysStuPracTimeService {
    private final SysStuPracTimeDao sysStuPracDao;
    public List<SysStuPracTimeEntity> getMyPracByUserId(Long userId){
        Date date = new Date();
        List<SysStuPracTimeEntity> sysStuPracEntities = sysStuPracDao.getMyPracByUserId(userId);
        for (SysStuPracTimeEntity sysStuPracEntity : sysStuPracEntities) {
            sysStuPracEntity.setYearAndMonth(sysStuPracEntity.getPracId());
        }
        return sysStuPracEntities;
    }
}
