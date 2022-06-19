package net.maku.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.service.SysOrgPracPostService;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/stu/manage")
@AllArgsConstructor
@Tag(name = "实习管理")
public class ManageController {
    @RequestMapping("post")
    public Result selectPost(){
        return Result.ok();
    }


}
