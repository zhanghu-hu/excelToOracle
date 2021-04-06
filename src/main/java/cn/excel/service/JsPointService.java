package cn.excel.service;

import cn.excel.entity.JsPoint;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author：ZH
 * @since 2021-04-01
 */
public interface JsPointService extends IService<JsPoint> {

    /**
     * excel表格导入Oracle
     * @param file
     */
    void excelToOracle(MultipartFile file) throws IOException;
}
