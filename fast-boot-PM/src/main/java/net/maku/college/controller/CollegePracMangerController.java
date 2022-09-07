package net.maku.college.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.dto.SysStuPracDetailDto;
import net.maku.college.entity.SysCollegePracEntity;
import net.maku.college.service.SysCollegePracService;
import net.maku.enterprise.dto.SysAllOrgPracDto;
import net.maku.enterprise.entity.*;
import net.maku.enterprise.service.*;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/college/prac")
@Tag(name="实习管理")
@AllArgsConstructor
public class CollegePracMangerController {

    private final SysOrgPracManageService sysOrgPracManageService;

    private final SysOrgPracPostService sysOrgPracPostService;

    private final SysOrgPracStuService sysOrgPracStuService;

    private final SysOrgPracInterviewService sysOrgPracInterviewService;

    private final SysOrgCollegePracService sysOrgCollegePracService;

    private final SysCollegePracService sysCollegePracService;

    @GetMapping("specificTimePracs")
    @Operation(summary = "查看某一学院某一批次下所有实习项目")
        public Result<PageResult<SysAllOrgPracDto>> getAllPracsByCollegeAndTime(Query query, long collegeId, long timeId) {
        // 中间表通过CollegeId和TimeId查询到这一学院这一批次下的所有实习id
        List<SysOrgCollegePracEntity> pracsInfo = sysOrgCollegePracService.selectOrgByCollegeIdAndTimeID(collegeId, timeId);
        List<SysAllOrgPracDto> result = new ArrayList<>();
        for (SysOrgCollegePracEntity info : pracsInfo) {
            result.add(sysOrgPracManageService.getByOrgAndPracId(info.getOrgId(),info.getOrgPracId()));
        }
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), result);
        PageResult<SysAllOrgPracDto> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("specificTimeStus")
    @Operation(summary = "查看某一学院某一批次下所有实习学生")
    public Result<PageResult<SysStuPracDetailDto>> getAllStusByCollegeAndTime(Query query,long collegeId,long timeId) {
        // 中间表通过CollegeId和TimeId查询到这一学院这一批次下的所有实习id以及对应的学院id
        List<SysOrgCollegePracEntity> pracsInfo = sysOrgCollegePracService.selectOrgByCollegeIdAndTimeID(collegeId,timeId);
        List<SysStuPracDetailDto> result = new ArrayList<>();
        for (SysOrgCollegePracEntity info : pracsInfo) {
            List<SysStuPracDetailDto> infos = sysOrgPracStuService.getAllStuPracByOrgAndPracId(info.getOrgId(), info.getOrgPracId());
            if(infos != null) {
                result.addAll(infos);
            }
        }
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), result);
        PageResult<SysStuPracDetailDto> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    /*
     * Prams:
     *   year:年份
     *   name:公司名称
     *   query:查询语句（根据实习名称查询）
     * */
