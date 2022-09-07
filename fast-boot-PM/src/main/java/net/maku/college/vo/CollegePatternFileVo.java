package net.maku.college.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegePatternFileVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private long collegeId;

    private long timeId;

    private MultipartFile file;

    private String fileName;

    private String fileType;

    private int isNeed;

    private int isOrgRead;

    private int isStuRead;

    private int isCommon;
}
