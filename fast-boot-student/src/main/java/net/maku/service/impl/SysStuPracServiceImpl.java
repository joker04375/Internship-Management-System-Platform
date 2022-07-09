package net.maku.service.impl;

import lombok.AllArgsConstructor;
import net.maku.dao.SysStuPracDao;
import net.maku.entity.SysStuPracEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.SysStuPracService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class SysStuPracServiceImpl extends BaseServiceImpl<SysStuPracDao, SysStuPracEntity> implements SysStuPracService {
    private final SysStuPracDao sysStuPracDao;
    public List<SysStuPracEntity> getMyPracByUserId(Long userId){
        List<SysStuPracEntity> sysStuPracEntities = sysStuPracDao.getMyPracByUserId(userId);
        for (SysStuPracEntity sysStuPracEntity : sysStuPracEntities) {
            String date = sysStuPracEntity.getPracId().toString().substring(0,8);
            sysStuPracEntity.setYearAndMonth(date);
        }
        return sysStuPracEntities;
    }
}
