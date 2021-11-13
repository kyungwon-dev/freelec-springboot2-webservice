package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication
 * 스프링 부트의 자동 설정, 스프링 Bean 읽기 생성 모두 자동으로 설정.
 * 프로젝트 최상단에 위치해야 함.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        /*
         * SpringApplication.run()을 통해 내장 WAS 실행.
         * SpringBoot Project 에서는 보통 내장 WAS 를 사용하는 것을 권장.
         * - 언제 어디에서나 같은 환경으로 스프링부트 배포가 가능하기 때문
         */
        SpringApplication.run(Application.class, args);
    }
}
