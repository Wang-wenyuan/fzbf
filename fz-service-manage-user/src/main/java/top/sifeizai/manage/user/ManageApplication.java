package top.sifeizai.manage.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: wwy
 * @Date: 2019-07-08 15:17
 */
@EnableSwagger2
@EntityScan("top.sifeizai.framework.domain.management")//扫描实体类
@ComponentScan(basePackages={"top.sifeizai.api"})//扫描接口
@ComponentScan(basePackages={"top.sifeizai.framework"})//扫描framework中通用类
@ComponentScan(basePackages={"top.sifeizai.manage.user"})//扫描本项目下的所有类
@SpringBootApplication(scanBasePackages = "top.sifeizai.exception")
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class);
    }
}
