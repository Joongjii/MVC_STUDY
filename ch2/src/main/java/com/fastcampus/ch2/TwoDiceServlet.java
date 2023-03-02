package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Spring���� ���� @Controller + @RequestMapping ---> @WebServlet
//@WebServlet�� HttpServlet�� ���� ���
//�޼��� �̸��� service�� �����̸� �Ķ���ͷ� request�� response�� ���ԵǾ���Ѵ�
//Servlet�� �⺻������ �̱��� -- 1���� �ν��Ͻ��� ����
//Controller�� ���������� Controller�� ��ӵ� ���� �� ������ ����̴�
//WebServlet�� Ŭ������ URL������ �ȴ�
//Controller�� �޼���� URL���εȴ� --- ���� @WebServlet�� URL�� Ŭ������ �����ؾ�������
//Controller�� ������ �޼��常 �߰������� ������ָ� �ȴ�


@WebServlet("/rollDice2")
public class TwoDiceServlet extends HttpServlet {
    int getRandomInt(int range) {
	return new Random().nextInt(range)+1;
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idx1 = getRandomInt(6);
        int idx2 = getRandomInt(6);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='resources/img/dice"+idx1+".jpg'>");
        out.println("<img src='resources/img/dice"+idx2+".jpg'>");
        out.println("</body>");
        out.println("</html>");
        out.close();	    
    }
}