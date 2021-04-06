package cn.excel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务控制
@EnableTransactionManagement
//扫描包
@MapperScan("cn.excel.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
