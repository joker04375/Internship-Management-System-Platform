package net.maku.enterprise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.enterprise.service.SysOrgPracStuService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 企业实习学生管理
 * @author: 25652
 * @time: 2022/6/15 18:13
 */


@RestController
@RequestMapping("sys/orgs/prac")
@AllArgsConstructor
public class SysOrgPracStuController {

    public  final SysOrgPracStuService sysOrgPracStuService;

    @GetMapping("stu/{id}")
    @Operation(summary = "企业某个实习中单个学生信息")
    public Result<SysOrgPracStuEntity> getOneStuDetails(@PathVariable("id") Long Id)
    {
        SysOrgPracStuEntity onePracMessage = sysOrgPracStuService.getOnePracStuMessage(Id);
        return Result.ok(onePracMessage);
    }

    @GetMapping("stu/{orgId}/{pracId}")
    @Operation(summary = "企业实习一个实习所有学生信息")
    public Result<PageResult<SysOrgPracStuEntity>> getAllStuDetails(
            @PathVariable("orgId") Long orgId,
            @PathVariable("pracId") Long pracId,
            @RequestBody Query query
            )
    {
        List<SysOrgPracStuEntity> list = sysOrgPracStuService.getAllPracStuMessage(orgId,pracId);

        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), list);
        PageResult<SysOrgPracStuEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }


    @DeleteMapping("stu/{id}")
    @Operation(summary = "删除")
    public Result<String> delete
            (@PathVariable("stuId") Long Id){
        sysOrgPracStuService.delete(Id);
        return Result.ok("删除成功");
    }

    @PostMapping("stu")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysOrgPracStuEntity sysOrgPracStuEntity){
        sysOrgPracStuService.save(sysOrgPracStuEntity);
        return Result.ok("新增成功");
    }

    @PutMapping("stu")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgPracStuEntity sysOrgPracStuEntity){
        sysOrgPracStuService.update(sysOrgPracStuEntity);
        return Result.ok("修改成功");
    }


    /**
     * 纳入笔试名单或者淘汰
     * @param sysOrgPracStuEntity 学生管理实体类
     * @return
     */
    @PostMapping("stu/changeStuStatus/{changeStatus}")
    public Result<String> changeStuStatus(@PathVariable("changeStatus") Long changeStatus,
                                          @RequestBody @Valid SysOrgPracStuEntity sysOrgPracStuEntity)
    {
        sysOrgPracStuEntity.setStatus(changeStatus);
        sysOrgPracStuService.update(sysOrgPracStuEntity);
        return Result.ok("操作成功");
    }


    @GetMapping("stu/getAllAccessStu/{orgId}/{pracId}")
    public Result<List<SysOrgPracStuEntity>> getAllAccessOrTestStu(@PathVariable("orgId") Long orgId,
                                                     @PathVariable("pracId") Long pracId)
    {
        List<SysOrgPracStuEntity> allAccessOrTestStu = sysOrgPracStuService.getAllAccessOrTestStu(orgId, pracId);
        return Result.ok(allAccessOrTestStu);
    }

}
