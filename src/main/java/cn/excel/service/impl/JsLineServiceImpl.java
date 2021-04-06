package cn.excel.service.impl;

import cn.excel.entity.JsLine;
import cn.excel.mapper.JsLineMapper;
import cn.excel.service.JsLineService;
import cn.excel.utils.ExcelUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional(rollbackFor = RuntimeException.class) //开启事务控制
public class JsLineServiceImpl extends ServiceImpl<JsLineMapper, JsLine> implements JsLineService {

    @Autowired
    private JsLineMapper jsLineMapper;

    @Override
    public Integer excelToOracle(MultipartFile file) throws IOException {
        ExcelUtils.addJsLine(file.getInputStream(),jsLineMapper);
        return 1;
    }
}
