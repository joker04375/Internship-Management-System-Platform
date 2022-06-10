package net.maku.convert;

import net.maku.system.convert.SysRoleConvert;
import net.maku.system.entity.SysUserEntity;
import net.maku.vo.CollegeUserVo;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);
    List<CollegeUserVo> convertList(List<SysUserEntity> sysUserEntityList);
}
