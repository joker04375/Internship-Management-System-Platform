package net.maku.system.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.framework.security.user.UserDetail;
import net.maku.system.entity.SysUserEntity;
import net.maku.system.vo.SysUserVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-10T15:35:33+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_322 (Amazon.com Inc.)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public SysUserVO convert(SysUserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysUserVO sysUserVO = new SysUserVO();

        sysUserVO.setId( entity.getId() );
        sysUserVO.setUsername( entity.getUsername() );
        sysUserVO.setPassword( entity.getPassword() );
        sysUserVO.setRealName( entity.getRealName() );
        sysUserVO.setAvatar( entity.getAvatar() );
        sysUserVO.setGender( entity.getGender() );
        sysUserVO.setEmail( entity.getEmail() );
        sysUserVO.setMobile( entity.getMobile() );
        sysUserVO.setOrgId( entity.getOrgId() );
        sysUserVO.setStatus( entity.getStatus() );
        sysUserVO.setSuperAdmin( entity.getSuperAdmin() );
        sysUserVO.setOrgName( entity.getOrgName() );
        sysUserVO.setCreateTime( entity.getCreateTime() );

        return sysUserVO;
    }

    @Override
    public SysUserEntity convert(SysUserVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysUserEntity sysUserEntity = new SysUserEntity();

        sysUserEntity.setId( vo.getId() );
        sysUserEntity.setCreateTime( vo.getCreateTime() );
        sysUserEntity.setUsername( vo.getUsername() );
        sysUserEntity.setPassword( vo.getPassword() );
        sysUserEntity.setRealName( vo.getRealName() );
        sysUserEntity.setAvatar( vo.getAvatar() );
        sysUserEntity.setGender( vo.getGender() );
        sysUserEntity.setEmail( vo.getEmail() );
        sysUserEntity.setMobile( vo.getMobile() );
        sysUserEntity.setOrgId( vo.getOrgId() );
        sysUserEntity.setSuperAdmin( vo.getSuperAdmin() );
        sysUserEntity.setStatus( vo.getStatus() );
        sysUserEntity.setOrgName( vo.getOrgName() );

        return sysUserEntity;
    }

    @Override
    public SysUserVO convert(UserDetail userDetail) {
        if ( userDetail == null ) {
            return null;
        }

        SysUserVO sysUserVO = new SysUserVO();

        sysUserVO.setId( userDetail.getId() );
        sysUserVO.setUsername( userDetail.getUsername() );
        sysUserVO.setPassword( userDetail.getPassword() );
        sysUserVO.setRealName( userDetail.getRealName() );
        sysUserVO.setAvatar( userDetail.getAvatar() );
        sysUserVO.setGender( userDetail.getGender() );
        sysUserVO.setEmail( userDetail.getEmail() );
        sysUserVO.setMobile( userDetail.getMobile() );
        sysUserVO.setOrgId( userDetail.getOrgId() );
        sysUserVO.setStatus( userDetail.getStatus() );
        sysUserVO.setSuperAdmin( userDetail.getSuperAdmin() );
        sysUserVO.setCreateTime( userDetail.getCreateTime() );

        return sysUserVO;
    }

    @Override
    public UserDetail convertDetail(SysUserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDetail userDetail = new UserDetail();

        userDetail.setId( entity.getId() );
        userDetail.setUsername( entity.getUsername() );
        userDetail.setPassword( entity.getPassword() );
        userDetail.setRealName( entity.getRealName() );
        userDetail.setAvatar( entity.getAvatar() );
        userDetail.setGender( entity.getGender() );
        userDetail.setEmail( entity.getEmail() );
        userDetail.setMobile( entity.getMobile() );
        userDetail.setOrgId( entity.getOrgId() );
        userDetail.setStatus( entity.getStatus() );
        userDetail.setSuperAdmin( entity.getSuperAdmin() );
        userDetail.setCreateTime( entity.getCreateTime() );

        return userDetail;
    }

    @Override
    public List<SysUserVO> convertList(List<SysUserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysUserVO> list1 = new ArrayList<SysUserVO>( list.size() );
        for ( SysUserEntity sysUserEntity : list ) {
            list1.add( convert( sysUserEntity ) );
        }

        return list1;
    }
}
