package net.maku.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.enterprise.entity.SysOrgPracFileEntity;
import net.maku.enterprise.entity.SysOrgPracInterviewEntity;
import net.maku.enterprise.entity.SysOrgPracPostEntity;
import net.maku.enterprise.entity.SysOrgPracStuEntity;
import net.maku.enterprise.entity.interation.SysAllOrgPracEntity;
import net.maku.enterprise.service.*;
import net.maku.framework.common.page.PageResult;
import net.maku.framework.common.query.Query;
import net.maku.framework.common.service.SysPublicFileService;
import net.maku.framework.common.utils.FileUtils;
import net.maku.framework.common.utils.PageListUtils;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sys/college/prac")
@Tag(name="实习管理")
@AllArgsConstructor
public class CollegePracMangerController {

    private final SysOrgPracManageService sysOrgPracManageService;

    private final SysOrgPracPostService sysOrgPracPostService;

    private final SysOrgPracStuService sysOrgPracStuService;

    private final SysOrgPracInterviewService sysOrgPracInterviewService;

    private final SysOrgPracFileService sysOrgPracFileService;

    private final SysPublicFileService sysPublicFileService;

    @GetMapping("home")
    @Operation(summary = "查看所有实习项目")
    public Result<PageResult<SysAllOrgPracEntity>> getAllPracsByStatus(Query query) {
        List<SysAllOrgPracEntity> allPrac = sysOrgPracManageService.getAllPrac();
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), allPrac);
        PageResult<SysAllOrgPracEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }


    @GetMapping("search")
    public Result<PageResult<SysAllOrgPracEntity>> getPracsByConditions(@RequestParam(required = false) Map<String,Object> conditions) {

        return null;
    }

    @GetMapping("/post/{orgId}/{pracId}")
    @Operation(summary = "获取某个实习项目下的所有岗位")
    public Result<List<SysOrgPracPostEntity>> getAllPostByOrgId(@PathVariable(name = "orgId") long orgId, @PathVariable(name = "pracId") long pracId) {
        List<SysOrgPracPostEntity> allPracPostMessage = sysOrgPracPostService.getAllPracPostMessage(orgId, pracId);
        return Result.ok(allPracPostMessage);
    }

    @PutMapping("post/status/{id}/{status}")
    @Operation(summary = "是否通过该企业实习项目中的岗位")
    public Result<String> isAcceptPost(@PathVariable(name = "id") int id, @PathVariable(name = "status") int status){
        sysOrgPracPostService.changePostStatus(id,status);
        return Result.ok("success");
    }

    @GetMapping("post/stu/{orgId}/{pracId}")
    @Operation(summary = "对企业实习项目中学生的查看")
    public Result<PageResult<SysOrgPracStuEntity>> getAllStuById(Query query, @PathVariable(name = "orgId") long orgId, @PathVariable(name = "pracId") long pracId) {
        List<SysOrgPracStuEntity> resultList = new ArrayList<>();
        // 对学生状态继续过滤（在实习中还是已结束）
        for (SysOrgPracStuEntity stuEntity : sysOrgPracStuService.getAllPracStuMessage(orgId, pracId)) {
            if(stuEntity.getStatus()== -2 || stuEntity.getStatus() == 2) {
                resultList.add(stuEntity);
            }
        }
        // 进行分页
        Page pages = PageListUtils.getPages(query.getPage(), query.getLimit(), resultList);
        PageResult<SysOrgPracStuEntity> page = new PageResult<>(pages.getRecords(), pages.getTotal());
        return Result.ok(page);
    }

    @GetMapping("post/interview/{orgId}/{pracId}")
    @Operation(summary = "获取笔试面试管理信息")
    public Result<List<SysOrgPracInterviewEntity>> getAllInterview(@PathVariable(name = "orgId") long orgId, @PathVariable(name = "pracId") long pracId) {
        List<SysOrgPracInterviewEntity> allInterviews = sysOrgPracInterviewService.getAllInterviews(orgId, pracId);
        return Result.ok(allInterviews);
    }

    @PostMapping("post/fileUpload/{orgId}/{pracId}")
    @Operation(summary = "上传公共文件")
    public Result<String> submitForm(@RequestParam("file") MultipartFile file,
                                     @RequestParam("fileName") String fileName,
                                     @RequestParam("fileType") String fileType,
                                     @RequestParam("uploader") String uploader,
                                     @RequestParam("uploadTime") String uploadTime,
                                     @PathVariable("orgId") long orgId,
                                     @PathVariable("pracId") long pracId
                                     ) {
        // 上传文件至本地，返回存储路径
        String storagePath = FileUtils.uploadCommonFile(file);

        SysOrgPracFileEntity sysOrgPracFileEntity = new SysOrgPracFileEntity();

        sysOrgPracFileEntity.setFileAddr(storagePath);
        sysOrgPracFileEntity.setFileName(fileName);
        sysOrgPracFileEntity.setFileType(fileType);
        sysOrgPracFileEntity.setUploader(uploader);
        // 1 代表公共文件(直接设置为1，这个接口是用来上传公共文件的)
        sysOrgPracFileEntity.setIsCommon(1);

            // 作用在时间戳
        //long timeLong = Long.parseLong(uploadTime);
        //date = simpleDateFormat.parse(simpleDateFormat.format(timeLong));
        //sysOrgPracFileEntity.setUploadTime(new java.sql.Date(date.getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(uploadTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Timestamp timestamp = new Timestamp(date.getTime());
        sysOrgPracFileEntity.setUploadTime(String.valueOf(timestamp));

        sysOrgPracFileEntity.setOrgId(orgId);
        sysOrgPracFileEntity.setPracId(pracId);

        sysOrgPracFileService.save(sysOrgPracFileEntity);


        return Result.ok("success");
    }

}
