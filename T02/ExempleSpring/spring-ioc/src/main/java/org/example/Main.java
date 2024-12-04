package org.example;

import org.example.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService service = (MyService) context.getBean("myService");

        service.exist();

        //((ClassPathXmlApplicationContext) context).close();
        ((AnnotationConfigApplicationContext) context).close();
    }
}