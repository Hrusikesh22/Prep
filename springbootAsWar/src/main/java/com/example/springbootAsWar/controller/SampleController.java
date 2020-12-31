package com.example.springbootAsWar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class SampleController {
	
	@RequestMapping("/test")
	public Map<String, String>  testController() {
		Map<String, String> map = new HashMap<>();
		map.put("key", "value");
		new gson();
		return map;
	}
}
