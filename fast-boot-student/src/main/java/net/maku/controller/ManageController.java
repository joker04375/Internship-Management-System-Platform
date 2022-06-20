package net.maku.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysAllOrgPostEntity;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.entity.SysStuPostEntity;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.service.SysStuManageService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sys/stu/manage")
@AllArgsConstructor
@Tag(name = "实习管理")
public class ManageController {

    private final SysOrgPracPostService sysOrgPracPostService;
    private final SysStuManageService sysStuManageService;

    /**
     * 岗位浏览
     * @return
     */
    @RequestMapping("post")
    public Result<PageResult<SysAllOrgPostEntity>> selectAllPost(@Valid Query query){
        List<SysAllOrgPostEntity> allOrgPost = sysOrgPracPostService.getAllOrgPost();

        //进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allOrgPost);
        PageResult<SysAllOrgPostEntity> pageResult = new PageResult<SysAllOrgPostEntity>(pages.getRecords(), pages.getTotal());

        return Result.ok(pageResult);
    }

    /**
     * 实习申报
     * @return
     */
    @PostMapping("sys/stu/manage/post/apply")
    public Result applyPost(@RequestBody SysStuPostEntity sysStuPostEntity){
        sysStuManageService.save(sysStuPostEntity);

        return Result.ok();
    }
}
