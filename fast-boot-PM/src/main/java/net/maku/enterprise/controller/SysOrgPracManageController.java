package net.maku.enterprise.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.common.OrgUtils;
import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.service.SysOrgPracManageService;
import net.maku.enterprise.vo.SysOrgPracManageVo;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 企业实习总表管理
 * @author: 25652
 * @time: 2022/6/15 15:45
 */

@RestController
@RequestMapping("sys/orgs/prac")
@AllArgsConstructor
public class SysOrgPracManageController {

    private final SysOrgPracManageService sysOrgPracManageService;

    @PostMapping("manage/page/{orgId}")
    @Operation(summary = "获取企业所有实习信息  分页")
    public Result<PageResult<SysOrgPracManageEntity>> page(@RequestBody Query query,@PathVariable("orgId") Long orgId){
        List<SysOrgPracManageEntity> allPracMessage = sysOrgPracManageService.getAllPracMessage(orgId);
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allPracMessage);
        PageResult<SysOrgPracManageEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

    @GetMapping("manage/getOne/{id}")
    @Operation(summary = "获取企业单个实习信息")
    public Result<SysOrgPracManageEntity> getOneOrgPracDetail(@PathVariable("id") Long Id)
    {
        SysOrgPracManageEntity onePracMessage = sysOrgPracManageService.getOnePracMessage(Id);
        return Result.ok(onePracMessage);
    }

    @GetMapping("manage/getAll/{orgId}")
    @Operation(summary = "获取企业所有实习信息不分页")
    public Result<List<SysOrgPracManageEntity>> getAllOrgPracDetails(@PathVariable("orgId") Long orgId)
    {
        List<SysOrgPracManageEntity> list = sysOrgPracManageService.getAllPracMessage(orgId);
        return Result.ok(list);
    }


    @DeleteMapping("manage/{id}/{orgId}/{pracId}")
    @Operation(summary = "删除")
    public Result<String> delete(@PathVariable("id") Long Id
                                ,@PathVariable("orgId") Long orgId
                                ,@PathVariable("pracId") Long pracId){
        Boolean flag = sysOrgPracManageService.delete(Id, orgId, pracId);
        if(flag)
        {
            return Result.ok("删除成功");
        }
        return Result.error("操作非法");
    }

    @PostMapping("manage")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody SysOrgPracManageVo sysOrgPracManageVo){

        Boolean flag = sysOrgPracManageService.savePracAndPost(sysOrgPracManageVo);
        if(flag) {
            return Result.ok("新增成功");
        }
        return Result.error("操作失败");
    }

    @PutMapping("manage")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgPracManageEntity sysOrgPracManageEntity){
        Boolean flag = sysOrgPracManageService.update(sysOrgPracManageEntity);
        if(flag)
        {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

}
