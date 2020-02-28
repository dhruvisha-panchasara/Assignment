package com.aimdek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
	
	public static void main(String a[]) {
		
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		model m1 = (model) context.getBean("model");
		model m2 = (model) context.getBean("model");
		
		m1.setName("Msd");
		m2.setName("sakshi");
		
		m1.getName();
		m2.getName();
		
		
	}

}
