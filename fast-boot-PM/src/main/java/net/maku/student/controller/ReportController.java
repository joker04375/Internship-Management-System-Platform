package net.maku.student.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.FileUtils;
import net.maku.framework.common.utils.Result;
import net.maku.student.entity.SysStuReportEntity;
import net.maku.security.utils.UserHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("sys/stu/report")
@Tag(name = "我的周报申请")
@AllArgsConstructor
public class ReportController {


    @PostMapping("/upLoad")
    public Result upLoadFile(@RequestParam("file") MultipartFile upLoadFile,
                             @RequestParam("fileName") String fileName,
                             @RequestParam("collegeId") Long collegeId,
                             @RequestParam("timeId") Long timeId,
                             @RequestParam("weeks") Integer weeks){
        String fileAddr = FileUtils.uploadCommonFile(upLoadFile);

        SysStuReportEntity sysStuReportEntity = new SysStuReportEntity();
        sysStuReportEntity.setStuId(UserHolder.getUser().getId());
        sysStuReportEntity.setFileAddr(fileAddr);
        sysStuReportEntity.setCollegeId(collegeId);
        sysStuReportEntity.setTimeId(timeId);
        sysStuReportEntity.setWeeks(weeks);


        return Result.ok("上传成功");
    }
}
