package cn.excel.mapper;

import cn.excel.entity.JsPoint;
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
public interface JsPointMapper extends BaseMapper<JsPoint> {

    /**
     * 批量导入
     * @param list
     * @return
     */
    Integer batchInsert(@Param("list") List<JsPoint> list);
}
