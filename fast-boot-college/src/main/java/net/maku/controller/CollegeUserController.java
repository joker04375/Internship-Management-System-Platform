package net.maku.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.service.CollegeUserService;
import net.maku.vo.CollegeUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sys/college/user")
@Tag(name="学院用户管理")
@AllArgsConstructor
public class CollegeUserController {
    private final CollegeUserService collegeUserService;


    @GetMapping("/info/{roleName}")
    @Operation(summary = "用户管理（针对不同角色）")
    public Result<PageResult<CollegeUserVo>> getAllStudents(@Valid Query query, @PathVariable String roleName) {
        // 数据库中查询得到之后再用MapStruct转化为输出对象
        List<CollegeUserVo> students = collegeUserService.getAllUserByRole(roleName);
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), students);
        PageResult<CollegeUserVo> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

}
