package net.maku.student.service;

import net.maku.student.entity.CollegeModelFileEntity;

import java.util.List;

public interface SysStuFileService {
    List<CollegeModelFileEntity> selectModelFilesByStuId(Long userId);
}
