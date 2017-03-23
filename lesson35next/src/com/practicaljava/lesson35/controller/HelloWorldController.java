package com.practicaljava.lesson35.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView sayHello(){
		String greetings = "Hello people";
		return new ModelAndView("hello", "greetings", greetings);
	}
}
