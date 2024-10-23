package com.spring.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringBasics.com.hellospring.HelloWorld;

public class Main {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
     ApplicationContext context = new  ClassPathXmlApplicationContext("com/spring/st/Config.xml");
      
        Student student =  context.getBean("student",Student.class);
        System.out.println(student);
        
        
    
    }
}
