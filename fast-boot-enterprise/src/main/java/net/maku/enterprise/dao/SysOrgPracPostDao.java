package net.maku.enterprise.dao;

<<<<<<< HEAD
=======
import net.maku.enterprise.entity.SysAllOrgPostEntity;
>>>>>>> origin/main
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.framework.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD

@Mapper
public interface SysOrgPracPostDao extends BaseDao<SysOrgPracPostEntity> {
=======
import java.util.List;


@Mapper
public interface SysOrgPracPostDao extends BaseDao<SysOrgPracPostEntity> {
    List<SysAllOrgPostEntity> getAllOrgPost();
>>>>>>> origin/main
}
