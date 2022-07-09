package net.maku.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.entity.SysStuDetailsEntity;
import net.maku.framework.common.utils.Result;
import net.maku.framework.security.user.SecurityUser;
import net.maku.service.SysStuDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/stu")
@AllArgsConstructor
@Tag(name="我的信息管理")
public class StuController {
    private final SysStuDetailsService sysStuDetailsService;

    /**
     * 我的信息
     * @return
     */
    @GetMapping("myInfo")
    public Result getMyInfo() {
        SysStuDetailsEntity sysStuDetailsEntity = sysStuDetailsService.selectByUserId(SecurityUser.getUserId());
        return Result.ok(sysStuDetailsEntity);
    }

}
