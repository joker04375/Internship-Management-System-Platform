package net.maku.college.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.SysPublicFileService;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.college.service.SysCollegeUserService;
import net.maku.system.entity.SysUserEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("sys/college/user")
@Tag(name="学院用户管理")
@AllArgsConstructor
public class CollegeUserController {
    private final SysCollegeUserService sysCollegeUserService;

    @GetMapping("/info/{collegeId}/{roleName}")
    @Operation(summary = "用户管理（针对不同角色以及不同学院）")
    public Result<PageResult<SysUserEntity>> getAllStudents(Query query,@PathVariable(name = "collegeId") long collegeId, @PathVariable(name = "roleName") String roleName) {
        List<SysUserEntity> students = sysCollegeUserService.getAllUserByRoleAndOrg(roleName,collegeId);
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), students);
        PageResult<SysUserEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

//    @GetMapping("/upload")
//    public void UploadFile(@RequestParam("file") MultipartFile file){
//        int orgId = 1;
//        int pracId = 1;
//        String path = sysPublicFileService.CreatePublicFile(orgId, pracId, file);
//        System.out.println(path);
//    }
}

