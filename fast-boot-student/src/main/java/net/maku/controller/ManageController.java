package net.maku.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import net.maku.entity.SysOrgPracStuEntity;
import net.maku.entity.SysStuPracEntity;
import net.maku.framework.common.utils.Result;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.SysStuManageService;
import net.maku.service.SysStuPracService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("sys/stu/manage")
@AllArgsConstructor
@Tag(name = "我的实习管理")
public class ManageController {
    private final SysStuManageService sysStuManageService;
    private final SysStuPracService sysStuPracService;

    /**
     * 实习申报
     * @return
     */
    @PostMapping("post/apply")
    public Result applyPost(@RequestBody SysOrgPracStuEntity sysOrgPracStuEntity) {
        sysStuManageService.save(sysOrgPracStuEntity);
        return Result.ok();
    }


    /**
     * 我的实习
     * @return
     */
    @GetMapping("myPracInfo")
    public Result getMyPracInfo() {
        List<SysStuPracEntity> sysStuPracEntities= sysStuPracService.getMyPracByUserId(SecurityUser.getUserId());
        return Result.ok(sysStuPracEntities);
    }

    @PostMapping()
    public Result postMonthReport(){
        return Result.ok();
    }
}
