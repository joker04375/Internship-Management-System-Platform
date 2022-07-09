package net.maku.dao;

import net.maku.dto.SysStuApplyPostDTO;
import net.maku.entity.SysStuDetailsEntity;
import net.maku.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysStuDetailsDao extends BaseDao<SysStuDetailsEntity> {
    /**
     * 根据学号返回该学生的应聘orgId,pracId,postId和一些基本信息
     * @param stuNum
     * @return
     */
    SysStuApplyPostDTO getStuAndPostByStuNum(String stuNum);
}
