package net.maku.student.dao;

import net.maku.student.entity.CollegeModelFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysStuFileDao {
    /**
     * 根据学生id和timeId]查找发布的模板文件
     * @param userId
     * @return
     */
    List<CollegeModelFileEntity> selectModelFilesByStuId(@Param("userId") Long userId);
}
