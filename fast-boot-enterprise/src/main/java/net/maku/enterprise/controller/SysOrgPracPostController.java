package net.maku.enterprise.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
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


    @GetMapping("post/{id}")
    @Operation(summary = "企业单个实习岗位信息")
    public Result<SysOrgPracPostEntity> getOnePostDetails
            (@PathVariable("id") Long Id)
    {
        SysOrgPracPostEntity onePracMessage = sysOrgPracPostService.getOnePracPostMessage(Id);
        return Result.ok(onePracMessage);
    }

    @GetMapping("post/{orgId}/{pracId}")
    @Operation(summary = "企业所有实习岗位信息")
    public Result<PageResult<SysOrgPracPostEntity>> getOrgDetails(
            @PathVariable("orgId") Long orgId,
            @PathVariable("pracId") Long pracId,
            @RequestBody Query query)
    {
        List<SysOrgPracPostEntity> list = sysOrgPracPostService.getAllPracPostMessage(orgId,pracId);

        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), list);
        PageResult<SysOrgPracPostEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());

        return Result.ok(result);
    }


    @DeleteMapping("post/{id}")
    @Operation(summary = "删除")
    public Result<String> delete
            (@PathVariable("id") Long Id){
        sysOrgPracPostService.delete(Id);
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


    //测试的代码
    /*@GetMapping("post/all")
    public Result<List<SysAllOrgPostEntity>> test()
    {
        List<SysAllOrgPostEntity> allOrgPost = sysOrgPracPostService.getAllOrgPost();
        return Result.ok(allOrgPost);
    }*/



}
