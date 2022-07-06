package net.maku.enterprise.service;

import net.maku.enterprise.entity.SysOrgPracFileEntity;
import net.maku.framework.common.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SysOrgPracFileService extends BaseService<SysOrgPracFileEntity> {

    Boolean fileDownload(HttpServletResponse response,SysOrgPracFileEntity sysOrgPracFileEntity);

    Boolean fileUpload(MultipartFile upLoadFile,String fileName,String uploder, String fileType, Long orgId,Long pracId);

    List<SysOrgPracFileEntity> getAllFile(Long orgId, Long pracId);

}
