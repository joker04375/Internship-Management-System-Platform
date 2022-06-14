package net.maku.system.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import net.maku.system.entity.SysOauthClientEntity;
import net.maku.system.vo.SysOauthClientVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-14T17:22:06+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_322 (Amazon.com Inc.)"
)
public class SysOauthClientConvertImpl implements SysOauthClientConvert {

    @Override
    public SysOauthClientVO convert(SysOauthClientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysOauthClientVO sysOauthClientVO = new SysOauthClientVO();

        sysOauthClientVO.setId( entity.getId() );
        sysOauthClientVO.setClientId( entity.getClientId() );
        sysOauthClientVO.setClientSecret( entity.getClientSecret() );
        sysOauthClientVO.setResourceIds( entity.getResourceIds() );
        sysOauthClientVO.setScope( entity.getScope() );
        String[] authorizedGrantTypes = entity.getAuthorizedGrantTypes();
        if ( authorizedGrantTypes != null ) {
            sysOauthClientVO.setAuthorizedGrantTypes( Arrays.copyOf( authorizedGrantTypes, authorizedGrantTypes.length ) );
        }
        sysOauthClientVO.setWebServerRedirectUri( entity.getWebServerRedirectUri() );
        sysOauthClientVO.setAuthorities( entity.getAuthorities() );
        sysOauthClientVO.setAccessTokenValidity( entity.getAccessTokenValidity() );
        sysOauthClientVO.setRefreshTokenValidity( entity.getRefreshTokenValidity() );
        sysOauthClientVO.setAdditionalInformation( entity.getAdditionalInformation() );
        sysOauthClientVO.setAutoapprove( entity.getAutoapprove() );
        sysOauthClientVO.setCreateTime( entity.getCreateTime() );

        return sysOauthClientVO;
    }

    @Override
    public SysOauthClientEntity convert(SysOauthClientVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysOauthClientEntity sysOauthClientEntity = new SysOauthClientEntity();

        sysOauthClientEntity.setId( vo.getId() );
        sysOauthClientEntity.setCreateTime( vo.getCreateTime() );
        sysOauthClientEntity.setClientId( vo.getClientId() );
        sysOauthClientEntity.setClientSecret( vo.getClientSecret() );
        sysOauthClientEntity.setResourceIds( vo.getResourceIds() );
        sysOauthClientEntity.setScope( vo.getScope() );
        String[] authorizedGrantTypes = vo.getAuthorizedGrantTypes();
        if ( authorizedGrantTypes != null ) {
            sysOauthClientEntity.setAuthorizedGrantTypes( Arrays.copyOf( authorizedGrantTypes, authorizedGrantTypes.length ) );
        }
        sysOauthClientEntity.setWebServerRedirectUri( vo.getWebServerRedirectUri() );
        sysOauthClientEntity.setAuthorities( vo.getAuthorities() );
        sysOauthClientEntity.setAccessTokenValidity( vo.getAccessTokenValidity() );
        sysOauthClientEntity.setRefreshTokenValidity( vo.getRefreshTokenValidity() );
        sysOauthClientEntity.setAdditionalInformation( vo.getAdditionalInformation() );
        sysOauthClientEntity.setAutoapprove( vo.getAutoapprove() );

        return sysOauthClientEntity;
    }

    @Override
    public List<SysOauthClientVO> convertList(List<SysOauthClientEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysOauthClientVO> list1 = new ArrayList<SysOauthClientVO>( list.size() );
        for ( SysOauthClientEntity sysOauthClientEntity : list ) {
            list1.add( convert( sysOauthClientEntity ) );
        }

        return list1;
    }
}
