package com.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String redirectToHome() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model, @RequestParam(defaultValue = "true") boolean studentsVisible,
			@RequestParam(defaultValue = "true") boolean employeesVisible,
			@RequestParam(defaultValue = "true") boolean weightManagementVisible,
			@RequestParam(defaultValue = "true") boolean moviesCatalogVisible,
			@RequestParam(defaultValue = "true") boolean calculatorVisible,
			@RequestParam(defaultValue = "true") boolean buyingStocksVisible,
			@RequestParam(defaultValue = "true") boolean sellingStocksVisible) {

		model.addAttribute("studentsVisible", studentsVisible);
		model.addAttribute("employeesVisible", employeesVisible);
		model.addAttribute("weightManagementVisible", weightManagementVisible);
		model.addAttribute("moviesCatalogVisible", moviesCatalogVisible);
		model.addAttribute("calculatorVisible", calculatorVisible);
		model.addAttribute("buyingStocksVisible", buyingStocksVisible);
		model.addAttribute("sellingStocksVisible", sellingStocksVisible);

		return "home";
	}
}