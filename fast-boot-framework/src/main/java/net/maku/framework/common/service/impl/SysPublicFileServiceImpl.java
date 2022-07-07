package net.maku.framework.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.framework.common.dao.SysPublicFileDao;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.SysPublicFileService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@AllArgsConstructor
public class SysPublicFileServiceImpl extends BaseServiceImpl<SysPublicFileDao,SysPublicFileEntity> implements SysPublicFileService {

    @Override
    public SysPublicFileEntity getFileById(int orgId, int pracId, String fileId) {
        QueryWrapper<SysPublicFileEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("org_id",orgId);
        queryWrapper.eq("prac_id",pracId);
        queryWrapper.eq("file_id",fileId);
        return baseMapper.selectOne(queryWrapper);
    }

    public static SysPublicFileService sysPublicFileService;
    @PostConstruct
    public void init() {
        sysPublicFileService = this;
    }
}
