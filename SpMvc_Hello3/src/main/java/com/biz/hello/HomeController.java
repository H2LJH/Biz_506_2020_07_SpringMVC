package com.biz.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController 
{	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);	
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value ="/home2")
	public String home2(Model model)
	{
		model.addAttribute("your", "너, 홍길동");
		return "home2";
	}
	
	@RequestMapping(value ="/home3")
	public String home3(Model model)
	{
		return "home3";
	}
	
	@RequestMapping(value ="/home4")
	public String home4(Model model)
	{
		return "home4";
	}
	
	@RequestMapping(value ="/home5")
	public String home5(Model model)
	{
		return "home5";
	}
	
}
