package net.maku.enterprise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracInterviewEntity;
import net.maku.enterprise.service.SysOrgPracInterviewService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @description:
 * @author: 25652
 * @time: 2022/6/18 10:50
 */

@Controller
@RequestMapping("sys/orgs/prac")
@AllArgsConstructor
public class SysOrgPracInterviewController {

    private SysOrgPracInterviewService sysOrgPracInterviewService;

    @GetMapping("interview/{orgId}/{pracId}")
    @Operation(summary = "企业实习笔试面试信息")
    public Result<PageResult<SysOrgPracInterviewEntity>> getAllInterviews(
            @PathVariable("orgId") Long orgId,
            @PathVariable("pracId") Long pracId,
            @RequestBody Query query)
    {
        List<SysOrgPracInterviewEntity> allInterviews = sysOrgPracInterviewService.getAllInterviews(orgId, pracId);

        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allInterviews);
        PageResult<SysOrgPracInterviewEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

    @PostMapping("interview")
    @Operation(summary = "新增企业实习笔试面试信息")
    public Result<String> saveInterviews(@PathVariable SysOrgPracInterviewEntity sysOrgPracInterviewEntity)
    {
        sysOrgPracInterviewService.save(sysOrgPracInterviewEntity);
        return Result.ok("新增成功");
    }

    @PutMapping("interview")
    @Operation(summary = "修改企业实习笔试面试信息")
    public Result<String> changeInterviews(@PathVariable SysOrgPracInterviewEntity sysOrgPracInterviewEntity)
    {
            sysOrgPracInterviewService.update(sysOrgPracInterviewEntity);
            return Result.ok("修改成功");
    }


    @DeleteMapping("interview/{id}")
    @Operation(summary = "删除企业实习笔试面试信息")
    public Result<String> deleteInterviews(@PathVariable("id") Long Id)
    {
        sysOrgPracInterviewService.delete(Id);
        return Result.ok("删除成功");
    }


}
