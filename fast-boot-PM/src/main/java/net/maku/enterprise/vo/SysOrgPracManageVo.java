package net.maku.enterprise.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.entity.SysOrgPracPostEntity;

import java.util.List;

/**
 * @description:
 * @author: 25652
 * @time: 2022/7/15 22:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysOrgPracManageVo {

    private Long orgId;

    private Long collegeId;

    private SysOrgPracManageEntity sysOrgPracManageEntity;

    private List<SysOrgPracPostEntity> list;


}
