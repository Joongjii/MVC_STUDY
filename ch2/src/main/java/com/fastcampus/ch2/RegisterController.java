package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	//@RequestMapping(value="/register/add", method={RequestMehtod.GET, RequestMethod.POST})
	//배열을 이용해 둘 다 가능하게 할 수 있다
	//RequestMapping을 간단하게 쓸 수 있게 해주는 것이 @GetMapping, @PostMapping

	
	//servlet-context.xml에 아래 줄을 ViewController로 등록하면 신규회원가입 화면에 대한 내용은 주석이 가능하다
	//<view-controller path="register/add" view-name="registerForm"></view-controller>
	
	
//	@RequestMapping("/register/add") //신규회원 가입 화면은 GET으로 한다 
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; //URL맵핑의 반환을 WEB-INF/views/registerForm.jsp로 한다
//							   //add로 놓고 registerForm으로 반환하면 본인 폼페이지로 이동한다
//	}
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST) -- POST방식으로만 회원가입 가능 방식
	@PostMapping("/register/save") //PostMapping은 스프링 4.3부터 가능해 업데이트 해야한다
	public String save(User user,Model m) throws Exception {
		// id, pwd, name등등 User로 묶어 하나로
		//1. 유효성 검사
		
		if(!isValid(user)) {
			
			String msg =URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			// URL 전송할때랑 화면 출력할때 인코딩깨지므로 인코더를 추가해준다
			//registerForm에는 디코더를 추가한다
			
			m.addAttribute("msg",msg);
			return "redirect:/register/add";
			//redirect는 재요청 model을 재요청에 쓸 수 가 없다
			//아래 한 줄과 동일하다 넘겨줘야될 값이 msg처럼 하나라면 아래 코드가 쉽지만
			//여러개라면 model에 담아서 넘겨주는것이 좋다
//			return "redirect:/register/add?msg=" + msg; //URL재작성(rewriting)
			}
		
		
		
		
		//2. DB에 신규회원 정보를 저장
		return"registerInfo";
	}

	private boolean isValid(User user) {
	
		return true;
	}
}
