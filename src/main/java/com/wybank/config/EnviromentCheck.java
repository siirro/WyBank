package com.wybank.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnviromentCheck {
    public final Environment env; //설정값을 가져오기 위한 객체

    public EnviromentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init(){

        String url = env.getProperty("spring.datasource.url"); // url 가져오기
        String name = env.getProperty("spring.datasource.username"); // name 가져오기

        //로그 찍기
        log.info("url = {}", url);
        log.info("name = {}", name);

    }
}
