package com.SetterExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringBasics.com.hellospring.HelloWorld;

public class Main {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new  ClassPathXmlApplicationContext("com/SetterExample/Config.xml");
        Student obj = (Student)context.getBean("student1");
        Student obj1= (Student)context.getBean("student2");
        System.out.println(obj);     
        System.out.println(obj1);     

    
    }
}
