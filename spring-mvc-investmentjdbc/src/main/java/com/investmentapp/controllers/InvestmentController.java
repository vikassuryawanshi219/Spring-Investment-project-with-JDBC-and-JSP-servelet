package com.investmentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.investmentapp.model.Investment;
import com.investmentapp.service.IInvestmentService;
@Controller
public class InvestmentController {
	@Autowired
	IInvestmentService investmentService;
	
	@RequestMapping("/")
	public String homePage(Model model) {
		List<Investment> investments= investmentService.getAll();
		model.addAttribute("investments",investments);
		return "index";
	}
	
	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/addForm")
	public String addFormPage() {
		return "addformpage";   //This is the file Name
	}

	@RequestMapping(value="/addInvestment", method=RequestMethod.POST)
	public String addInvestment(Investment investment) {
		investmentService.addInvestment(investment);
		return "admin"; 
	}
	
	@RequestMapping("/deleteForm")
	public String deleteFormPage() {
		return "deleteformpage";   //This is the file Name
	}
	
	@RequestMapping("/deleteInvestment")
	public String deleteInvestment(@RequestParam("planId")int planId) {
		investmentService.deleteInvestment(planId);
		return "admin"; 
	}
}
