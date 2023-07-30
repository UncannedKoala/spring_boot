package com.application.controllers;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;



/*
 * # The following objects are provided by Spring as the method parameter whenever asked:
 *  request(HttpServletRequest)
 *  response(HttpServletResponse)
 *  header(@RequestHeader)		-> this may morph into whatever the type of parameter is
 * 
 * # When the single String parameter is passed to the @XXXMapping("..") it is taken as value for path attribute, but 
 *  when passing multiple attribute values each one has to be explicitly be define:
 * 		@GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
 * 
*/


/*
 * @RestController Is a convenience annotation that is itself annotated with @Controller and @ResponseBody
 */
//@RestController
@Controller
public class HomeController {

	/*
	 * @ResponseBody is an Annotation that indicates a method return value should be
	 * bound to the web response body. Supported for annotated handler methods.
	 */
	@ResponseBody
	/*
	 * @GetMapping annotation is an annotation that is itself annotated
	 * with @RequestMapping(method = RequestMethod.GET)
	 */
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
	
	/*
	 * # Reads all the headers from the Request using the
	 *  "@RequestHeaders Map<String, String>" as a parameter (this value is injected
	 *  by spring boot) and writes them into the HttpServletResponse.
	 * 
	 * # Annotation(@RequestHeaders) which indicates that a method parameter should be bound to a web
	 *  request header.
	 */
	@ResponseBody
	@GetMapping("/readAllHeaders")
	public Map<String,String> readAllHeaders(@RequestHeader Map<String, String> headers, HttpServletResponse resp) {
		resp.setStatus(HttpServletResponse.SC_CREATED);
		return headers;
	}
	
	/*
	 * out of many request headers the one with 'key' same as the variable name is
	 * used to initialize the particular variable value
	 */
	@ResponseBody
	@GetMapping("/dataFromHeader")
	public int dataFromHeader(@RequestHeader int age) {
		return age;
	}
	
	/* 
	 * Adding the custom Headers to the HttpServletResponse
	 */
	@ResponseBody
	@GetMapping("/addHeaders")
	public HttpServletResponse addHeaders(HttpServletResponse response) {
		response.addHeader("HeaderKey1", "headerValue1");
		response.addHeader("HeaderKey2", "headerValue2");
		response.addHeader("HeaderKey3", "headerValue3");
		return response;
	}
	
	/*
	 * # The following end point will send a file in the form of byte[] as a stream.
	 *
	 * # 'produces' attribute can be used to define the MIME tyoe of the response 
	 */ 
	@ResponseBody
	@GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] sendFile() {
		byte[] file = new byte[100];
//		file[0]=7;
//		file[1]=2;
//		file[2]=4;
//		file[3]=9;
		return file;
	}
	
}
