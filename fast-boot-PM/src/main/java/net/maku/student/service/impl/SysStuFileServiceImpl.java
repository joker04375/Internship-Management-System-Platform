package net.maku.student.service.impl;

import lombok.AllArgsConstructor;

import net.maku.student.dao.SysStuFileDao;
import net.maku.student.entity.CollegeModelFileEntity;
import net.maku.student.service.SysStuFileService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysStuFileServiceImpl implements SysStuFileService {
    private final SysStuFileDao sysStuFileDao;

    /**
     * 根据当前学生id，联合企业学生管理表中正在实习的状态取出学院相关id，再联查搜索模板文件
     * @param userId
     * @return
     */
    @Override
    public CollegeModelFileEntity selectModelFilesByStuId(Long userId) {
        return sysStuFileDao.selectModelFilesByStuId(userId);
    }

}
