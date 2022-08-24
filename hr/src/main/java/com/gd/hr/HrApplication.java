package com.gd.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication // >>> 이것 하나로 모든 @~ 를 쓸 수 있는거래, 벗 기존의 웹서블릿 ,리스너 필터는 적용 X(ㅅ순수이클립스에서 쓰던)
@ServletComponentScan // >>> 원래 서블릿서 쓰던 어노테이션을 사용할 수 있게 만드는 거랭 (필터 리스너 >> 이건 스프링보다 기존방식이 편해서이걸 추가하나봐)
public class HrApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

}
