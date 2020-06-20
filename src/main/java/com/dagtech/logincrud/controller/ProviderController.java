package com.dagtech.logincrud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dagtech.logincrud.entity.Provider;
import com.dagtech.logincrud.service.ProviderService;

@Controller
@RequestMapping("/providers")
public class ProviderController {
	
	private ProviderService providerService;
	
	public ProviderController(ProviderService pService) {
		providerService = pService;
	}
	
	@GetMapping("/showProviders")
	public String showProviders(Model model) {
		
		// display a provider list
		List<Provider> providers = providerService.findAll();
		
		model.addAttribute("providers", providers);
		
		return "/providers/provider-list";
	}
	
	@GetMapping("/providerForm")
	public String showProviderForm(Model model) {
		
		Provider provider = new Provider();
		
		model.addAttribute("provider", provider);
		
		return "/providers/provider-form";
		
	}
	
	@GetMapping("/updateProvider")
	public String updateProvider(@RequestParam("id") int id, Model model) {
		
		// update a provider on the list
		Provider provider = providerService.findById(id);
		
		model.addAttribute("provider", provider);
		
		return "/providers/provider-form";
		
	}
	
	@PostMapping("/save")
	public String saveProvider(@ModelAttribute("provider") Provider theProvider) {
		
		// save a provider created in the form
		providerService.save(theProvider);
		
		return "redirect:/providers/showProviders";	
	}
	
	@GetMapping("/deleteProvider")
	public String deleteProvider(@RequestParam("id") int id) {
		
		// delete a provider from the list
		providerService.delete(id);
		
		return "redirect:/providers/showProviders";
	}
	
	@GetMapping("searchProvider")
	public String searchProvider(@RequestParam("searchName") String searchName,
			                     Model model) {
		// search a provider
		List<Provider> providers = providerService.searchBy(searchName);
		
		model.addAttribute("providers", providers);
		
		return "/providers/provider-list";
	}
	
	
	

}
