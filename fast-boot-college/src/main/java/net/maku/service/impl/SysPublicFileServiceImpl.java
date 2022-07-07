//package net.maku.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import lombok.AllArgsConstructor;
//import net.maku.dao.SysPublicFileDao;
//import net.maku.entity.SysPublicFileEntity;
//import net.maku.framework.common.service.impl.BaseServiceImpl;
//import net.maku.service.SysPublicFileService;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class SysPublicFileServiceImpl extends BaseServiceImpl<SysPublicFileDao,SysPublicFileEntity> implements SysPublicFileService{
//
//    @Override
//    public SysPublicFileEntity getFileById(int orgId, int pracId, String fileId) {
//        QueryWrapper<SysPublicFileEntity> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("org_id",orgId);
//        queryWrapper.eq("prac_id",pracId);
//        queryWrapper.eq("file_id",fileId);
//        return baseMapper.selectOne(queryWrapper);
//    }
//}
