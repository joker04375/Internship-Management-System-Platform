package net.maku.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.system.entity.SysUserEntity;
import net.maku.vo.CollegeUserVo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-23T18:49:50+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public List<CollegeUserVo> convertList(List<SysUserEntity> sysUserEntityList) {
        if ( sysUserEntityList == null ) {
            return null;
        }

        List<CollegeUserVo> list = new ArrayList<CollegeUserVo>( sysUserEntityList.size() );
        for ( SysUserEntity sysUserEntity : sysUserEntityList ) {
            list.add( sysUserEntityToCollegeUserVo( sysUserEntity ) );
        }

        return list;
    }

    protected CollegeUserVo sysUserEntityToCollegeUserVo(SysUserEntity sysUserEntity) {
        if ( sysUserEntity == null ) {
            return null;
        }

        CollegeUserVo collegeUserVo = new CollegeUserVo();

        collegeUserVo.setWorkNumber( sysUserEntity.getWorkNumber() );
        collegeUserVo.setRealName( sysUserEntity.getRealName() );
        collegeUserVo.setGender( sysUserEntity.getGender() );
        collegeUserVo.setIdCard( sysUserEntity.getIdCard() );
        collegeUserVo.setOrgName( sysUserEntity.getOrgName() );

        return collegeUserVo;
    }
}
