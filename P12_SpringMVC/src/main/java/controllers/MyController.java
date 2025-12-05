package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class MyController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";  
	}
	
	@RequestMapping("/welcome")
	public ModelAndView greet(HttpServletRequest request) {
		String nm = request.getParameter("name");	
		//view name, model name, model value(object)		
		return new ModelAndView("welcome","nm",nm);
	}
	
	@RequestMapping("/info")
	public String info(ModelMap map) {
		map.addAttribute("req_method", "GET");
		map.addAttribute("req_url","/info");
		map.addAttribute("req_host","localhost:8080");
		return "info"; 
	}
	
	
	
}
