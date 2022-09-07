package net.maku.enterprise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.college.entity.SysCollegePatternFileEntity;
import net.maku.college.service.SysCollegePatternFileService;
import net.maku.enterprise.entity.SysOrgCollegePracEntity;
import net.maku.enterprise.entity.SysOrgPracFileEntity;
import net.maku.enterprise.service.SysOrgCollegePracService;
import net.maku.enterprise.service.SysOrgPracFileService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:企业实习文件管理
 * @author: 25652
 * @time: 2022/6/17 9:22
 */


@RestController
@RequestMapping("sys/orgs/prac")
@AllArgsConstructor
public class SysOrgPracFileController {

    private SysOrgPracFileService sysOrgPracFileService;

    private SysOrgCollegePracService sysOrgCollegePracService;

    private SysCollegePatternFileService sysCollegePatternFileService;

    @GetMapping("file/download")
    @Operation(summary = "文件下载")
    public Result<String> fileDownload(String fileUrl, HttpServletResponse response)
    {
        Boolean flag = sysOrgPracFileService.fileDownload(fileUrl, response);
        if(flag){
            return Result.ok("操作成功");
        }
        return Result.error("操作失败");
    }

    @GetMapping("file/getCommonFile/{orgId}/{pracId}")
    @Operation(summary = "获取公司可见的文件")
    public Result<List<SysCollegePatternFileEntity>> getCommonFile(@PathVariable("orgId") Long orgId,@PathVariable("pracId") Long pracId)
    {
        SysOrgCollegePracEntity entity = sysOrgCollegePracService.selectCollegeIdAndTimeIDByOrgIdAndPracId(orgId, pracId);
        List<SysCollegePatternFileEntity> list = sysCollegePatternFileService.getAllOrgFile(entity.getCollegeId(), entity.getTimeId());
        return Result.ok(list);
    }

    @PostMapping("file/upload")
    @Operation(summary = "文件上传")
    public Result<String> fileUpload(@RequestParam("file") MultipartFile upLoadFile,
                                     @RequestParam("fileName") String fileName,
                                     @RequestParam("uploder") String uploder,
                                     @RequestParam("fileType") String fileType,
                                     @RequestParam("orgId") Long orgId,
                                     @RequestParam("pracId") Long pracId)
    {
        sysOrgPracFileService.fileUpload(upLoadFile,fileName,uploder,fileType,orgId,pracId);
        return Result.ok("上传成功");
    }


}
