package net.maku.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class SysStuPracEntity {
    Long orgId;
    Long pracId;
    Long postId;
    Long stuId;
    String post;
    String orgName;
    Date YearAndMonth;
}
