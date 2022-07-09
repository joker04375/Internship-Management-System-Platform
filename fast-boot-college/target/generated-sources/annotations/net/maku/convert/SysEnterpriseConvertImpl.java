package net.maku.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.vo.EnterpriseResultVo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-09T15:46:16+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class SysEnterpriseConvertImpl implements SysEnterpriseConvert {

    @Override
    public List<EnterpriseResultVo> convertList(List<SysOrgDetailsEntity> sysUserEntityList) {
        if ( sysUserEntityList == null ) {
            return null;
        }

        List<EnterpriseResultVo> list = new ArrayList<EnterpriseResultVo>( sysUserEntityList.size() );
        for ( SysOrgDetailsEntity sysOrgDetailsEntity : sysUserEntityList ) {
            list.add( sysOrgDetailsEntityToEnterpriseResultVo( sysOrgDetailsEntity ) );
        }

        return list;
    }

    protected EnterpriseResultVo sysOrgDetailsEntityToEnterpriseResultVo(SysOrgDetailsEntity sysOrgDetailsEntity) {
        if ( sysOrgDetailsEntity == null ) {
            return null;
        }

        EnterpriseResultVo enterpriseResultVo = new EnterpriseResultVo();

        enterpriseResultVo.setOrgId( sysOrgDetailsEntity.getOrgId() );
        enterpriseResultVo.setName( sysOrgDetailsEntity.getName() );
        enterpriseResultVo.setIntro( sysOrgDetailsEntity.getIntro() );
        enterpriseResultVo.setAddress( sysOrgDetailsEntity.getAddress() );
        enterpriseResultVo.setType( sysOrgDetailsEntity.getType() );

        return enterpriseResultVo;
    }
}
