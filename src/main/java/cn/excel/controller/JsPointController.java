package cn.excel.controller;


import cn.excel.config.Result;
import cn.excel.service.JsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author：ZH
 * @since 2021-04-01
 */
@RestController
@RequestMapping("/jsPoint")
public class JsPointController {

    @Autowired
    private JsPointService jsPointService;

    /**
     * 将excel表格导入Oracle中
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/excel")
    public Result excelToOracle(MultipartFile file) throws IOException{
        jsPointService.excelToOracle(file);
        return new Result().success(null);
    }
}
