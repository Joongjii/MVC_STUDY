package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@ModelAttribute ���� ����� Model�� �Ӽ����� �ڵ� �߰����ִ� �������̼� -- K, V�� �𵨿� ����
//��ȯ Ÿ�� �Ǵ� ��Ʈ�ѷ� �޼����� �Ű������� ���� ����

//������ �Ű��������� @ModelAttribute�� ���� ����
//�ݴ�� �⺻���� String���� @RequestParam ���� ����


@Controller
public class YoilTellerMVC6 { //http:localhost/ch2/getYoilMVC?year=2023&month=2&day=27
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex,BindingResult result) {
		System.out.println("result��"+result);
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC6")
	// public String main(@ModelAttribute("myDate") MyDate date, Model model) throws IOException {
	// ("myDate") ���� ���� -- Ÿ���� ù ���ڸ� �ҹ��ڷ� �Ͽ� K ���� ���� V�� date�� �ּҰ�
	// �޼����� �Ű������� @�� ���� ���̽�
	   public String main( MyDate date, BindingResult result) {	
		//@MA�� �����ϰ� BR�� ���ε� ���� �����ּ��ϰ� day�� aa���� ������ ���� ������ ���� 
		//�� ����result�� ��Ʈ�ѷ����� ������ ���ߴ� ��??--
		//@MA�� �����ϰ� BR�� ���ε� ���� �����ּ������ϰ� day�� aa���� ������ ������ ���� 
		//���� ó���� ����ش� console�� ���� result ��ü�� ���� ������ ���´�
		System.out.println("result��"+result);
		
		//�ܼ��� ���� �����ٸ� FieldError�� �̿��ؼ� ���� �ȴ�
		FieldError error = result.getFieldError();
		System.out.println("codecode="+error.getCode());
		System.out.println("fieldfield="+error.getField());
		System.out.println("msgmsg="+error.getDefaultMessage());
		
			// 1. ��ȿ�� �˻�
			if(!isValid(date))
				return "yoilError";
			
		//  Model Attribute�� �̿��ϸ� �� �κ��� �ʿ䰡 ����
//			// 2.���� ���
//			char yoil = getYoil(date);
//		
//			// 3.����� ����� �𵨿� ����	
//			//K�� myDate�� V�� date�� ����
//			model.addAttribute("myDate",date);
//			model.addAttribute("yoil",yoil);
			
			
		return "yoil"; // /WEB-INF/views/yoil.jsp 
		//��ȯŸ���� void�� �ϰԵǸ� ���ε� �ּ��� .jsp�� View�� ȣ��ȴ�
		
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(),date.getMonth(),date.getDay());
	}
	//�޼����� ��ȯ Ÿ�Կ� @�� ���� ���̽�
	//��ȯŸ���� ȣ�� ����� �𵨿� ���� yoil-Ű '��'��� ������-��(value)
	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(),date.getMonth(),date.getDay());
	}

	private boolean isValid(int year, int month, int day) {
			return true;
		}
	
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day); //���� -1 ����� �Ѵ�
		System.out.println(cal);
	
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //calendar�� ����Ű��(�ǹ��ϴ�) Ư�� ��¥�� ���� �������� �˱� ���� ���δ�.
	return " �Ͽ�ȭ�������".charAt(dayOfWeek);
}

}