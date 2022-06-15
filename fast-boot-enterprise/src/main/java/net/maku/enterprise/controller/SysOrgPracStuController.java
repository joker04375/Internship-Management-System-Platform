package net.maku.enterprise.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.enterprise.service.SysOrgPracStuService;
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

    @GetMapping("stu/{orgId}/{pracId}/{postId}/{stuId}")
    @Operation(summary = "企业实习岗位单个信息")
    public Result<SysOrgPracStuEntity> getOrgDetails
            (@PathVariable("orgId") Long orgId,
             @PathVariable("pracId") Long pracId ,
             @PathVariable("postId") Long postId,
             @PathVariable("stuId") Long stuId)
    {
        SysOrgPracStuEntity onePracMessage = sysOrgPracStuService.getOnePracStuMessage(orgId, pracId,postId,stuId);
        return Result.ok(onePracMessage);
    }

    @GetMapping("stu/{orgId}/{pracId}")
    @Operation(summary = "企业实习岗位所有信息")
    public Result<List<SysOrgPracStuEntity>> getOrgDetails(
            @PathVariable("orgId") Long orgId,
            @PathVariable("pracId") Long pracId,
            @PathVariable("postId") Long postId)
    {
        List<SysOrgPracStuEntity> list = sysOrgPracStuService.getAllPracStuMessage(orgId,pracId,postId);
        return Result.ok(list);
    }


    @DeleteMapping("stu/{orgId}/{pracId}/{postId}")
    @Operation(summary = "删除")
    public Result<String> delete
            (@PathVariable("orgId") Long orgId,
             @PathVariable("pracId") Long pracId,
             @PathVariable("postId") Long postId,
             @PathVariable("stuId") Long stuId){
        sysOrgPracStuService.delete(orgId,pracId,postId,stuId);
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
}
