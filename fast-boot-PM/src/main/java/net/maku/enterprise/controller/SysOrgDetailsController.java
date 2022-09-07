package net.maku.enterprise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.common.OrgUtils;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.enterprise.service.SysOrgDetailsService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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


    @GetMapping("details/{orgId}")
    @Operation(summary = "单个企业详情信息")
    public Result<SysOrgDetailsEntity> getOrgDetails(@PathVariable("orgId") Long id)
    {
        SysOrgDetailsEntity details = sysOrgDetailsService.getDetails(id);
        return Result.ok(details);
    }


    @PostMapping("page")
    @Operation(summary = "所有企业详情信息")
    public Result<PageResult<SysOrgDetailsEntity>> getAllOrgDetails(@RequestBody Query query)
    {
        List<SysOrgDetailsEntity> allOrgDetails = sysOrgDetailsService.getAllOrgDetails();
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allOrgDetails);
        PageResult<SysOrgDetailsEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());

        return Result.ok(result);
    }

    @DeleteMapping("details/{id}/{orgId}")
    @Operation(summary = "删除")
    public Result<String> delete(@PathVariable("id") Long id,@PathVariable("orgId") Long orgId){
        Boolean flag = sysOrgDetailsService.delete(id, orgId);
        if(flag)
        {
            return Result.ok("删除成功");
        }
        return Result.error("操作非法");
    }

    @PostMapping("details")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody SysOrgDetailsEntity sysOrgDetailsEntity){

        /**
         * 根据时间戳生成唯一id
         *
         */
        Long orgId = OrgUtils.getIdByTime();
        sysOrgDetailsEntity.setOrgId(orgId);
        sysOrgDetailsService.save(sysOrgDetailsEntity);
        return Result.ok("新增成功");
    }


    @PutMapping("details")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgDetailsEntity sysOrgDetailsEntity){

        Boolean flag = sysOrgDetailsService.update(sysOrgDetailsEntity);
        if(flag)
        {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }



}
