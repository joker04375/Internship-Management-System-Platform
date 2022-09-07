package net.maku.student.dao;

import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.framework.common.dao.BaseDao;
import net.maku.student.entity.SysStuPracTimeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysStuManageDao extends BaseDao<SysOrgPracStuEntity> {
    /**
     * 根据学生id返回对应的实习信息
     * @param userId
     * @return
     */
    List<SysStuPracTimeEntity> getMyPracByUserId(@Param("userId")Long userId);
}
