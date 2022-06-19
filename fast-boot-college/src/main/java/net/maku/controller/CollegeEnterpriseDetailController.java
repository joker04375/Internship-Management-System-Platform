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
import net.maku.service.EnterpriseMangerService;
import net.maku.vo.EnterpriseResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sys/college/enterprise")
@Tag(name="企业管理")
@AllArgsConstructor
public class CollegeEnterpriseDetailController {
    private final EnterpriseMangerService enterpriseMangerService;

    private final SysOrgDetailsService sysOrgDetailsService;

    @GetMapping("home")
    @Operation(summary = "企业管理")
    public Result<PageResult<SysOrgDetailsEntity>> getAllEnterprise(@Valid Query query){
        List<SysOrgDetailsEntity> allEnterprise = enterpriseMangerService.getAllEnterprise();
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allEnterprise);
        PageResult<SysOrgDetailsEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("detail/{orgId}")
    public Result<SysOrgDetailsEntity> getEnterpriseDetail(@PathVariable(name = "orgId") Long orgId) {
        SysOrgDetailsEntity details = sysOrgDetailsService.getDetails(orgId);
        return Result.ok(details);
    }

}