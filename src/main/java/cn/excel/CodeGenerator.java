package cn.excel;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//演示例子：执行main方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer help = new StringBuffer();
        help.append("请输入" + tip + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("author：ZH");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("haiyuan");
        dsc.setPassword("zhd253");
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //若有值新建一个模块
        pc.setParent("cn.excel");
        mpg.setPackageInfo(pc);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        //如果模板引擎是freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        //如果模板引擎是velocity
        //String templatePath="/templaters/mapper.xml.vm";

        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名，如果你Entity设置了前后缀，此处注意xml的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分隔").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(""); //去掉表前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
