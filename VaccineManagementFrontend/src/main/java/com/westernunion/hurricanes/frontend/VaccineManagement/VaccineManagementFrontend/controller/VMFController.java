package com.westernunion.hurricanes.frontend.VaccineManagement.VaccineManagementFrontend.controller;
 
import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

import com.westernunion.hurricanes.frontend.VaccineManagement.VaccineManagementFrontend.entity.Citizen;
 
@Controller
public class VMFController {

	@GetMapping("/registeredcitizens")
	public String getCitizenDetails(Model theModelObj) {
		RestClient restClient = RestClient.create();
		String url = "http://localhost:8186/api/citizens";
		ArrayList<Citizen> citizens = restClient.get()
				.uri(url).retrieve()
				.body(new ParameterizedTypeReference<ArrayList<Citizen>>() {});
		System.out.print(citizens);
		theModelObj.addAttribute("citizenDetails", citizens);
		return "citizens";
	}
	@GetMapping("/showFormForadd")
	public String showFormForadd() {
		return "showFormForadd";
	}
	
	@GetMapping("/citizen-details/{citizen_id}")
	public String getSingleCitizen(@PathVariable int citizen_id,Model theModel) {
		RestClient restClient = RestClient.create();
		String url = "http://localhost:8186/api/citizens/{citizen_id}";
		Citizen citizen = restClient.get()
				.uri(url, citizen_id).retrieve()
				.body(Citizen.class);
		theModel.addAttribute("citizen",citizen);
		System.out.print(citizen);
		return "citizen-details";
	}
	
	@PostMapping("/saveCitizen")
	public String saveCitizen(@ModelAttribute("Customer") Citizen theCitizen) 
	{
		RestClient restClient = RestClient.create();
		String url = "http://localhost:8186/api/citizens";

		ResponseEntity<Void> response = restClient.post()
				  .uri(url)
				  .body(theCitizen)
				  .retrieve()
				  .toBodilessEntity();
		return null;
	}
}
