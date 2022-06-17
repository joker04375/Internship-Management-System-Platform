package net.maku.enterprise.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description:企业实习岗位管理
 * @author: 25652
 * @time: 2022/6/15 18:13
 */


@RestController
@RequestMapping("sys/orgs/prac")
@AllArgsConstructor
public class SysOrgPracPostController {

    private final SysOrgPracPostService sysOrgPracPostService;


    @GetMapping("post/{orgId}/{pracId}/{postId}")
    @Operation(summary = "企业实习岗位单个信息")
    public Result<SysOrgPracPostEntity> getOrgDetails
            (@PathVariable("orgId") Long orgId,
             @PathVariable("pracId") Long pracId ,
             @PathVariable("postId") Long postId)
    {
        SysOrgPracPostEntity onePracMessage = sysOrgPracPostService.getOnePracPostMessage(orgId, pracId,postId);
        return Result.ok(onePracMessage);
    }

    @GetMapping("post/{orgId}/{pracId}")
    @Operation(summary = "企业实习岗位所有信息")
    public Result<List<SysOrgPracPostEntity>> getOrgDetails(
            @PathVariable("orgId") Long orgId,
            @PathVariable("pracId") Long pracId)
    {
        List<SysOrgPracPostEntity> list = sysOrgPracPostService.getAllPracPostMessage(orgId,pracId);
        return Result.ok(list);
    }


    @DeleteMapping("post/{orgId}/{pracId}/{postId}")
    @Operation(summary = "删除")
    public Result<String> delete
            (@PathVariable("orgId") Long orgId,
             @PathVariable("pracId") Long pracId,
             @PathVariable("postId") Long postId){
        sysOrgPracPostService.delete(orgId,pracId,postId);
        return Result.ok("删除成功");
    }

    @PostMapping("post")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysOrgPracPostEntity sysOrgPracPostEntity){
        sysOrgPracPostService.save(sysOrgPracPostEntity);
        return Result.ok("新增成功");
    }

    @PutMapping("post")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgPracPostEntity sysOrgPracPostEntity){
        sysOrgPracPostService.update(sysOrgPracPostEntity);
        return Result.ok("修改成功");
    }
}
