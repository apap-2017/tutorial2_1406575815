package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	/* 
	 * Redundant Path 
	 * */
//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}

	@RequestMapping(value = { "/greeting", "/greeting/{name}" })
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	/*
	 * Perhitungan sebagai Integer, menyesuaikan dengan screen shot requirement
	 * @param a = double atau int
	 * @param b = double atau int
	 */
	@RequestMapping("/perkalian")
	public String greeting(@RequestParam(value = "a", required = false, defaultValue = "0") String a,
			@RequestParam(value = "b", required = false, defaultValue = "0") String b,
			Model model) {
		try {
			int intA = (int) Double.parseDouble(a);
			int intB = (int) Double.parseDouble(b);
			
			model.addAttribute("a", intA);
			model.addAttribute("b", intB);
			model.addAttribute("hasil", intA*intB);
			return "perkalian";			
		}
		catch (Exception e) {
			return "perkalian_error_param";
		}
	}
}