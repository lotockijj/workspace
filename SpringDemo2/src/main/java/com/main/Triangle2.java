package com.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle2 implements ApplicationContextAware, BeanNameAware 
		, InitializingBean, DisposableBean, Shape{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	ApplicationContext context = null;
	
	public Point getPointA() {
		return pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw(){
		System.out.println("Drawing triangle2: ");
		System.out.println("Triangle with coordinates: " + pointA + "; " + pointB + "; " + pointC);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean name is: " + beanName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing init method called for Triangle! ");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy method called for Triangle! ");
	}
	
	public void myInit(){
		System.out.println("My init method called for Triangle2");
	}
	
	public void cleanUp(){
		System.out.println("My clean up method called for Triangle2");
	}
}
