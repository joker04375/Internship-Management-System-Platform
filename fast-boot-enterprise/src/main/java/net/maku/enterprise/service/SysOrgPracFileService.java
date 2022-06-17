package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracFileEntity;
import net.maku.framework.common.service.BaseService;
import net.maku.framework.common.utils.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface SysOrgPracFileService extends BaseService<SysOrgPracFileEntity> {

    void fileDownload(HttpServletResponse response,String downLoadUrl);

    void fileUpload(@RequestBody MultipartFile upLoadFile);
}
