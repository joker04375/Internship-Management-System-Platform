package net.maku.college.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// 很奇怪，这里在@Mapper级别上不设置"未映射的目标策略,才能正确映射
@Mapper
public interface SysCollegePracConvert {
    SysCollegePracConvert INSTANCE = Mappers.getMapper(SysCollegePracConvert.class);
}
