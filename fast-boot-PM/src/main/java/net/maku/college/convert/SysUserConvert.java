package net.maku.college.convert;

import net.maku.system.entity.SysUserEntity;
import net.maku.college.vo.CollegeUserVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

//在@Mapper级别上设置"未映射的目标策略,以下该策略可以忽略未映射的属性
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);
    List<CollegeUserVo> convertList(List<SysUserEntity> sysUserEntityList);
}
