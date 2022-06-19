package net.maku.system.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.system.entity.SysOrgEntity;
import net.maku.system.vo.SysOrgVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-19T10:53:36+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_322 (Amazon.com Inc.)"
)
public class SysOrgConvertImpl implements SysOrgConvert {

    @Override
    public SysOrgEntity convert(SysOrgVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysOrgEntity sysOrgEntity = new SysOrgEntity();

        sysOrgEntity.setId( vo.getId() );
        sysOrgEntity.setCreateTime( vo.getCreateTime() );
        sysOrgEntity.setPid( vo.getPid() );
        sysOrgEntity.setName( vo.getName() );
        sysOrgEntity.setSort( vo.getSort() );
        sysOrgEntity.setParentName( vo.getParentName() );

        return sysOrgEntity;
    }

    @Override
    public SysOrgVO convert(SysOrgEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysOrgVO sysOrgVO = new SysOrgVO();

        sysOrgVO.setId( entity.getId() );
        sysOrgVO.setPid( entity.getPid() );
        sysOrgVO.setName( entity.getName() );
        sysOrgVO.setSort( entity.getSort() );
        sysOrgVO.setCreateTime( entity.getCreateTime() );
        sysOrgVO.setParentName( entity.getParentName() );

        return sysOrgVO;
    }

    @Override
    public List<SysOrgVO> convertList(List<SysOrgEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysOrgVO> list1 = new ArrayList<SysOrgVO>( list.size() );
        for ( SysOrgEntity sysOrgEntity : list ) {
            list1.add( convert( sysOrgEntity ) );
        }

        return list1;
    }
}
