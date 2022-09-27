package net.maku.security.utils;


import net.maku.security.entity.SysUserEntity;

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
