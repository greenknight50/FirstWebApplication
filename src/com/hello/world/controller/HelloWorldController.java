package com.hello.world.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String welcomeMethod(Map map) {
		map.put("userName", "Ashraf");
		map.put("descText", "This is my first web mvc project.");
		return "welcome";
	}
	
	@RequestMapping("/greet")
	public String greetUser(Map map, @RequestParam("name") String name, @RequestParam("city") String city, @RequestParam("age") int age) {
		map.put("name", name);
		map.put("city", city);
		map.put("age", age);
		return "greet";
	}
	
	@RequestMapping("/greet/user/{name}/{city}/{age:.+}")
	@ResponseBody
	public String greetUser(Map map, @PathVariable("name") String name, @PathVariable("age") double age, @PathVariable("city") String city) {
		map.put("name", name);
		map.put("city", city);
		map.put("age", age);
		String returnVal = "<h3> Hello " + name + "</h3>";
		return returnVal;
	}
	
}
