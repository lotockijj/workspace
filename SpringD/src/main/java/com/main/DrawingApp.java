package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args){
		//Triangle triangle = new Triangle();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape shape = (Shape) context.getBean("triangle");
		Shape triangle2 = (Shape) context.getBean("triangler-alias");
		Shape triangle3 = (Shape) context.getBean("triangle3");
		Shape triangle4 = (Shape) context.getBean("triangle4");
		shape.draw();
		triangle2.draw();
		triangle3.draw();
		System.out.println("\"Autowiring:\" ");
		triangle4.draw();
		Shape triangle6 = (Shape) context.getBean("triangle6");
		System.out.println("Triangle6: ");
		triangle6.draw();
		Shape triangle7 = (Shape) context.getBean("triangle7");
		System.out.println("Triangle7: ");
		triangle7.draw();
		Shape circle = (Shape) context.getBean("circle");
		circle.draw();
		//System.out.println(context.getMessage("greeting", null, "Default Greeting", null));
		context.close();
	}

}
