package com.application.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;

//@RestController
@Controller
public class HomeController {

	@ResponseBody
	@GetMapping("/gogo")
	public String go() {
		System.out.println("utyhfvyivvt");
		return "go boy go";
	}

	/*
	 * http://localhost:8080/gogon/babushka
	 */
	@ResponseBody
	@GetMapping("/pathVariable/{nama}")
	public String pv(@PathVariable() String nama) {
		System.out.println("??????");
		return "go boy "+nama;
	}

	
	/* <URI>?name=value */
	/* only looks for value using name of variable("bimaNigam") accepted in the method*/
	@ResponseBody
	@GetMapping("/pathParam/{name}")
	public String pp(@PathParam("nono") String bimaNigam) {
		System.out.println("________");
		return "go boy "+bimaNigam;
	}
	
	
	/*
	 * @RequestParam("nono") the query should contain a value for this variable 
	 * named "nono"
	 */
	@ResponseBody
	@GetMapping("/requestParam/{name}")
	public String rp(@RequestParam("nono") String name) {
		System.out.println("||||||||");
		return "go boy "+name;
	}
	
	@ResponseBody
	@GetMapping("/readAllHeaders")
	public Map<String,String> readAllHeaders(@RequestHeader Map<String, String> headers, HttpServletResponse resp) {
		resp.setStatus(HttpServletResponse.SC_CREATED);
		return headers;
	}
	
	@ResponseBody
	@GetMapping("/dataFromHeader")
	public int dataFromHeader(@RequestHeader int age) {
		return age;
	}
	
	@ResponseBody
	@GetMapping("/addHeaders")
	public HttpServletResponse addHeaders(HttpServletResponse response) {
		response.addHeader("HeaderKey1", "headerValue1");
		response.addHeader("HeaderKey2", "headerValue2");
		response.addHeader("HeaderKey3", "headerValue3");
		return response;
	}
	
}
