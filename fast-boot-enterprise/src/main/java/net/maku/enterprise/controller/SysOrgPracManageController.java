package net.maku.enterprise.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.service.SysOrgPracManageService;
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




    @GetMapping("manage/{orgId}/{pracId}")
    @Operation(summary = "企业实习信息")
    public Result<SysOrgPracManageEntity> getOrgDetails(@PathVariable("orgId") Long orgId,@PathVariable("pracId") Long pracId)
    {
        SysOrgPracManageEntity onePracMessage = sysOrgPracManageService.getOnePracMessage(orgId, pracId);
        return Result.ok(onePracMessage);
    }

    @GetMapping("manage/{orgId}")
    @Operation(summary = "企业实习信息")
    public Result<List<SysOrgPracManageEntity>> getOrgDetails(@PathVariable Long orgId)
    {
        List<SysOrgPracManageEntity> list = sysOrgPracManageService.getAllPracMessage(orgId);
        return Result.ok(list);
    }


    @DeleteMapping("manage/{orgId}/{pracId}")
    @Operation(summary = "删除")
    public Result<String> delete(@PathVariable("orgId") Long orgId,@PathVariable("pracId") Long pracId){
        sysOrgPracManageService.delete(orgId,pracId);
        return Result.ok("删除成功");
    }

    @PostMapping("manage")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysOrgPracManageEntity sysOrgPracManageEntity){
        sysOrgPracManageService.save(sysOrgPracManageEntity);
        return Result.ok("新增成功");
    }

    @PutMapping("manage")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgPracManageEntity sysOrgPracManageEntity){
        sysOrgPracManageService.update(sysOrgPracManageEntity);
        return Result.ok("修改成功");
    }

}
