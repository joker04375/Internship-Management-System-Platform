package net.maku.student.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.Result;
import net.maku.student.entity.SysStuDetailsEntity;
import net.maku.student.service.SysStuDetailsService;
import net.maku.student.vo.SysStuDetailsVO;
import net.maku.utils.UserHolder;
import org.springframework.web.bind.annotation.*;

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
        SysStuDetailsEntity sysStuDetailsEntity = sysStuDetailsService.selectByUserId(UserHolder.getUser().getId());
        return Result.ok(sysStuDetailsEntity);
    }

    /**
     * 修改我的信息
     * @return
     */
    @PutMapping("myInfo/change")
    public Result ChangeMyInfo(@RequestBody SysStuDetailsVO sysStuDetailsVO) {
        //类型转换
        SysStuDetailsEntity sysStuDetailsEntity = BeanUtil.copyProperties(sysStuDetailsVO, SysStuDetailsEntity.class);

        //根据当前用户id
        LambdaQueryWrapper<SysStuDetailsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysStuDetailsEntity::getStuId,sysStuDetailsVO.getStuId());
        sysStuDetailsService.update(sysStuDetailsEntity,queryWrapper);

        return Result.ok("上传成功");
    }

}
