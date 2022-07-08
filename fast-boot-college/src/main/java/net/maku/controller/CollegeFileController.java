package net.maku.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgDetailsEntity;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.SysPublicFileService;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.service.CollegeFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/sys/college/file")
@Tag(name="文件相关功能")
@AllArgsConstructor
public class CollegeFileController {
    private final CollegeFileService collegeFileService;

    private final SysPublicFileService sysPublicFileService;

    /**
     * 上传模板文件，待企业审批（审批后将passed字段设置为1）
     * */
    @PostMapping("/uploadTemplate")
    public Result<String> uploadTemplateFile(@RequestParam("orgId") int orgId,
                                             @RequestParam("pracId") int pracId,
                                             @RequestParam("file") MultipartFile file,
                                             @RequestParam("filename") String fileName) {
        String file_id = sysPublicFileService.CreatePublicFile(orgId, pracId, file);
        SysPublicFileEntity fileObj = collegeFileService.getOne(new QueryWrapper<SysPublicFileEntity>().eq("file_id", file_id));
        fileObj.setFileName(fileName);
        fileObj.setEnterprise(1);
        fileObj.setIsCommon(1);
        fileObj.setCollege(1);
        collegeFileService.updateById(fileObj);
        return Result.ok("success");
    }

    /**
     * 查看企业已上传的模板文件（根据是否通过进行排序（passed字段））
     * */
    @GetMapping("/templateFile/{orgId}/{pracId}")
    public Result<PageResult<SysPublicFileEntity>> getAllTemplateFile(@PathVariable("orgId") int orgId, @PathVariable("pracId") int pracId,@RequestBody Query query) {
        List<SysPublicFileEntity> templateFiles = collegeFileService.list(new QueryWrapper<SysPublicFileEntity>().eq("orgId", orgId).eq("pracId", pracId).eq("is_common", 1).orderByAsc("passed"));
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), templateFiles);
        PageResult<SysPublicFileEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }




}
