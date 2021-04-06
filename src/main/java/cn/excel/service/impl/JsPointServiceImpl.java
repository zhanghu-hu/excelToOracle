package cn.excel.service.impl;

import cn.excel.entity.JsPoint;
import cn.excel.listener.JsPointListener;
import cn.excel.mapper.JsPointMapper;
import cn.excel.service.JsPointService;
import cn.excel.utils.ExcelUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author：ZH
 * @since 2021-04-01
 */
@Service
public class JsPointServiceImpl extends ServiceImpl<JsPointMapper, JsPoint> implements JsPointService {

    @Autowired
    private JsPointMapper jsPointMapper;

    @Override
    public void excelToOracle(MultipartFile file) throws IOException {
        ExcelUtils.addJsPoint(file.getInputStream(),jsPointMapper);
    }
}
