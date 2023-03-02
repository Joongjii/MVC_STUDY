package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC2 { //http:localhost/ch2/getYoilMVC?year=2023&month=2&day=27
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
	public String main( @RequestParam(required=true) int year, 
			@RequestParam(required=true) int month, 
			@RequestParam(required=true) int day, Model model) throws IOException {
//	public void main(int year, int month, int day, Model model) throws IOException {
		//�Ű� ������ �� ����
		
//			ModelAndView mv = new ModelAndVie w();
		
			// 1. ��ȿ�� �˻�
			if(!isValid(year,month,day))
				return "yoilError";
			
			// 2.���� ���
			char yoil = getYoil(year, month, day);
		
			// 3.����� ����� �𵨿� ����
			model.addAttribute("year",year);
			model.addAttribute("month",month);
			model.addAttribute("day",day);
			model.addAttribute("yoil",yoil);
			
			
		return "yoil"; // /WEB-INF/views/yoil.jsp 
		//��ȯŸ���� void�� �ϰԵǸ� ���ε� �ּ��� .jsp�� View�� ȣ��ȴ�
		
		
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