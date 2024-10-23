package com.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringBasics.com.hellospring.HelloWorld;

public class Main {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
     ApplicationContext context = new  ClassPathXmlApplicationContext("com/spring/scope/Config.xml");
      
        Student student =  context.getBean("ob",Student.class);
        System.out.println(student.hashCode());
        
        Student student1 =  context.getBean("ob",Student.class);
        System.out.println(student1.hashCode());
        
    
    }
}
