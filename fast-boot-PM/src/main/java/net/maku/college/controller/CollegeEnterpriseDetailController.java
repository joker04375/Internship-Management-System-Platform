package net.maku.college.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.enterprise.entity.SysOrgPracManageEntity;
import net.maku.enterprise.service.SysOrgDetailsService;
import net.maku.enterprise.service.SysOrgPracManageService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/sys/college/enterprise")
@Tag(name="企业管理")
@AllArgsConstructor
public class CollegeEnterpriseDetailController {
    private final SysOrgPracManageService sysOrgPracManageService;

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

    @GetMapping("search")
    @Operation(summary = "搜索功能（根据公司名）")
    public Result<PageResult<SysOrgDetailsEntity>> getEnterpriseByName(Query query, @RequestParam("query") String name) {
        List<SysOrgDetailsEntity> allEnterprise = sysOrgDetailsService.getByQuery(name);
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allEnterprise);
        PageResult<SysOrgDetailsEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("detail/home/{orgId}")
    @Operation(summary = "获取某个公司下的所有实习（按照时间排序）")
    public Result<PageResult<SysOrgPracManageEntity>> getPracByOrgId(Query query, @PathVariable("orgId") long orgId) {
        List<SysOrgPracManageEntity> allPracMessage = sysOrgPracManageService.getAllPracMessage(orgId);
        allPracMessage.sort(Comparator.comparing(SysOrgPracManageEntity::getCreateTime));
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allPracMessage);
        PageResult<SysOrgPracManageEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }


}
