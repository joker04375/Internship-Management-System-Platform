package net.maku.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.entity.interation.SysAllOrgPracEntity;
import net.maku.enterprise.service.SysOrgPracManageService;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sys/college/prac")
@Tag(name="实习管理")
@AllArgsConstructor
public class CollegePracMangerController {

    private final SysOrgPracManageService sysOrgPracManageService;

    private final SysOrgPracPostService sysOrgPracPostService;

    @GetMapping("home")
    public Result<PageResult<SysAllOrgPracEntity>> getAllPracsByStatus(@Valid Query query) {
        List<SysAllOrgPracEntity> allPrac = sysOrgPracManageService.getAllPrac();
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allPrac);
        PageResult<SysAllOrgPracEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("/post/{orgId}/{pracId}")
    public Result<List<SysOrgPracPostEntity>> getAllPostByOrgId(@PathVariable(name = "orgId") long orgId, @PathVariable(name = "pracId") long pracId) {
        List<SysOrgPracPostEntity> allPracPostMessage = sysOrgPracPostService.getAllPracPostMessage(orgId, pracId);
        return Result.ok(allPracPostMessage);
    }

//    @PutMapping("post/status/{id}/{status}")
//    public Result<String> isAcceptPost(@PathVariable(name = "id") int id, @PathVariable(name = "status") int status){
//
//    }
}
