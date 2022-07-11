package net.maku.service.impl;

import lombok.AllArgsConstructor;
import net.maku.dao.SysStuFileDao;
import net.maku.entity.ModelFileEntity;
import net.maku.service.SysStuFileService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysStuFileServiceImpl implements SysStuFileService {
    private final SysStuFileDao sysStuFileDao;
    @Override
    public ModelFileEntity selectModelFilesByStuId(Long userId) {
        return sysStuFileDao.selectModelFilesByStuId(userId);
    }
}
