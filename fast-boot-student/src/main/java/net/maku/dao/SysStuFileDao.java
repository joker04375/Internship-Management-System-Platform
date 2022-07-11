package net.maku.dao;

import net.maku.entity.ModelFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysStuFileDao {
    public ModelFileEntity selectModelFilesByStuId(@Param("userId") Long userId);
}
