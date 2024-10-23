package com.annoExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // Use AnnotationConfigApplicationContext to load the Java-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        HelloWorld obj = context.getBean(HelloWorld.class);
        obj.getMessage();
    }
}
