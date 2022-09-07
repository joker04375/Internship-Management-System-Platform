package net.maku.utils;

import net.maku.system.entity.SysUserEntity;

public class UserHolder {
    private static final ThreadLocal<SysUserEntity> tl = new ThreadLocal<>();

    public static void saveUser(SysUserEntity user){
        tl.set(user);
    }

    public static SysUserEntity getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
