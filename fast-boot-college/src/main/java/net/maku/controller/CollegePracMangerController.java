package net.maku.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.entity.OrgPracManageEntity;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.service.CollegePracService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sys/college/prac")
@Tag(name="实习管理")
@AllArgsConstructor
public class CollegePracMangerController {

    private final CollegePracService collegePracService;

    @GetMapping("home")
    public Result<PageResult<OrgPracManageEntity>> getAllPracsByStatus(@Valid Query query) {
        List<OrgPracManageEntity> allPrac = collegePracService.getAllPrac();
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allPrac);
        PageResult<OrgPracManageEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }
}
