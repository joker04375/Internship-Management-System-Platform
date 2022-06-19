package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.convert.SysEnterpriseConvert;
import net.maku.dao.EnterpriseMangerDao;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.service.EnterpriseMangerService;
import net.maku.vo.EnterpriseResultVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnterpriseMangerServiceImpl extends BaseServiceImpl<EnterpriseMangerDao, SysOrgDetailsEntity> implements EnterpriseMangerService {
    @Override
    public List<SysOrgDetailsEntity> getAllEnterprise() {
        List<SysOrgDetailsEntity> allEnterprise = baseMapper.selectList(new QueryWrapper<>());
        return allEnterprise;
    }
}
