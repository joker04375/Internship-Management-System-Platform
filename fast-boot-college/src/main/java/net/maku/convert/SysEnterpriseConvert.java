package net.maku.convert;


import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.vo.EnterpriseResultVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysEnterpriseConvert {
    SysEnterpriseConvert INSTANCE = Mappers.getMapper(SysEnterpriseConvert.class);
    List<EnterpriseResultVo> convertList(List<SysOrgDetailsEntity> sysUserEntityList);
}
