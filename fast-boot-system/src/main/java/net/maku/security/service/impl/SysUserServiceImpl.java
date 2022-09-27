package net.maku.security.service.impl;

import lombok.AllArgsConstructor;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.security.dao.SysUserDao;
import net.maku.security.service.SysUserService;
import net.maku.security.entity.SysUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static net.maku.security.constant.Authority.*;

@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    private SysUserDao sysUserDao;

    @Override
    public SysUserEntity CheckUser(String username) {
        return sysUserDao.selectUserByUserName(username);
    }

    @Override
    public SysUserEntity selectById(Long id) {
        return sysUserDao.selectById(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(Long userId) {
        SysUserEntity sysUserEntity = this.selectById(userId);

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                switch (sysUserEntity.getRoleId().intValue()) {
                    case 1:
                        return AUTHORITY_STUDENT;
                    case 2:
                        return AUTHORITY_COLLEGE;
                    case 3:
                        return AUTHORITY_ENTERPRISE;
                    default:
                        return AUTHORITY_ADMIN;
                }
            }
        });
        return list;
    }
}
