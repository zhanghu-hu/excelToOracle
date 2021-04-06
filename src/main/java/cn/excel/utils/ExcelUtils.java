package cn.excel.utils;

import cn.excel.entity.JsLine;
import cn.excel.entity.JsPoint;
import cn.excel.listener.JsLineListener;
import cn.excel.listener.JsPointListener;
import cn.excel.mapper.JsLineMapper;
import cn.excel.mapper.JsPointMapper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;

import java.io.InputStream;

/**
 * 将excel表格导入Oracle
 * @author ZH
 * @date 2021-04-02
 */
public class ExcelUtils {

    /**
     * 将输入流写入Oracle数据库
     * @param file 输入流文件
     * @param jsLineMapper 数据库映射文件
     */
    public static void addJsLine(InputStream file, JsLineMapper jsLineMapper){
        ExcelReader excelReader = null;
        try {
            //修改类、监听器和映射文件
            excelReader = EasyExcel.read(file, JsLine.class, new JsLineListener(jsLineMapper)).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }

    /**
     * 将输入流写入Oracle数据库
     * @param file 输入流文件
     * @param jsPointMapper 数据库映射文件
     */
    public static void addJsPoint(InputStream file, JsPointMapper jsPointMapper){
        ExcelReader excelReader = null;
        try {
            //修改类、监听器和映射文件
            excelReader = EasyExcel.read(file, JsPoint.class, new JsPointListener(jsPointMapper)).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }
}
