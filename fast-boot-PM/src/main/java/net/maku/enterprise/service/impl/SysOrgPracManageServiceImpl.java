package net.maku.enterprise.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.college.service.SysCollegePracService;
import net.maku.enterprise.common.OrgConstants;
import net.maku.enterprise.common.OrgUtils;
import net.maku.enterprise.dao.SysOrgPracManageDao;
import net.maku.enterprise.entity.SysOrgCollegePracEntity;
import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.dto.SysAllOrgPracDto;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.service.SysOrgCollegePracService;
import net.maku.enterprise.service.SysOrgPracManageService;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.enterprise.vo.SysOrgPracManageVo;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description: 企业实习总表管理
 * @author: 25652
 * @time: 2022/6/10 18:16
 */
@Service
@AllArgsConstructor
public class SysOrgPracManageServiceImpl extends BaseServiceImpl<SysOrgPracManageDao, SysOrgPracManageEntity> implements SysOrgPracManageService {

    private SysOrgPracPostService sysOrgPracPostService;

    private SysCollegePracService sysCollegePracService;

    private SysOrgCollegePracService sysOrgCollegePracService;

    @Override
    public SysOrgPracManageEntity getOnePracMessage(Long Id)
    {
        SysOrgPracManageEntity sysOrgPracManageEntity = baseMapper.selectById(Id);
        return sysOrgPracManageEntity;
    }

    @Override
    public List<SysOrgPracManageEntity> getAllPracMessage(Long orgId){
        List<SysOrgPracManageEntity> list = baseMapper.selectList(new QueryWrapper<SysOrgPracManageEntity>().eq("org_id", orgId));
        return list;
    }

    @Override
    public Boolean update(SysOrgPracManageEntity sysOrgPracManageEntity) {
        SysOrgPracManageEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgPracManageEntity>()
                .eq("org_id", sysOrgPracManageEntity.getOrgId())
                .eq("prac_id", sysOrgPracManageEntity.getPracId())
                .eq("id", sysOrgPracManageEntity.getId()));

        if(entity==null)
        {
            return false;
        }
        baseMapper.update(sysOrgPracManageEntity,new QueryWrapper<SysOrgPracManageEntity>()
                .eq("org_id", sysOrgPracManageEntity.getOrgId())
                .eq("prac_id", sysOrgPracManageEntity.getPracId())
                .eq("id", sysOrgPracManageEntity.getId()));
        return true;

    }

    @Override
    public Boolean delete(Long Id,Long orgId,Long pracId) {
        SysOrgPracManageEntity entity = baseMapper.selectOne(new QueryWrapper<SysOrgPracManageEntity>()
                .eq("org_id", orgId)
                .eq("prac_id", pracId)
                .eq("id",Id));
        if(entity==null)
        {
            return false;
        }
        baseMapper.deleteById(Id);
        return true;
    }

    @Override
    public List<SysAllOrgPracDto> getAllPrac() {
        return baseMapper.getAllPrac();
    }

    @Override
    public Integer getAllPracNum(Long orgId) {
        List<SysOrgPracManageEntity> allPracMessage = getAllPracMessage(orgId);
        return allPracMessage.size();
    }


    /*
     *  by lzm
     * */
    @Override
    public List<SysAllOrgPracDto> search(Map<String,String> conditions) {
        return baseMapper.search(conditions);
    }

    /*
     *  by lzm
     * */
    @Override
    public List<SysAllOrgPracDto> getByPracIds(List<Long> pracIds) {
        return baseMapper.getByPracIds(pracIds);
    }

    /*
     *  by lzm
     * */
    @Override
    public SysAllOrgPracDto getByOrgAndPracId(long orgId, long pracId) {
        return baseMapper.getByOrgAndPracId(orgId, pracId);
    }

    @Override
    public Boolean savePracAndPost(SysOrgPracManageVo sysOrgPracManageVo) {

        Long timeId = sysCollegePracService.getActivePracByCollegeId(sysOrgPracManageVo.getCollegeId());
        if(timeId==null){
            return false;
        }
        /**
         * 根据时间戳生成唯一id
         *
         */
        Long pracId = OrgUtils.getIdByTime();

        SysOrgCollegePracEntity OrgCollegePracEntity = new SysOrgCollegePracEntity();
        OrgCollegePracEntity.setOrgId(sysOrgPracManageVo.getOrgId());
        OrgCollegePracEntity.setOrgPracId(pracId);
        OrgCollegePracEntity.setCollegeId(sysOrgPracManageVo.getCollegeId());
        OrgCollegePracEntity.setTimeId(timeId);
        sysOrgCollegePracService.save(OrgCollegePracEntity);

        SysOrgPracManageEntity manageEntity = sysOrgPracManageVo.getSysOrgPracManageEntity();
        manageEntity.setOrgId(sysOrgPracManageVo.getOrgId());
        manageEntity.setPracId(pracId);
        manageEntity.setPracStatus(OrgConstants.PRAC_STATUS_WORK);
        save(manageEntity);

        List<SysOrgPracPostEntity> list = sysOrgPracManageVo.getList();
        for (SysOrgPracPostEntity entity:list) {
            Long postId = OrgUtils.getIdByTime();
            entity.setOrgId(sysOrgPracManageVo.getOrgId());
            entity.setPostId(postId);
            entity.setPracId(pracId);
            entity.setStatus(OrgConstants.POST_STATUS_WAIT);
            entity.setVisible(OrgConstants.POST_VISIBLE_FALSE);
            sysOrgPracPostService.save(entity);
        }
        return true;
    }


}
