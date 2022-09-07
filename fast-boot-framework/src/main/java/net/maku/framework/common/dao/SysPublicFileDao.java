package net.maku.framework.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.maku.framework.common.entity.SysPublicFileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPublicFileDao extends BaseMapper<SysPublicFileEntity> {
}
