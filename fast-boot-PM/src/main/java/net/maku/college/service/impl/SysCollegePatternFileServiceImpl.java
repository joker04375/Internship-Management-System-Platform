package net.maku.college.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.college.dao.SysCollegePatternFileDao;
import net.maku.college.entity.SysCollegePatternFileEntity;
import net.maku.college.service.SysCollegePatternFileService;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class SysCollegePatternFileServiceImpl extends BaseServiceImpl<SysCollegePatternFileDao, SysCollegePatternFileEntity> implements SysCollegePatternFileService {
    @Override
    public List<SysCollegePatternFileEntity> getAllOrgFile(Long collegeId, Long timeId) {
        List<SysCollegePatternFileEntity> entities = baseMapper.selectList(new QueryWrapper<SysCollegePatternFileEntity>()
                .eq("college_id", collegeId)
                .eq("time_id", timeId)
                .eq("is_common", 1)
                .eq("is_org_read", 1));
        return entities;
    }
}
