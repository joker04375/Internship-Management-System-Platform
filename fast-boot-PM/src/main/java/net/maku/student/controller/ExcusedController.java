package net.maku.student.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import net.maku.framework.common.utils.FileUtils;
import net.maku.framework.common.utils.Result;

import net.maku.student.entity.SysStuExcusedEntity;
import net.maku.student.service.SysStuExcusedService;
import net.maku.student.service.SysYesOrNotService;
import net.maku.security.utils.UserHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sys/excused")
@Tag(name = "请假申请")
@AllArgsConstructor
public class ExcusedController {

    private final SysStuExcusedService sysStuExcusedService;
    private SysYesOrNotService sysYesOrNotService;

    /**
     * 请假查询
     * @return
     */

    /**
     * 学生查看
     * @return
     */
    @GetMapping("stu/select")
    public Result selectStuExcused(){
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedService.selectExcuseds(UserHolder.getUser().getId());
        return Result.ok(sysStuExcusedEntities);
    }

    /**
     * 学院查看
     * @return
     */
    @GetMapping("college/select/{id}")
    public Result selectCollegeExcused(@PathVariable("id") Long timeId){
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedService.selectCollegeExcusedsByColIdAndTimeId(UserHolder.getUser().getOrgId(),timeId);
        return Result.ok(sysStuExcusedEntities);
    }

    /**
     * 企业查看
     * @return
     */
    @GetMapping("enterprise/select/{id}")
    public Result selectEnterpriseExcused(@PathVariable("id") Long pracId){
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedService.selectEnterpriseExcusedsByOrgIdAndPracId(UserHolder.getUser().getOrgId(),pracId);
        return Result.ok(sysStuExcusedEntities);
    }

    /**
     * 学生请假申请
     * @param file
     * @param excusedReason
     * @param startTime
     * @param endTime
     * @param excusedDetails
     * @param orgId
     * @param pracId
     * @param colId
     * @param timeId
     * @return
     */
    @PostMapping("stu/apply")
    public Result applyExcused(@RequestParam("file") MultipartFile file,
                               @RequestParam("excusedReason") String excusedReason,
                               @RequestParam("startTime") String startTime,
                               @RequestParam("endTime") String endTime,
                               @RequestParam("excusedDetails") String excusedDetails,
                               @RequestParam("orgId") Long orgId,
                               @RequestParam("pracId") Long pracId,
                               @RequestParam("colId") Long colId,
                               @RequestParam("timeId") Long timeId
    ){
        SysStuExcusedEntity sysStuExcusedEntity = new SysStuExcusedEntity();

        //获取文件位置
        String file_addr;
        if(!file.isEmpty()){
            file_addr = FileUtils.uploadCommonFile(file);
            sysStuExcusedEntity.setFileAddr(file_addr);
        }

        //String转Date
        Date start_date = new Date();
        Date end_date = new Date();
        try {
            start_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
            end_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sysStuExcusedEntity.setExcusedReason(excusedReason);
        sysStuExcusedEntity.setStartTime(start_date);
        sysStuExcusedEntity.setEndTime(end_date);
        sysStuExcusedEntity.setExcusedDetails(excusedDetails);
        sysStuExcusedEntity.setOrgId(orgId);
        sysStuExcusedEntity.setPracId(pracId);
        sysStuExcusedEntity.setColId(colId);
        sysStuExcusedEntity.setTimeId(timeId);

        //设置状态
        sysStuExcusedEntity.setStatus(0);

        sysStuExcusedService.applyExcused(sysStuExcusedEntity);

        return Result.ok("申请成功");
    }

    /**
     * 删除请假
     * @param id
     * @return
     */
    @DeleteMapping (value = "stu/delete/{id}")
    public Result deleteExcused(@PathVariable("id") Long id){
        sysStuExcusedService.deleteExcused(id);
        return Result.ok("删除成功");
    }

    /**
     * 学院企业批准/不批准请假 传入id为学生id
     */

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

    /**
     * 相差天数计算
     */
    public int differentDaysByMillisecond(Date date1, Date date2) {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }
}
