package net.maku.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.maku.entity.OrgPracManageEntity;
import net.maku.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegePracDao extends BaseMapper<OrgPracManageEntity> {
    List<OrgPracManageEntity> getAllPrac();
}
