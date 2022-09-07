package net.maku.student.controller;

import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.FileUtils;
import net.maku.framework.common.utils.Result;
import net.maku.student.entity.CollegeModelFileEntity;
import net.maku.student.service.SysStuFileService;
import net.maku.utils.UserHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("sys/stu/file")
@AllArgsConstructor
public class FileController {

    private final SysStuFileService sysStuFileService;
    @GetMapping("getModelFiles")
    public Result getModelFiles(){
        CollegeModelFileEntity modelFileEntity = sysStuFileService.selectModelFilesByStuId(UserHolder.getUser().getId());
        return Result.ok(modelFileEntity);
    }

    @PostMapping("downLoad")
    public Result downLoadFile(String path, HttpServletResponse response){
        try {
            FileUtils.downLoadFile(path,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.ok("下载成功");
    }
}
