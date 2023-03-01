package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); //private�̶� �ܺ� ȣ�� �Ұ�
	
		//Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
		//java.lang.reflect��Ű���� ����
		
		//Hello Ŭ������ Class ��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		//Class == ���赵 : ��ü�� ���� �� �ְ� ��ü�� � ����� ������ �ִ����� �� �� �ִ�
		Class helloOfClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello) helloOfClass.newInstance(); //Class��ü�� ���� ������ ��ü ����
		
		Method main = helloOfClass.getDeclaredMethod("main"); 
		main.setAccessible(true); //private�� main()�� ȣ�Ⱑ���ϰ� �Ѵ�.
		
		main.invoke(hello); //hello.main();
	
		
		
	}
}
