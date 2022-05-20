package com.english.cimu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author acloudtwei
 */
@SpringBootApplication
@MapperScan("com.english.cimu.dao")
@MapperScan("com.english.cimu.Tmapper")
@MapperScan("com.english.cimu.mapper")
@EnableCaching  // 开启SpringBoot基于注解的缓存管理支持
public class CimuApplication {

    public static void main(String[] args) {
        SpringApplication.run(CimuApplication.class, args);
    }

}