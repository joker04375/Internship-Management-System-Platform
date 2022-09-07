package net.maku.college.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.college.entity.SysCollegePatternFileEntity;
import net.maku.college.service.SysCollegePatternFileService;
import net.maku.college.vo.CollegePatternFileVo;
import net.maku.enterprise.common.OrgUtils;
import net.maku.framework.common.entity.SysPublicFileEntity;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.SysPublicFileService;
import net.maku.framework.common.utils.FileUtils;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.college.service.SysCollegeFileService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sys/college/file")
@Tag(name="文件相关功能")
@AllArgsConstructor
public class CollegeFileController {
    private final SysCollegeFileService sysCollegeFileService;

    private final SysCollegePatternFileService sysCollegePatternFileService;
    
    private final SysPublicFileService sysPublicFileService;

//    @PostMapping("/uploadTemplate")
//    @Operation(summary = "上传模板文件，待企业审批（审批后将passed字段设置为1）")
//    public Result<String> uploadTemplateFile(@RequestParam("orgId") int orgId,
//                                             @RequestParam("pracId") int pracId,
//                                             @RequestParam("file") MultipartFile file,
//                                             @RequestParam("filename") String fileName) {
//        String file_id = sysPublicFileService.CreatePublicFile(orgId, pracId, file);
//        SysPublicFileEntity fileObj = sysCollegeFileService.getOne(new QueryWrapper<SysPublicFileEntity>().eq("file_id", file_id));
//        fileObj.setFileName(fileName);
//        fileObj.setEnterprise(1);
//        fileObj.setIsCommon(1);
//        fileObj.setCollege(1);
//        sysCollegeFileService.updateById(fileObj);
//        return Result.ok("success");
//    }

    @PostMapping("/uploadPattern")
    @Operation(summary = "学院下发任务")
    public Result<String> uploadTemplateFile(@ModelAttribute  CollegePatternFileVo info) {
        String fileAddr= FileUtils.uploadCommonFile(info.getFile());
        SysCollegePatternFileEntity fileObj = new SysCollegePatternFileEntity();
        fileObj.setPatternId(OrgUtils.getIdByTime());
        fileObj.setFileAddr(fileAddr);
        fileObj.setFileType(info.getFileType());
        fileObj.setCollegeId(info.getCollegeId());
        fileObj.setFileName(info.getFileName());
        fileObj.setIsCommon(info.getIsCommon());
        fileObj.setIsNeed(info.getIsNeed());
        fileObj.setTimeId(info.getTimeId());
        fileObj.setIsOrgRead(info.getIsOrgRead());
        fileObj.setIsStuRead(info.getIsStuRead());
        sysCollegePatternFileService.save(fileObj);
        return Result.ok("success");
    }

        // 还未知道这个接口还有无用
//    @GetMapping("/templateFile/{orgId}/{pracId}")
//    @Operation(summary = "查看该企业下已上传的模板文件（根据是否通过进行排序（passed字段））")
//    public Result<PageResult<SysPublicFileEntity>> getAllTemplateFile(@PathVariable("orgId") int orgId, @PathVariable("pracId") int pracId,Query query) {
//        List<SysPublicFileEntity> templateFiles = sysCollegeFileService.list(new QueryWrapper<SysPublicFileEntity>().eq("orgId", orgId).eq("pracId", pracId).eq("is_common", 1).orderByAsc("passed"));
//        // 进行分页
//        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), templateFiles);
//        PageResult<SysPublicFileEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
//        return Result.ok(page);
//    }

    @GetMapping("/aboutFiles")
    @Operation(summary = "查看某个学生在这次实习下的所有文件")
    public Result<PageResult<SysPublicFileEntity>> getAllTemplateFile(long collegeId, long timeId,Query query,long stuId) {
        List<SysPublicFileEntity> allFiles = sysPublicFileService.getAllFileByStuAndCollegeAndTimeId(stuId, collegeId, timeId);
        // 前端根据文件类型展示 文件类型（0：周报；1：简历；2：学院任务）
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allFiles);
        PageResult<SysPublicFileEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("/downloadStuFile")
    @Operation(summary = "下载学生的某个文件")
    public Result<String> downloadStuFile(String fileAddr, HttpServletResponse httpServletResponse) {
        try {
            FileUtils.downLoadFile(fileAddr, httpServletResponse);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("failed");
        }
        return Result.ok("success");
    }
}
