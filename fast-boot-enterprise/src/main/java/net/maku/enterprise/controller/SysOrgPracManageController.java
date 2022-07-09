package net.maku.enterprise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.service.SysOrgPracManageService;
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


    @GetMapping("page/{orgId}")
    @Operation(summary = "分页")
    public Result<PageResult<SysOrgPracManageEntity>> page(@Valid Query query,@PathVariable("orgId") Long orgId){
        List<SysOrgPracManageEntity> allPracMessage = sysOrgPracManageService.getAllPracMessage(orgId);
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allPracMessage);
        PageResult<SysOrgPracManageEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

    @GetMapping("manage/{id}")
    @Operation(summary = "企业实习信息")
    public Result<SysOrgPracManageEntity> getOneOrgPracDetail(@PathVariable("id") Long Id)
    {
        SysOrgPracManageEntity onePracMessage = sysOrgPracManageService.getOnePracMessage(Id);
        return Result.ok(onePracMessage);
    }

    @GetMapping("manage/{orgId}")
    @Operation(summary = "企业实习信息")
    public Result<List<SysOrgPracManageEntity>> getAllOrgPracDetails(@PathVariable Long orgId)
    {
        List<SysOrgPracManageEntity> list = sysOrgPracManageService.getAllPracMessage(orgId);
        return Result.ok(list);
    }


    @DeleteMapping("manage/{id}")
    @Operation(summary = "删除")
    public Result<String> delete(@PathVariable("id") Long Id){
        sysOrgPracManageService.delete(Id);
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
