package net.maku.enterprise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracFileEntity;
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



    @GetMapping("file/download")
    @Operation(summary = "文件下载")
    public void fileDownload(@RequestBody SysOrgPracFileEntity sysOrgPracFileEntity, HttpServletResponse response)
    {
        sysOrgPracFileService.fileDownload(response,sysOrgPracFileEntity);
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

    @GetMapping ("file/getAllFile/{orgId}/{pracId}")
    public Result<PageResult<SysOrgPracFileEntity>> getAllFile(@RequestBody Query query,
                                                               @PathVariable("orgId") Long orgId,
                                                               @PathVariable("pracId") Long pracId)
    {
        List<SysOrgPracFileEntity> allFile = sysOrgPracFileService.getAllFile(orgId, pracId);

        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allFile);
        PageResult<SysOrgPracFileEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());

        return Result.ok(result);
    }

}
