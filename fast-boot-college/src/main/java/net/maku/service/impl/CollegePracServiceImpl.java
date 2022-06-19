package net.maku.service.impl;

import lombok.AllArgsConstructor;
import net.maku.dao.CollegePracDao;
import net.maku.entity.OrgPracManageEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.CollegePracService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CollegePracServiceImpl extends BaseServiceImpl<CollegePracDao, OrgPracManageEntity> implements CollegePracService {
//    @Override
//    public List<PracVo> getAllPrac() {
//        List<OrgPracManageEntity> allPrac = baseMapper.getAllPrac();
//        return SysCollegePracConvert.INSTANCE.convertList(allPrac);
//    }

    @Override
    public List<OrgPracManageEntity> getAllPrac() {
        List<OrgPracManageEntity> allPrac = baseMapper.getAllPrac();
        return allPrac;
    }
}
