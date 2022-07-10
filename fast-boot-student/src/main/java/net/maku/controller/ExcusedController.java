package net.maku.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.entity.SysStuExcusedEntity;
import net.maku.framework.common.utils.FileUtils;
import net.maku.framework.common.utils.Result;
import net.maku.service.SysStuExcusedService;
import net.maku.service.SysYesOrNotService;
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
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedService.selectExcuseds();
        return Result.ok(sysStuExcusedEntities);
    }

    /**
     * 学院查看
     * @return
     */
    @GetMapping("college/select")
    public Result selectCollegeExcused(){
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedService.selectCollegeExcuseds();
        return Result.ok(sysStuExcusedEntities);
    }

    /**
     * 企业查看
     * @return
     */
    @GetMapping("enterprise/select")
    public Result selectEnterpriseExcused(){
        List<SysStuExcusedEntity> sysStuExcusedEntities = sysStuExcusedService.selectEnterpriseExcuseds();
        return Result.ok(sysStuExcusedEntities);
    }

    /**
     * 请假申请
     * @return
     */
    @PostMapping("stu/apply")
    public Result applyExcused(@RequestParam("file") MultipartFile file,
                               @RequestParam("excusedReason") String excusedReason,
                               @RequestParam("startTime") String startTime,
                               @RequestParam("endTime") String endTime,
                               @RequestParam("excusedDetails") String excusedDetails
                               ){
        SysStuExcusedEntity sysStuExcusedEntity = new SysStuExcusedEntity();

        //获取文件位置
        String file_addr = FileUtils.uploadCommonFile(file);

        //String转Date
        Date start_date = new Date();
        Date end_date = new Date();
        try {
             start_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
             end_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sysStuExcusedEntity.setFile(file_addr);
        sysStuExcusedEntity.setExcusedReason(excusedReason);
        sysStuExcusedEntity.setStartTime(start_date);
        sysStuExcusedEntity.setEndTime(end_date);
        sysStuExcusedEntity.setExcusedDetails(excusedDetails);

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
     * 学院企业批准/不批准请假
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
