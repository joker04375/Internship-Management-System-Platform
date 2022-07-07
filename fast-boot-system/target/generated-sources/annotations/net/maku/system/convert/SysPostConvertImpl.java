package net.maku.system.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.system.entity.SysPostEntity;
import net.maku.system.vo.SysPostVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T11:12:31+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_322 (Amazon.com Inc.)"
)
public class SysPostConvertImpl implements SysPostConvert {

    @Override
    public SysPostVO convert(SysPostEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysPostVO sysPostVO = new SysPostVO();

        sysPostVO.setId( entity.getId() );
        sysPostVO.setPostCode( entity.getPostCode() );
        sysPostVO.setPostName( entity.getPostName() );
        sysPostVO.setSort( entity.getSort() );
        sysPostVO.setStatus( entity.getStatus() );
        sysPostVO.setCreateTime( entity.getCreateTime() );

        return sysPostVO;
    }

    @Override
    public SysPostEntity convert(SysPostVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysPostEntity sysPostEntity = new SysPostEntity();

        sysPostEntity.setId( vo.getId() );
        sysPostEntity.setCreateTime( vo.getCreateTime() );
        sysPostEntity.setPostCode( vo.getPostCode() );
        sysPostEntity.setPostName( vo.getPostName() );
        sysPostEntity.setSort( vo.getSort() );
        sysPostEntity.setStatus( vo.getStatus() );

        return sysPostEntity;
    }

    @Override
    public List<SysPostVO> convertList(List<SysPostEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysPostVO> list1 = new ArrayList<SysPostVO>( list.size() );
        for ( SysPostEntity sysPostEntity : list ) {
            list1.add( convert( sysPostEntity ) );
        }

        return list1;
    }
}
