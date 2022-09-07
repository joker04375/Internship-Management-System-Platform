package net.maku.security.service;

import net.maku.framework.common.service.BaseService;
import net.maku.system.entity.SysUserEntity;

public interface SysUserService extends BaseService<SysUserEntity> {
    SysUserEntity CheckUser(String username,String password);
}
