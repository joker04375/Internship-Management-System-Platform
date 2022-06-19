package net.maku.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.entity.OrgPracManageEntity;
import net.maku.vo.PracVo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-19T10:53:40+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_322 (Amazon.com Inc.)"
)
public class SysCollegePracConvertImpl implements SysCollegePracConvert {

    @Override
    public List<PracVo> convertList(List<OrgPracManageEntity> orgPracManageEntityList) {
        if ( orgPracManageEntityList == null ) {
            return null;
        }

        List<PracVo> list = new ArrayList<PracVo>( orgPracManageEntityList.size() );
        for ( OrgPracManageEntity orgPracManageEntity : orgPracManageEntityList ) {
            list.add( orgPracManageEntityToPracVo( orgPracManageEntity ) );
        }

        return list;
    }

    protected PracVo orgPracManageEntityToPracVo(OrgPracManageEntity orgPracManageEntity) {
        if ( orgPracManageEntity == null ) {
            return null;
        }

        PracVo pracVo = new PracVo();

        pracVo.setOrgName( orgPracManageEntity.getOrgName() );
        pracVo.setPracName( orgPracManageEntity.getPracName() );
        pracVo.setPracAddr( orgPracManageEntity.getPracAddr() );
        pracVo.setPracNum( orgPracManageEntity.getPracNum() );
        pracVo.setPracStatus( orgPracManageEntity.getPracStatus() );

        return pracVo;
    }
}
