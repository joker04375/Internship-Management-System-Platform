package net.maku.convert;

import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.entity.OrgPracManageEntity;
import net.maku.vo.PracVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

// 很奇怪，这里在@Mapper级别上不设置"未映射的目标策略,才能正确映射
@Mapper
public interface SysCollegePracConvert {
    SysCollegePracConvert INSTANCE = Mappers.getMapper(SysCollegePracConvert.class);
    List<PracVo> convertList(List<OrgPracManageEntity> orgPracManageEntityList);
}
