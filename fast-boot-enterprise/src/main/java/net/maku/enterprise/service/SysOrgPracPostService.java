package net.maku.enterprise.service;


import net.maku.enterprise.entity.interation.SysAllOrgPostEntity;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.framework.common.service.BaseService;

import java.util.List;

public interface SysOrgPracPostService extends BaseService<SysOrgPracPostEntity> {


    SysOrgPracPostEntity getOnePracPostMessage(Long Id);

    List<SysOrgPracPostEntity> getAllPracPostMessage(Long orgId,Long pracId);

    Boolean update(SysOrgPracPostEntity sysOrgPracPostEntity);

    Boolean delete(Long Id,Long orgId,Long pracId,Long postId) ;

    /**
     *给学生
     * @return
     */
    List<SysAllOrgPostEntity> getAllOrgPost();

    /**
     * 学院审核岗位
     * @param id
     * @param status
     */
    void changePostStatus(Integer id,Integer status);
}
