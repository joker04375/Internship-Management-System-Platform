package net.maku.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.entity.SysStuExcusedEntity;
import net.maku.framework.common.utils.Result;
import net.maku.service.SysStuExcusedService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("sys/stu/excused")
@Tag(name = "请假申请")
@AllArgsConstructor
public class ExcusedController {

    private final SysStuExcusedService sysStuExcusedService;

    /**
     * 请假查询
     * @return
     */
    @GetMapping("select")
    public Result selectExcused(){
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedService.selectExcuseds();
        return Result.ok(sysStuExcusedEntities);
    }

    /**
     * 请假申请
     * @return
     */
    @PostMapping("apply")
    public Result applyExcused(@RequestBody SysStuExcusedEntity sysStuExcusedEntity){
        sysStuExcusedService.applyExcused(sysStuExcusedEntity);
        return Result.ok("申请成功");
    }

    /**
     * 删除请假
     * @param id
     * @return
     */
    @DeleteMapping (value = "/delete/{id}")
    public Result deleteExcused(@PathVariable("id") Long id){
        sysStuExcusedService.deleteExcused(id);
        return Result.ok("删除成功");
    }
}
