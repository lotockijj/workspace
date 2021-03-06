package com.main;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

//import org.springframework.beans.factory.annotation.Required;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware{
	private ApplicationEventPublisher publisher;
	private Point center;
	@Autowired
	MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

//	@Required
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, ""
				+ "Default Drawing circle Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", 
				new Object[]{center.getX(),center.getY()}, "Default Drawing Message for point", null));
		System.out.println("Circle center is: " + center.getX() + "x" + center.getY());
		System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}
	
	@PostConstruct 
	public void initializeCircle(){
		System.out.println("Init of Circle!!!");
	}
	
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy circle!!!");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
