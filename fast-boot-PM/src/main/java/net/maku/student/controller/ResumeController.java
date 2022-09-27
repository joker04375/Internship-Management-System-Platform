package net.maku.student.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.Result;
import net.maku.student.entity.SysStuResumeEntity;
import net.maku.student.service.SysStuResumeService;
import net.maku.student.vo.SysStuResumeVO;
import net.maku.security.utils.UserHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("sys/stu/resume")
@AllArgsConstructor
@Tag(name="我的简历管理")
public class ResumeController {
    private final SysStuResumeService sysStuResumeService;

    /**
     * 我的简历
     * @return
     */
    @GetMapping("model")
    public Result selectResume(){
        SysStuResumeEntity stuResumeEntity = sysStuResumeService.selectByUserId(UserHolder.getUser().getId());
        if(ObjectUtil.isEmpty(stuResumeEntity)||stuResumeEntity==null){
            return Result.error("错误");
        }
        return Result.ok(stuResumeEntity);
    }

    /**
     * 上传简历
     * @param stuResumeVo
     * @return
     */
    @PutMapping("modify")
    public Result modifyResume(@RequestBody SysStuResumeVO stuResumeVo){
        //类型转换
        SysStuResumeEntity sysStuResume = BeanUtil.copyProperties(stuResumeVo, SysStuResumeEntity.class);

        //根据当前用户id
        LambdaQueryWrapper<SysStuResumeEntity> queryWrapper = new LambdaQueryWrapper<>();
        Long userId = UserHolder.getUser().getId();

        queryWrapper.eq(SysStuResumeEntity::getStuId,userId);
        sysStuResume.setStuId(userId);

        sysStuResumeService.saveOrUpdate(sysStuResume,queryWrapper);

        return Result.ok("上传成功");
    }


    @DeleteMapping("delete")
    public Result deleteResume(){
        sysStuResumeService.deleteResumeByUserId();
        return Result.ok("删除成功");
    }
}
