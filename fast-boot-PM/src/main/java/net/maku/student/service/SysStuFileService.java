package net.maku.student.service;

import net.maku.student.entity.CollegeModelFileEntity;

public interface SysStuFileService {
    CollegeModelFileEntity selectModelFilesByStuId(Long userId);
}
