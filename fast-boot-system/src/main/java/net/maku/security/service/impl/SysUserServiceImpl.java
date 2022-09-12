package net.maku.security.service.impl;

import lombok.AllArgsConstructor;
import net.maku.framework.common.service.impl.BaseServiceImpl;
import net.maku.framework.common.utils.PasswordEncoder;
import net.maku.security.dao.SysUserDao;
import net.maku.security.service.SysUserService;
import net.maku.system.entity.SysUserEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    private SysUserDao sysUserDao;

    @Override
    public SysUserEntity CheckUser(String username) {
        return sysUserDao.selectUserByUserName(username);
    }
}
