package net.maku.security.service;

import net.maku.framework.common.service.BaseService;
import net.maku.security.entity.SysUserEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface SysUserService extends BaseService<SysUserEntity> {
    SysUserEntity CheckUser(String username);

    SysUserEntity selectById(Long id);

    Collection<? extends GrantedAuthority> getAuthorities(Long userId);
}
