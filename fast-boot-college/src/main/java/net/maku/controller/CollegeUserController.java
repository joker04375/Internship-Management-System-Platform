package net.maku.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.service.CollegeUserService;
import net.maku.vo.CollegeUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sys/collegeUser")
@Tag(name="学院用户管理")

public class CollegeUserController {
    private CollegeUserService collegeUserService;


    @GetMapping("/allUser")
    @Operation(summary = "用户管理（针对于教师和学生）")
    public Result<PageResult<CollegeUserVo>> getAllUser(@Valid Query query) {
        // 数据库中查询得到之后再用MapStruct转化为输出对象
        List<CollegeUserVo> users = collegeUserService.getAllUserByRole();
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), users);
        PageResult<CollegeUserVo> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

}
