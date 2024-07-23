package com.ziyao.harbor.usercenter;

import com.ziyao.security.oauth2.core.Authentication;
import com.ziyao.security.oauth2.core.context.SecurityContextHolder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author zhangziyao
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.ziyao.harbor.usercenter.repository.mapper")
@EntityScan(basePackages = "com.ziyao.harbor.usercenter.entity")
@EnableJpaRepositories(basePackages = "com.ziyao.harbor.usercenter.repository.jpa")
public class UserCenter {

    public static void main(String[] args) {
        System.setProperty(SecurityContextHolder.SYSTEM_PROPERTY, SecurityContextHolder.MODE_DEBUG);
        SpringApplication.run(UserCenter.class, args);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
    }

}
