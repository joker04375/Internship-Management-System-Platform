package net.maku.system.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.system.entity.SysMenuEntity;
import net.maku.system.vo.SysMenuVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-23T18:28:06+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_332 (Amazon.com Inc.)"
)
public class SysMenuConvertImpl implements SysMenuConvert {

    @Override
    public SysMenuEntity convert(SysMenuVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysMenuEntity sysMenuEntity = new SysMenuEntity();

        sysMenuEntity.setId( vo.getId() );
        sysMenuEntity.setCreateTime( vo.getCreateTime() );
        sysMenuEntity.setPid( vo.getPid() );
        sysMenuEntity.setName( vo.getName() );
        sysMenuEntity.setUrl( vo.getUrl() );
        sysMenuEntity.setAuthority( vo.getAuthority() );
        sysMenuEntity.setType( vo.getType() );
        sysMenuEntity.setOpenStyle( vo.getOpenStyle() );
        sysMenuEntity.setIcon( vo.getIcon() );
        sysMenuEntity.setSort( vo.getSort() );

        return sysMenuEntity;
    }

    @Override
    public SysMenuVO convert(SysMenuEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysMenuVO sysMenuVO = new SysMenuVO();

        sysMenuVO.setId( entity.getId() );
        sysMenuVO.setPid( entity.getPid() );
        sysMenuVO.setName( entity.getName() );
        sysMenuVO.setUrl( entity.getUrl() );
        sysMenuVO.setType( entity.getType() );
        sysMenuVO.setOpenStyle( entity.getOpenStyle() );
        sysMenuVO.setIcon( entity.getIcon() );
        sysMenuVO.setAuthority( entity.getAuthority() );
        sysMenuVO.setSort( entity.getSort() );
        sysMenuVO.setCreateTime( entity.getCreateTime() );

        return sysMenuVO;
    }

    @Override
    public List<SysMenuVO> convertList(List<SysMenuEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysMenuVO> list1 = new ArrayList<SysMenuVO>( list.size() );
        for ( SysMenuEntity sysMenuEntity : list ) {
            list1.add( convert( sysMenuEntity ) );
        }

        return list1;
    }
}
