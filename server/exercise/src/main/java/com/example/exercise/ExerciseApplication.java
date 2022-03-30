package com.example.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@Configuration
@EntityScan("com.example.exercise.model.entity")
@EnableJpaRepositories("com.example.exercise.repository")
public class ExerciseApplication {
     
     public static void main(String[] args) {
          SpringApplication.run(ExerciseApplication.class, args);
     }
     
}


/* DTO : 데이터를 전송하는 객체
 * ->
 * controller : 받은 요청의 상태여부 리턴이나 서비스로 데이터 값을 service로 넘김
 * ->
 * service : 사용자(고객)의 관련된 부분들을 구현한다. 예) 게시판 만들기 프로젝트 글쓰기 수정 삭제 조회,
 * ->
 * DAO : DB에 접근해서 구현하는 기능들을 묶어 놓은것 DB에 접속해서 비즈니스 로직을 구현하는 쿼리를 호출
 */