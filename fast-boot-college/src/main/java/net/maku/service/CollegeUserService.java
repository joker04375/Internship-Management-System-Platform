package net.maku.service;

import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.BaseService;
import net.maku.system.entity.SysUserEntity;
import net.maku.vo.CollegeUserVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CollegeUserService extends BaseService<SysUserEntity> {

    List<SysUserEntity> getAllUserByRole(String roleName);

    PageResult<CollegeUserVo> page(Query query);
}

