package com.spring.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringBasics.com.hellospring.HelloWorld;

public class Main {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        AbstractApplicationContext context = new  ClassPathXmlApplicationContext("com/spring/lifecycle/Config.xml");
      
        Example example =(Example) context.getBean("example");
        System.out.println(example);
        context.registerShutdownHook();
        
    
    }
}
