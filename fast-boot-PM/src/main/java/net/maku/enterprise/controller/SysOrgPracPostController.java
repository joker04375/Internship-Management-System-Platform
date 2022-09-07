package net.maku.enterprise.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.common.OrgConstants;
import net.maku.enterprise.common.OrgUtils;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.dto.SysAllOrgPostDto;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.enterprise.vo.ConditionQuery;
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

    @PostMapping("post/page/{orgId}/{pracId}")
    @Operation(summary = "企业某个实习所有岗位信息")
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


    @DeleteMapping("post/{id}/{orgId}/{pracId}/{postId}")
    @Operation(summary = "删除")
    public Result<String> delete(@PathVariable("id") Long Id,
                                 @PathVariable("orgId") Long orgId,
                                 @PathVariable("pracId") Long pracId,
                                 @PathVariable("postId") Long postId){
        Boolean flag = sysOrgPracPostService.delete(Id, orgId, pracId, postId);
        if(flag) {
            return Result.ok("删除成功");
        }
        return Result.error("操作非法");
    }

    @PostMapping("post")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody  SysOrgPracPostEntity sysOrgPracPostEntity){

        /**
         * 根据时间戳生成唯一id
         *
         */
        Long postId = OrgUtils.getIdByTime();

        sysOrgPracPostEntity.setPostId(postId);
        sysOrgPracPostEntity.setStatus(OrgConstants.POST_STATUS_WAIT);
        sysOrgPracPostService.save(sysOrgPracPostEntity);
        return Result.ok("新增成功");
    }

    @PutMapping("post")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgPracPostEntity sysOrgPracPostEntity){
        sysOrgPracPostEntity.setStatus(OrgConstants.POST_STATUS_WAIT);
        Boolean flag = sysOrgPracPostService.update(sysOrgPracPostEntity);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }



    @PostMapping("post/all")
    @Operation(summary = "所有企业的所有岗位信息")
    public Result<PageResult<SysAllOrgPostDto>> getAllPost(@RequestBody Query query)
    {
        List<SysAllOrgPostDto> allOrgPost = sysOrgPracPostService.getAllOrgPost();
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allOrgPost);
        PageResult<SysAllOrgPostDto> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

    @PostMapping("post/condition")
    @Operation(summary = "模糊查询岗位信息")
    public Result<PageResult<SysOrgPracPostEntity>> queryConditonal(@RequestBody ConditionQuery query)
    {
        List<SysOrgPracPostEntity> post = sysOrgPracPostService.getConditionPost(query.getCondition());
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), post);
        PageResult<SysOrgPracPostEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

}
