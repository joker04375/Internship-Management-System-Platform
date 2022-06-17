package net.maku.enterprise.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.enterprise.service.SysOrgDetailsService;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description:  企业详情控制器
 * @author: 25652
 * @time: 2022/6/10 18:46
 */

@RestController
@RequestMapping("sys/orgs")
@AllArgsConstructor
public class SysOrgDetailsController {

    private final SysOrgDetailsService sysOrgDetailsService;

    @GetMapping("details/{id}")
    @Operation(summary = "企业详情信息")
    public Result<SysOrgDetailsEntity> getOrgDetails(@PathVariable("id") Long orgId)
    {
        SysOrgDetailsEntity details = sysOrgDetailsService.getDetails(orgId);
        return Result.ok(details);
    }

    @DeleteMapping("details/{id}")
    @Operation(summary = "删除")
    public Result<String> delete(@PathVariable("id") Long id){
        sysOrgDetailsService.delete(id);
        return Result.ok("删除成功");
    }

    @PostMapping("details")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysOrgDetailsEntity sysOrgDetailsEntity){
        sysOrgDetailsService.save(sysOrgDetailsEntity);
        return Result.ok("新增成功");
    }

    @PutMapping("details")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgDetailsEntity sysOrgDetailsEntity){
        sysOrgDetailsService.update(sysOrgDetailsEntity);
        return Result.ok("修改成功");
    }



}
