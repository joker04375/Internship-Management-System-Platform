package net.maku.enterprise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dao.SysOrgPracPostDao;
import net.maku.enterprise.entity.interation.SysAllOrgPostEntity;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:企业岗位管理
 * @author: 25652
 * @time: 2022/6/15 18:24
 */
@Service
@AllArgsConstructor
public class SysOrgPracPostServiceImpl extends BaseServiceImpl<SysOrgPracPostDao, SysOrgPracPostEntity>
        implements SysOrgPracPostService {

    private SysOrgPracPostDao sysOrgPracPostDao;


    @Override
    public SysOrgPracPostEntity getOnePracPostMessage(Long Id)
    {
        SysOrgPracPostEntity sysOrgPracPostEntity = baseMapper.selectById(Id);
        return sysOrgPracPostEntity;
    }

    @Override
    public List<SysOrgPracPostEntity> getAllPracPostMessage(Long orgId ,Long pracId){
        List<SysOrgPracPostEntity> list = baseMapper.selectList(new QueryWrapper<SysOrgPracPostEntity>()
                .eq("org_id",orgId)
                .eq("prac_id",pracId));
        return list;
    }

    @Override
    public void update(SysOrgPracPostEntity sysOrgPracPostEntity) {
        baseMapper.update(sysOrgPracPostEntity,new QueryWrapper<SysOrgPracPostEntity>()
                .eq("org_id", sysOrgPracPostEntity.getOrgId())
                .eq("prac_id",sysOrgPracPostEntity.getPracId())
                .eq("post_id",sysOrgPracPostEntity.getPostId()));
    }

    @Override
    public void delete(Long Id) {
        baseMapper.deleteById(Id);
    }

    @Override
    public List<SysAllOrgPostEntity> getAllOrgPost(){
        List<SysAllOrgPostEntity> allOrgPost = sysOrgPracPostDao.getAllOrgPost();
        return allOrgPost;
    }

    @Override
    public void changePostStatus(Integer id, Integer status) {
        SysOrgPracPostEntity sysOrgPracPostEntity = baseMapper.selectById(id);
        sysOrgPracPostEntity.setStatus(status);
        baseMapper.updateById(sysOrgPracPostEntity);
    }

}
