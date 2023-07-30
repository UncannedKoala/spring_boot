package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")					//all the mapping will be prefixed with the passed parameter
public class ProductController {
	
}
