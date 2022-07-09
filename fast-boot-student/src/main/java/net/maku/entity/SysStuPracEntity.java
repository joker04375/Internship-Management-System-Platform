package net.maku.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SysStuPracEntity {
    Long orgId;
    Long pracId;
    Long postId;
    Long stuId;
    String post;
    String orgName;
    String YearAndMonth;
}
