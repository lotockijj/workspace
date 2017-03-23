package com.main;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 1L;

	public DrawEvent(Object source) {
		super(source);
	}
	
	public String toString(){
		return "Draw event occured";
	}

}
