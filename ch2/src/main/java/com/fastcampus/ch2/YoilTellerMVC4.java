package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC4 { //http:localhost/ch2/getYoilMVC?year=2023&month=2&day=27
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC4")
	public String main( MyDate date, Model model) throws IOException {
//	public void main(int year, int month, int day, Model model) throws IOException {
		//�Ű� ������ �� ����
		
//			ModelAndView mv = new ModelAndVie w();
		
			// 1. ��ȿ�� �˻�
			if(!isValid(date))
				return "yoilError";
			
			// 2.���� ���
			char yoil = getYoil(date);
		
			// 3.����� ����� �𵨿� ����	
			//K�� myDate�� V�� date�� ����
			model.addAttribute("myDate",date);
			model.addAttribute("yoil",yoil);
			
			
		return "yoil"; // /WEB-INF/views/yoil.jsp 
		//��ȯŸ���� void�� �ϰԵǸ� ���ε� �ּ��� .jsp�� View�� ȣ��ȴ�
		
	}

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(),date.getMonth(),date.getDay());
	}

	private char getYoil(MyDate date) {
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