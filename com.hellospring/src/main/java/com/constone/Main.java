package com.constone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context = new  ClassPathXmlApplicationContext("com/constone/Config.xml");
		 
		 Person pen = (Person)context.getBean("person");
		 System.out.println(pen);
		
	}

}
