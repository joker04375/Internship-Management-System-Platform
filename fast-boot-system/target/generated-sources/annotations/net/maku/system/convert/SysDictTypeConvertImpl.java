package net.maku.system.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import net.maku.system.entity.SysDictTypeEntity;
import net.maku.system.vo.SysDictTypeVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-19T10:53:36+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_322 (Amazon.com Inc.)"
)
public class SysDictTypeConvertImpl implements SysDictTypeConvert {

    @Override
    public SysDictTypeVO convert(SysDictTypeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysDictTypeVO sysDictTypeVO = new SysDictTypeVO();

        sysDictTypeVO.setId( entity.getId() );
        sysDictTypeVO.setDictType( entity.getDictType() );
        sysDictTypeVO.setDictName( entity.getDictName() );
        sysDictTypeVO.setRemark( entity.getRemark() );
        sysDictTypeVO.setSort( entity.getSort() );
        sysDictTypeVO.setCreateTime( entity.getCreateTime() );
        sysDictTypeVO.setUpdateTime( entity.getUpdateTime() );

        return sysDictTypeVO;
    }

    @Override
    public SysDictTypeEntity convert(SysDictTypeVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysDictTypeEntity sysDictTypeEntity = new SysDictTypeEntity();

        sysDictTypeEntity.setId( vo.getId() );
        sysDictTypeEntity.setCreateTime( vo.getCreateTime() );
        sysDictTypeEntity.setUpdateTime( vo.getUpdateTime() );
        sysDictTypeEntity.setDictType( vo.getDictType() );
        sysDictTypeEntity.setDictName( vo.getDictName() );
        sysDictTypeEntity.setRemark( vo.getRemark() );
        sysDictTypeEntity.setSort( vo.getSort() );

        return sysDictTypeEntity;
    }

    @Override
    public List<SysDictTypeVO> convertList(List<SysDictTypeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysDictTypeVO> list1 = new ArrayList<SysDictTypeVO>( list.size() );
        for ( SysDictTypeEntity sysDictTypeEntity : list ) {
            list1.add( convert( sysDictTypeEntity ) );
        }

        return list1;
    }
}
