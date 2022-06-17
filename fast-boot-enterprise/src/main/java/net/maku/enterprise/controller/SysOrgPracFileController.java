package net.maku.enterprise.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.service.SysOrgPracFileService;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
    public void fileDownload(HttpServletResponse response)
    {
        String downLoadUrl=".";
        sysOrgPracFileService.fileDownload(response,downLoadUrl);
    }

    @GetMapping("file/upload")
    @Operation(summary = "文件上传")
    public Result<String> fileUpload(@RequestBody MultipartFile upLoadFile)
    {
        sysOrgPracFileService.fileUpload(upLoadFile);
        return Result.ok("上传成功");
    }


}
