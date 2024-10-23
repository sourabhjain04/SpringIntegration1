package com.spring.auto.wire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringBasics.com.hellospring.HelloWorld;

public class Main {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
     ApplicationContext context = new  ClassPathXmlApplicationContext("com/spring/auto/wire/Config.xml");
      
        Emp  emp1 =  (Emp) context.getBean("emp1");
        System.out.println(emp1);
        
        
    
    }
}
