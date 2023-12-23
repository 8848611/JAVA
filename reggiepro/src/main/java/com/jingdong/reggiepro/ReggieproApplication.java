package com.jingdong.reggiepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //扫描 servlet一些组件,如:扫描 @WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*"),并创建过滤器
public class ReggieproApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReggieproApplication.class, args);

    }

}
