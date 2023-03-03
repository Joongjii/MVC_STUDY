package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
	
	// @ExceptionHandler
	// 반복되는 try catch 문을 생략할 수 있다
	// Exception 클래스의 예외들이 발생했을때 error.jsp를 반환하도록 한다

@Controller
public class ExceptionController2 {
	//GolbalCatcher.java의 @ControllerAdvice를 통해 처리된다
	//만약에 주석을 해제하고 실행했을 때는 에러와 가장 가까운 곳에 있는 EH가 에러를 처리한다
	
//	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
//	public String catcher2(Exception ex, Model m) {
//		System.out.println("EC2.java에 있는 catcher가 처리했습니다");
//		m.addAttribute("ex", ex);
//		return "/error";
//	}


//	@ExceptionHandler(Exception.class)
//	public String catcher1(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
//		return "/error";
//	}
	
	@RequestMapping("/ex3")
	public String main() throws Exception {
			throw new Exception("예외1가 발생했습니다");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception {
		
			throw new FileNotFoundException("예외2가 발생했습니다");
		 // throw new NullPointerException("예외2가 발생했습니다");
	     
	}
	
	
}
