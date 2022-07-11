package net.maku.service;

import net.maku.entity.ModelFileEntity;

public interface SysStuFileService {
    ModelFileEntity selectModelFilesByStuId(Long userId);
}