//    @GetMapping("search")
//    @Operation(summary = "实习批次页面下根据条件进行查询")
//    public Result<PageResult<SysAllOrgPracDto>> getPracsByConditions(Query query,@RequestParam(required = false) Map<String,String> conditions) {
//        List<SysAllOrgPracDto> pracs = sysOrgPracManageService.getPracsByConditions(conditions);
//        // 进行分页
//        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), pracs);
//        PageResult<SysAllOrgPracDto> page = new PageResult<>(pages.getRecords(), pages.getTotal());
//        return Result.ok(page);
//    }

    /*
     * Prams:
     *   collegeId:学院id (一定要传)
     *   timeId:实习批次id (一定要传)
     *   query:查询语句（根据实习名称查询）
     * */
    @GetMapping("searchPrac")
        @Operation(summary = "实习批次页面下根据条件进行查询")
    public Result<PageResult<SysAllOrgPracDto>> getPracsByConditions(Query query,@RequestParam(required = false) Map<String,String> conditions) {
        List<SysOrgCollegePracEntity> pracsInfo = sysOrgCollegePracService.selectOrgByCollegeIdAndTimeID(Long.parseLong(conditions.get("collegeId")),Long.parseLong(conditions.get("timeId")));
        List<SysAllOrgPracDto> result = new ArrayList<>();
        for (SysOrgCollegePracEntity pracEntity : pracsInfo) {
            conditions.put("orgId",String.valueOf(pracEntity.getOrgId()));
            conditions.put("pracId",String.valueOf(pracEntity.getOrgPracId()));
            List<SysAllOrgPracDto> pracs = sysOrgPracManageService.search(conditions);
            result.addAll(pracs);
        }
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), result);
        PageResult<SysAllOrgPracDto> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    /*
     * Prams:
     *   collegeId:学院id (一定要传)
     *   timeId:实习批次id (一定要传)
     *   stuId:学号（模糊）
     *   stuName:名字（模糊）
     * */
    @GetMapping("searchStu")
    @Operation(summary = "实习批次全体学生管理页面下根据条件进行查询")
    public Result<PageResult<SysOrgPracStuEntity>> getStusByConditions(Query query,@RequestParam(required = false) Map<String,String> conditions) {
        List<SysOrgCollegePracEntity> pracsInfo = sysOrgCollegePracService.selectOrgByCollegeIdAndTimeID(Long.parseLong(conditions.get("collegeId")),Long.parseLong(conditions.get("timeId")));
        List<SysOrgPracStuEntity> result = new ArrayList<>();
        for (SysOrgCollegePracEntity pracEntity : pracsInfo) {
            conditions.put("orgId",String.valueOf(pracEntity.getOrgId()));
            conditions.put("pracId",String.valueOf(pracEntity.getOrgPracId()));
            List<SysOrgPracStuEntity> stus = sysOrgPracStuService.getStusByConditions(conditions);
            if(stus != null) {
                result.addAll(stus);
            }
        }
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), result);
        PageResult<SysOrgPracStuEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("/post/{orgId}/{pracId}")
    @Operation(summary = "获取某个实习项目下的所有岗位")
    public Result<List<SysOrgPracPostEntity>> getAllPostByOrgId(@PathVariable(name = "orgId") long orgId, @PathVariable(name = "pracId") long pracId) {
        List<SysOrgPracPostEntity> allPracPostMessage = sysOrgPracPostService.getAllPracPostMessage(orgId, pracId);
        return Result.ok(allPracPostMessage);
    }

    @GetMapping("post/stu/{orgId}/{pracId}")
    @Operation(summary = "对企业实习项目中全部学生的查看")
    public Result<PageResult<SysOrgPracStuEntity>> getAllStuById(Query query, @PathVariable(name = "orgId") long orgId, @PathVariable(name = "pracId") long pracId) {
        List<SysOrgPracStuEntity> resultList = new ArrayList<>();
        // 对学生状态继续过滤（只选择在实习中和已经实习结束的情况）
        for (SysOrgPracStuEntity stuEntity : sysOrgPracStuService.getAllPracStuMessage(orgId, pracId)) {
            if(stuEntity.getStatus() == 3 || stuEntity.getStatus() == 4) {
                resultList.add(stuEntity);
            }
        }
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), resultList);
        PageResult<SysOrgPracStuEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("specificPost/stu")
    @Operation(summary = "获取某个实习某个岗位下的所有学生")
    public Result<List<SysOrgPracStuEntity>> getStuByPostId(long orgId,long pracId,long postId) {
        List<SysOrgPracStuEntity> allStus = sysOrgPracStuService.getAllStuPracByOrgAndPracAndPostId(orgId, pracId, postId);
        return Result.ok(allStus);
    }

    @PutMapping("post/status/{id}/{status}")
    @Operation(summary = "是否通过该企业实习项目中的岗位")
    public Result<String> isAcceptPost(@PathVariable(name = "id") int id, @PathVariable(name = "status") int status){
        sysOrgPracPostService.changePostStatus(id,status);
        return Result.ok("success");
    }

    @GetMapping("post/interview/{orgId}/{pracId}")
    @Operation(summary = "获取笔试面试管理信息")
    public Result<List<SysOrgPracInterviewEntity>> getAllInterview(@PathVariable(name = "orgId") long orgId, @PathVariable(name = "pracId") long pracId) {
        List<SysOrgPracInterviewEntity> allInterviews = sysOrgPracInterviewService.getAllInterviews(orgId, pracId);
        return Result.ok(allInterviews);
    }

    @GetMapping("home")
    @Operation(summary = "查看该学院下发布的实习批次（根据年份排序）")
    public Result<List<SysCollegePracEntity>> getAllPracsByStatus(Query query,@RequestParam("collegeId") long collegeId) {
        List<SysCollegePracEntity> orgPracs = sysCollegePracService.getAllOrderByYear(collegeId);
        for (SysCollegePracEntity collegePrac : orgPracs) {
            long timeId = collegePrac.getTimeId();
            // 中间表通过CollegeId和TimeId查询到这一学院这一批次下的所有实习id
            List<SysOrgCollegePracEntity> pracsInfo = sysOrgCollegePracService.selectOrgByCollegeIdAndTimeID(collegeId, timeId);
            List<Long> pracIds = new ArrayList<>();
            for (SysOrgCollegePracEntity pracEntity : pracsInfo) {
                pracIds.add(pracEntity.getOrgPracId());
            }
            long count = sysOrgPracStuService.count(new QueryWrapper<SysOrgPracStuEntity>().in("status",3,4).in("prac_id",pracIds));
            collegePrac.setStuNum(count);
        }
        return Result.ok(orgPracs);
    }

    @PostMapping("postInternship")
    @Operation(summary = "学院发表单期实习")
    public Result<String> postInternship(@RequestParam("year") String year, @RequestParam("name") String quarter,@RequestParam("collegeId") int collegeId) {
        sysCollegePracService.postInternship(year,quarter,collegeId);
        return Result.ok("Success");
    }

}
