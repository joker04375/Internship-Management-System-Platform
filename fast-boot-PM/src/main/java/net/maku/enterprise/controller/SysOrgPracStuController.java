package net.maku.enterprise.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import net.maku.enterprise.common.OrgConstants;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.enterprise.service.SysOrgPracStuService;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import net.maku.student.entity.SysStuResumeEntity;
import net.maku.student.service.SysStuResumeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 企业实习学生管理
 * @author: 25652
 * @time: 2022/6/15 18:13
 */


@RestController
@RequestMapping("sys/orgs/prac")
@AllArgsConstructor
public class SysOrgPracStuController {

    private final SysOrgPracStuService sysOrgPracStuService;

    private final SysStuResumeService sysStuResumeService;

    @GetMapping("stu/{id}")
    @Operation(summary = "企业某个实习中单个学生信息")
    public Result<SysOrgPracStuEntity> getOneStuDetails(@PathVariable("id") Long Id)
    {
        SysOrgPracStuEntity onePracMessage = sysOrgPracStuService.getOnePracStuMessage(Id);
        return Result.ok(onePracMessage);
    }

    @PostMapping("stu/page/{orgId}/{pracId}")
    @Operation(summary = "企业实习一个实习所有学生信息")
    public Result<PageResult<SysOrgPracStuEntity>> getAllStuDetails(
            @PathVariable("orgId") Long orgId,
            @PathVariable("pracId") Long pracId,
            @RequestBody Query query
            )
    {
        List<SysOrgPracStuEntity> list = sysOrgPracStuService.getAllPracStuMessage(orgId,pracId);
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), list);
        PageResult<SysOrgPracStuEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }


    @DeleteMapping("stu/{id}/{orgId}/{pracId}/{stuId}")
    @Operation(summary = "删除")
    public Result<String> delete(@PathVariable("id") Long Id,
                                 @PathVariable("orgId") Long orgId,
                                 @PathVariable("pracId") Long pracId,
                                 @PathVariable("stuId") Long stuId){
        Boolean flag = sysOrgPracStuService.delete(Id, orgId, pracId, stuId);
        if(flag) {
            return Result.ok("删除成功");
        }
        return Result.error("非法操作");
    }

    @PostMapping("stu")
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody @Valid SysOrgPracStuEntity sysOrgPracStuEntity){
        sysOrgPracStuService.save(sysOrgPracStuEntity);
        return Result.ok("新增成功");
    }

    @PutMapping("stu")
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid SysOrgPracStuEntity sysOrgPracStuEntity){
        Boolean flag = sysOrgPracStuService.update(sysOrgPracStuEntity);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     *获取某个企业实习中的报名中的学生
     * @param orgId
     * @param pracId
     * @return
     */
    @PostMapping("stu/page/getAllApplyStu/{orgId}/{pracId}")
    public Result<PageResult<SysOrgPracStuEntity>> getAllApplyStu(@PathVariable("orgId") Long orgId,
                                                            @PathVariable("pracId") Long pracId,
                                                            @RequestBody Query query)
    {
        List<SysOrgPracStuEntity> list = sysOrgPracStuService.getAllApplyStu(orgId, pracId);
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), list);
        PageResult<SysOrgPracStuEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

    /**
     *获取某个企业实习中正在实习的学生
     * @param orgId
     * @param pracId
     * @return
     */
    @PostMapping("stu/page/getAllWorkingStu/{orgId}/{pracId}")
    public Result<PageResult<SysOrgPracStuEntity>> getAllWorkingStu(@PathVariable("orgId") Long orgId,
                                                              @PathVariable("pracId") Long pracId,
                                                              @RequestBody Query query)
    {
        List<SysOrgPracStuEntity> list = sysOrgPracStuService.getAllWorkingStu(orgId, pracId);
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), list);
        PageResult<SysOrgPracStuEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

    /**
     *获取某个企业实习中的被淘汰学生
     * @param orgId
     * @param pracId
     * @return
     */
    @PostMapping("stu/page/getAllOutStu/{orgId}/{pracId}")
    public Result<PageResult<SysOrgPracStuEntity>> getAllOutStu(@PathVariable("orgId") Long orgId,
                                                          @PathVariable("pracId") Long pracId,
                                                          @RequestBody Query query)
    {
        List<SysOrgPracStuEntity> list = sysOrgPracStuService.getAllOutStu(orgId, pracId);
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), list);
        PageResult<SysOrgPracStuEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);
    }

    /**
     *获取某个企业实习中的简历学生
     * @param stuId
     * @return
     */
    @GetMapping("stu/getOneStuResume/{stuId}")
    public Result<SysStuResumeEntity> getOneStuResume(@PathVariable("stuId") Long stuId)
    {
        SysStuResumeEntity entity = sysStuResumeService.selectByUserId(stuId);
        return Result.ok(entity);
    }


    /**
     * 纳入笔试名单
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/adaptToWriten/{orgId}/{pracId}/{stuId}")
    public Result<String> adaptTowriten(@PathVariable("orgId")  Long orgId,
                                        @PathVariable("pracId") Long pracId,
                                        @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeInterviewTime
                (orgId, pracId, stuId, OrgConstants.STU_INTERVIEW_WRITTEN);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 纳入笔试名单 进入第一轮面试
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/adaptToFaceOne/{orgId}/{pracId}/{stuId}")
    public Result<String> adaptToFaceOne(@PathVariable("orgId")  Long orgId,
                                         @PathVariable("pracId") Long pracId,
                                         @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeInterviewTime
                (orgId, pracId, stuId,OrgConstants.STU_INTERVIEW_FACE_1);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 纳入笔试名单 进入第二轮面试
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/adaptToFaceTwo/{orgId}/{pracId}/{stuId}")
    public Result<String> adaptToFaceTwo(@PathVariable("orgId")  Long orgId,
                                         @PathVariable("pracId") Long pracId,
                                         @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeInterviewTime
                (orgId, pracId, stuId,OrgConstants.STU_INTERVIEW_FACE_2);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 纳入笔试名单 进入第三轮面试
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/adaptToFaceThree/{orgId}/{pracId}/{stuId}")
    public Result<String> adaptToFaceThree(@PathVariable("orgId")  Long orgId,
                                           @PathVariable("pracId") Long pracId,
                                           @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeInterviewTime
                (orgId, pracId, stuId,OrgConstants.STU_INTERVIEW_FACE_3);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 淘汰学生
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/outTheStu/{orgId}/{pracId}/{stuId}")
    public Result<String> outTheStu(@PathVariable("orgId")  Long orgId,
                                    @PathVariable("pracId") Long pracId,
                                    @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeStuStatus
                (orgId, pracId, stuId,OrgConstants.POST_STATUS_OUT);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 录用学生
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/passTheStu/{orgId}/{pracId}/{stuId}")
    public Result<String> passTheStu(@PathVariable("orgId")  Long orgId,
                                     @PathVariable("pracId") Long pracId,
                                     @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeStuStatus
                (orgId, pracId, stuId,OrgConstants.STU_STATUS_SUCCESS);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 学生已入职
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/theStuWorking/{orgId}/{pracId}/{stuId}")
    public Result<String> theStuWorking(@PathVariable("orgId")  Long orgId,
                                        @PathVariable("pracId") Long pracId,
                                        @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeStuStatus
                (orgId, pracId, stuId,OrgConstants.STU_STATUS_WORKING);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 学生实习已完成
     * @param orgId 企业id
     * @param pracId 实习id
     * @param stuId 学生id
     * @return
     */
    @GetMapping("stu/theStuWorkdone/{orgId}/{pracId}/{stuId}")
    public Result<String> theStuWorkdone(@PathVariable("orgId")  Long orgId,
                                         @PathVariable("pracId") Long pracId,
                                         @PathVariable("stuId") Long stuId)
    {
        Boolean flag = sysOrgPracStuService.changeStuStatus
                (orgId, pracId, stuId,OrgConstants.STU_STATUS_WORKEND);
        if(flag) {
            return Result.ok("修改成功");
        }
        return Result.error("操作非法");
    }

    /**
     * 获取参与笔试学生
     * @param orgId 企业id
     * @param pracId 实习id
     * @return
     */
    @PostMapping("stu/getAllStuByInterType/{orgId}/{pracId}/{interType}")
    public Result<PageResult<SysOrgPracStuEntity>> getAllStuByInterType(@PathVariable("orgId")  Long orgId,
                                               @PathVariable("pracId") Long pracId,
                                               @PathVariable("interType") Integer interType,
                                               @RequestBody Query query)
    {

        List<SysOrgPracStuEntity> list = sysOrgPracStuService.getAllStuByInterType(orgId, pracId, interType);
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), list);
        PageResult<SysOrgPracStuEntity> result = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(result);

    }



}
