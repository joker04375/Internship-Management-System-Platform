package net.maku.controller;

import lombok.AllArgsConstructor;
import net.maku.entity.SysStuExcusedEntity;
import net.maku.framework.common.utils.Result;
import net.maku.service.SysYesOrNotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sys/yn")
@AllArgsConstructor
public class YesOrNotController {
    private SysYesOrNotService sysYesOrNotService;

    @PutMapping("college/pass/{id}")
    private Result ColPassExcused(@PathVariable("id") Long id){
        sysYesOrNotService.ColPassExcused(id);
        return Result.ok("学院批准");
    }

    @PutMapping("college/unpass/{id}")
    private Result ColUnPassExcused(@PathVariable("id") Long id){
        sysYesOrNotService.ColUnPassExcused(id);
        return Result.ok("学院不批准");
    }

    @PutMapping("enterprise/pass/{id}")
    private Result EntPassExcused(@PathVariable("id") Long id){
        sysYesOrNotService.EntPassExcused(id);
        return Result.ok("企业批准");
    }

    @PutMapping("enterprise/unpass/{id}")
    private Result EntUnPassExcused(@PathVariable("id") Long id){
        sysYesOrNotService.EntUnPassExcused(id);
        return Result.ok("企业不批准");
    }
}
