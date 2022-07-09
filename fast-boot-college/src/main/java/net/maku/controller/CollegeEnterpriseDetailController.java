package net.maku.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.enterprise.service.SysOrgDetailsService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sys/college/enterprise")
@Tag(name="企业管理")
@AllArgsConstructor
public class CollegeEnterpriseDetailController {
    private final SysOrgDetailsService sysOrgDetailsService;

    @GetMapping("home")
    @Operation(summary = "企业管理")
    public Result<PageResult<SysOrgDetailsEntity>> getAllEnterprise(Query query){
        List<SysOrgDetailsEntity> allEnterprise = sysOrgDetailsService.getAllOrgDetails();
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allEnterprise);
        PageResult<SysOrgDetailsEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("detail/{orgId}")
    @Operation(summary = "获取某个企业的详细信息")
    public Result<SysOrgDetailsEntity> getEnterpriseDetail(@PathVariable(name = "orgId") Long orgId) {
        SysOrgDetailsEntity details = sysOrgDetailsService.getDetails(orgId);
        return Result.ok(details);
    }
}
