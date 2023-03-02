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
	//�迭�� �̿��� �� �� �����ϰ� �� �� �ִ�
	//RequestMapping�� �����ϰ� �� �� �ְ� ���ִ� ���� @GetMapping, @PostMapping

	
	//servlet-context.xml�� �Ʒ� ���� ViewController�� ����ϸ� �ű�ȸ������ ȭ�鿡 ���� ������ �ּ��� �����ϴ�
	//<view-controller path="register/add" view-name="registerForm"></view-controller>
	
	
//	@RequestMapping("/register/add") //�ű�ȸ�� ���� ȭ���� GET���� �Ѵ� 
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; //URL������ ��ȯ�� WEB-INF/views/registerForm.jsp�� �Ѵ�
//							   //add�� ���� registerForm���� ��ȯ�ϸ� ���� ���������� �̵��Ѵ�
//	}
	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST) -- POST������θ� ȸ������ ���� ���
	@PostMapping("/register/save") //PostMapping�� ������ 4.3���� ������ ������Ʈ �ؾ��Ѵ�
	public String save(User user,Model m) throws Exception {
		// id, pwd, name��� User�� ���� �ϳ���
		//1. ��ȿ�� �˻�
		
		if(!isValid(user)) {
			
			String msg =URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			// URL �����Ҷ��� ȭ�� ����Ҷ� ���ڵ������Ƿ� ���ڴ��� �߰����ش�
			//registerForm���� ���ڴ��� �߰��Ѵ�
			
			m.addAttribute("msg",msg);
			return "redirect:/register/add";
			//redirect�� ���û model�� ���û�� �� �� �� ����
			//�Ʒ� �� �ٰ� �����ϴ� �Ѱ���ߵ� ���� msgó�� �ϳ���� �Ʒ� �ڵ尡 ������
			//��������� model�� ��Ƽ� �Ѱ��ִ°��� ����
//			return "redirect:/register/add?msg=" + msg; //URL���ۼ�(rewriting)
			}
		
		
		
		
		//2. DB�� �ű�ȸ�� ������ ����
		return"registerInfo";
	}

	private boolean isValid(User user) {
	
		return true;
	}
}