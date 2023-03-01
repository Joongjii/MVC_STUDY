package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller { 
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//1. �Է� ��
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);
		
		// 2. �۾�
		Calendar cal = Calendar.getInstance();
		cal.set(y, m - 1, d); //���� -1 ����� �Ѵ�
		System.out.println(cal);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //calendar�� ����Ű��(�ǹ��ϴ�) Ư�� ��¥�� ���� �������� �˱� ���� ���δ�.
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		
		//3. ���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8"); 
		PrintWriter printOut = response.getWriter(); //response ��ü���� ���������� ��� ��Ʈ���� ��´�.
		
			printOut.println("<html>");
			printOut.println("<head>");
			printOut.println("</head>");
			printOut.println("<body>");
			printOut.println(year + "�� " + month + "�� " + day + "���� ");
			printOut.println(yoil + "�����̴�~ ");
			printOut.println("</body>");
			printOut.println("</html>");
		
	}

}