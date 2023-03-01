package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//��ü ������ �ؾ��ϴµ� ��� �ν��Ͻ��޼����� main���� ������ �����ұ�?
//������ ��Ĺ ���ο��� ��ü�� ������ �� �޼��带 ȣ���ϱ� �����̴�
//�׷��� static�� �����ѵ� ��?? �ν��Ͻ��޼���� ������ ��ȣ�ұ�?
//�ֳĸ� �ν��Ͻ��޼���� iv�� cv�� ��� ��� �����ϴ�
//���� public�� �ƴ� private�� ����� �����ϴ�
//��?? RequestMapping�� �ܺο��� ȣ�� �����ϰڴٴ� �ǹ��̱⿡ ���������ڴ� �������
//�� �ܺ�(Ŭ����)���� main�Լ��� ȣ���ϴ� ���� �Ұ����ϴ�
//Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
//java.lang.reflect��Ű���� ����


//1. ���� ȣ�� ������ ���α׷����� ���
@Controller
public class Hello {
	int iv = 10;
	static int cv = 20;
	
	
	@RequestMapping("/helloSpring")
	// 2. URL�� �޼��带 ����
	private void main() { //�ν��Ͻ� �޼��� - iv, cv�� �� �� ��밡��
		System.out.println("Hello - private");
		System.out.println(cv); //OK
		System.out.println(iv); //OK
	}
	
	public static void main2()	{
		System.out.println(cv); //OK
		//System.out.println(iv);
	}
	
	
	
	
	
	
	
	
	
	

}
