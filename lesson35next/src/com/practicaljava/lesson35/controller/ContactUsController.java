package com.practicaljava.lesson35.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.practicaljava.lesson35.model.ContactUs;

@Controller
@SessionAttributes
public class ContactUsController {

	@RequestMapping(value="/addQuestion", method=RequestMethod.POST)
	public String addUserQuestion(@ModelAttribute("contactUs") ContactUs
			contactUs, BindingResult result){
		System.out.println("New message:\nSubject:" + contactUs.getSubject());
		System.out.println("Author " + contactUs.getAuthor());
		System.out.println("Message "+ contactUs.getMessage());
		return "redirect:contactUs.html";
	}
	
	@RequestMapping("/contactUs")
	public ModelAndView contactUs(){
		return new ModelAndView("contactUs", "command", new ContactUs());
	}
}