package cn.excel.mapper;

import cn.excel.entity.JsLine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author：ZH
 * @since 2021-04-01
 */
public interface JsLineMapper extends BaseMapper<JsLine> {

    /**
     * 批量导入
     * @param lineList
     * @return
     */
    void batchInsert(@Param("list") List<JsLine> lineList);

}
