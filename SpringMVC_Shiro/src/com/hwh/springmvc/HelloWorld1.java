package com.hwh.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloworld1")
public class HelloWorld1 {
	
	@RequestMapping("/0")
	public String hello(){
		System.out.println("111");
		return "index";
	}
	

	
}
