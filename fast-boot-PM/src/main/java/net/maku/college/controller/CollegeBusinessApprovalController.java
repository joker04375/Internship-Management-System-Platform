package net.maku.college.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.Result;
import net.maku.student.entity.SysStuExcusedEntity;
import net.maku.student.service.SysStuExcusedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/college/business")
@Tag(name="业务审批")
@AllArgsConstructor
public class CollegeBusinessApprovalController {
    private final SysStuExcusedService sysStuExcusedService;

//    private final SysStuWeeklyService sysStuWeeklyService;

    /*@GetMapping("/excused")
    @Operation(summary = "学院查看当前需要审批的请假表（通过判断status是否为1来进行）")
    public Result<List<SysStuExcusedEntity>> getAllExcused(long collegeId){
        List<SysStuExcusedEntity> stuExcused = sysStuExcusedService.selectExcusedByCollege(collegeId);
        return Result.ok(stuExcused);
    }*/

    @PutMapping("/excused")
    @Operation(summary = "学院进行审批，前端传回-1代表不通过，2代表通过")
    public Result<String> dealExcused(@RequestParam("id") long id, @RequestParam("status") int status) {
        boolean b = sysStuExcusedService.update(null, new UpdateWrapper<SysStuExcusedEntity>().eq("id", id).set("status", status));
        if (b){
            return Result.ok("success");
        }
        return Result.error("failed");
    }

//    @GetMapping("/report")
//    @Operation(summary = "学院查看当前需要审批的周报表（通过判断status是否为1来进行）")
//    public Result<List<SysStuWeeklyEntity>> getAllWeekly(long collegeId){
//        // 通过查询当前周报状态（是否为审核状态）进行查询
//        List<SysStuExcusedEntity> stuWeekly = sysStuWeeklyService.selectWeeklyByCollege(collegeId);
//        return Result.ok(stuWeekly);
//    }
//
//    @PutMapping("/report")
//    @Operation(summary = "学院进行审批，前端传回-1代表不通过，1代表通过")
//    public Result<String> dealWeekly(@RequestParam("id") long id, @RequestParam("status") int status) {
//        boolean b = sysStuWeeklyService.update(null, new UpdateWrapper<SysStuWeeklyEntity>().eq("id", id).set("status", status));
//        if (b){
//            return Result.ok("success");
//        }
//        return Result.error("failed");
//    }

}
