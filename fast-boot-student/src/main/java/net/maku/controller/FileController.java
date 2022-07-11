package net.maku.controller;

import lombok.AllArgsConstructor;
import net.maku.entity.ModelFileEntity;
import net.maku.framework.common.utils.FileUtils;
import net.maku.framework.common.utils.Result;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.SysStuFileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/stu/file")
@AllArgsConstructor
public class FileController {

    private final SysStuFileService sysStuFileService;
    @GetMapping("getFiles")
    public Result getModelFiles(){
        ModelFileEntity upLoadFileEntity = sysStuFileService.selectModelFilesByStuId(SecurityUser.getUserId());
        return Result.ok(upLoadFileEntity);
    }

//    @PostMapping("")
//    public Result UpLoadFile(){
//        FileUtils.
//    }
}
