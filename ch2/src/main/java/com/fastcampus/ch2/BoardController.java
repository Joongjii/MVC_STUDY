package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL(); //로그인을 안했으면 로그인 화면으로 이동
											//board/list란 URL을 여기에 담는다
		return "/boardList"; //로그인을 했다면 게시판으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어서
		HttpSession session = request.getSession();
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환
		
		
		
//		if(session.getAttribute("id")!=null)
//			return true;
//		else
//			return false;
		// 2. 세션에 id가 있는지 확인
		return session.getAttribute("id")!=null;
		//null이 아니면 자동적으로 true
	}
}
