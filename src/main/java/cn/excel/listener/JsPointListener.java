package cn.excel.listener;

import cn.excel.entity.JsLine;
import cn.excel.entity.JsPoint;
import cn.excel.mapper.JsLineMapper;
import cn.excel.mapper.JsPointMapper;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class JsPointListener extends AnalysisEventListener<JsPoint> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsLineListener.class);

    /**
     * 每隔20条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 20;

    /**
     * 放缓存解析数据的
     */
    private List<JsPoint> list=new ArrayList<>();

    private JsPointMapper jsPointMapper;

    public JsPointListener(JsPointMapper mapper){
        this.jsPointMapper=mapper;
    }

    /**
     * 每一条解析数据都会调用的方法
     * @param jsPoint
     * @param analysisContext
     */
    @Override
    public void invoke(JsPoint jsPoint, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(jsPoint));
        list.add(jsPoint);
        //达到阈值，就存到数据库里面，是内存中数据在合理空间
        if (list.size()>=BATCH_COUNT){
            saveData();
            //存储完，清空list
            list.clear();
        }
    }

    /**
     * 所有数据解析都完成了就会来调用，保证最后一次的数据集存入数据库
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        if (list.size()>0) {//避免阈值倍数问题
            saveData();
        }
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        jsPointMapper.batchInsert(list);
        LOGGER.info("存储数据库成功！");
    }
}
