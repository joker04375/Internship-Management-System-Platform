package net.maku.dao;

import net.maku.entity.SysStuPracEntity;
import net.maku.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysStuPracDao extends BaseDao<SysStuPracEntity> {
    /**
     * 根据学生id返回对应的实习信息
     * @param userId
     * @return
     */
    List<SysStuPracEntity> getMyPracByUserId(@Param("userId")Long userId);
}
