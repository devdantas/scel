package com.fatec.scel.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/")
public class IndexController {
	@GetMapping("/")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
}
