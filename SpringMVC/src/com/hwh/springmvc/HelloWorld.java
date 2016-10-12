package com.hwh.springmvc;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helloworld")
@SessionAttributes("user")
public class HelloWorld {
	
	@RequestMapping("/hello")
	public String hello(){
		return "index";
	}
	
	@RequestMapping("/hello1/{id}")
	public String hello1(@PathVariable("id") int id){
		System.out.println(id);
		return "index";
	}
	
	@RequestMapping(value="/hello2",method=RequestMethod.POST)
	public String hello2(){
		return "index";
	}
	
	@RequestMapping(value="/hello3",params={"username"})
	public String hello3(){
		return "index";
	}
	
	@RequestMapping(value="/hello4/*")
	public String hello4(){
		return "index";
	}
	
	@RequestMapping(value="/hello5/{id}",method=RequestMethod.DELETE)
	public String hello5(@PathVariable("id") int id){
		System.out.println(id);
		return "index";
	}
	
	@RequestMapping(value="/hello6")
	public String hello6(User user){
		System.out.println(user);
		return "index";
	}
	
	@RequestMapping(value="/hello7")
	public String hello7(HttpServletRequest request){
		return "index";
	}
	
	@RequestMapping(value="/hello8")
	public ModelAndView hello8(){
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("time", new Date());
		return mav;
	}
	
	@RequestMapping(value="/hello9")
	public String hello9(Model model){
		model.addAttribute("names", Arrays.asList("abc","bcd","def"));
		System.out.println(Arrays.asList("abc","bcd","def").toString());
		return "index";
	}
	
	
/*	@ModelAttribute
	public void getUser(Model model){
		System.out.println("OK");
		User user = new User();
		user.setUsername("user");
		user.setPassword("123");
		model.addAttribute("aaa",user);
	}*/
	
	
	@RequestMapping(value="/hello10")
	public String hello10(User user,Model model){
		System.out.println(user);
		//model.addAttribute("user",user);
		return "index";
	}
	
	@RequestMapping(value="/hello11")
	public String hello11(User abc,Model model){
		System.out.println(abc);
		model.addAttribute("user",abc);
		return "index";
	}
	
	@RequestMapping("/hello12")
	public String hello12(){
		return "helloView";
	}
	
	@RequestMapping("/hello13")
	public String hello13(){
		return "redirect:/view/index.jsp";
	}
	
	@RequestMapping("/hello14")
	public String hello_converter(@RequestParam("employee")Employee employee){
		System.out.println("handler!!");
		System.out.println(employee);
		return "index";
	}
	
	@RequestMapping("/hello15")
	public String hello_formmat(@Valid Student student,BindingResult result){
		if(result.getErrorCount()>0){
			//转化或校验出错
			for(FieldError error : result.getFieldErrors()){
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
			return "index";
		}
		
		System.out.println(student);
		return "index";
	}
}
