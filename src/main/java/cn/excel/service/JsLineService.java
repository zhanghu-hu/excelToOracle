package cn.excel.service;

import cn.excel.entity.JsLine;
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
public interface JsLineService extends IService<JsLine> {

    /**
     * 导入数据
     * @param file
     * @return
     */
    Integer excelToOracle(MultipartFile file) throws IOException;
}
