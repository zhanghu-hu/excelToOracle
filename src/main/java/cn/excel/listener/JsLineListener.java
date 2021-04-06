package cn.excel.listener;

import cn.excel.entity.JsLine;
import cn.excel.mapper.JsLineMapper;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 读JsLine的监听器
 * 这个监听器不能被spring管理，每次读取excel需要new，用到spring的地方通过构造函数传入
 *
 * @author ZH
 * @date 2021-4-2
 */
public class JsLineListener extends AnalysisEventListener<JsLine> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsLineListener.class);

    /**
     * 每隔20条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 20;

    /**
     * 放缓存解析数据的
     */
    private List<JsLine> list=new ArrayList<>();

    private JsLineMapper jsLineMapper;

    public JsLineListener(JsLineMapper mapper){
        this.jsLineMapper=mapper;
    }

    /**
     * 每一条解析数据都会调用的方法
     * @param jsLine
     * @param analysisContext
     */
    @Override
    public void invoke(JsLine jsLine, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(jsLine));
        list.add(jsLine);
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
        jsLineMapper.batchInsert(list);
        LOGGER.info("存储数据库成功！");
    }
}
