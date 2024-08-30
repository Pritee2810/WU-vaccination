package com.westernunion.VaccinationManagaement.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.westernunion.VaccinationManagaement.dao.CitizenDao;
import com.westernunion.VaccinationManagaement.entity.Citizen;


@RestController
@RequestMapping("/api")
public class CitizenController 
{
   
	private CitizenDao cDao;
	
	public CitizenController(CitizenDao cDao) {
		this.cDao = cDao;
	}
	
	@GetMapping("/citizens")
	public ArrayList<Citizen> getCitizens(){
		return cDao.getCitizens();
	}

	@GetMapping("/citizens/{id}")
	public Citizen getCitizen(@PathVariable int id)
	{
		Citizen citizen=cDao.getCitizen(id);
		if(citizen==null)
		{
			throw new CitizenNotFoundException("Customer doesn't exsisit with id : "+id);
		}
		return cDao.getCitizen(id);
	}
	
	@PostMapping("/citizens")
	public Citizen addCitizen(@RequestBody Citizen theCitizen) {
		theCitizen.setId(0);
		return cDao.save(theCitizen);
	}

	@PutMapping("/citizens")
	public Citizen updateCitizen(@RequestBody Citizen theCitizen) {
		return cDao.save(theCitizen);
	}

	@DeleteMapping("/citizens/{cid}")
	public Citizen deleteCitizen(@PathVariable int cid) 
	{
		Citizen citizen=cDao.getCitizen(cid);
		if(citizen==null)
		{
		throw new CitizenNotFoundException("Citizen doesn't exist with id : "+cid);	
		}
		else if(citizen.getBoosterDose()==null)
		{
			throw new GenericException("Citizen has not completed all vaccination who has id : "+cid);	
		}
		return cDao.deleteCitizen(cid);
	}
	
	@PostMapping("/citizens/updatestatus/{id}")
	public Citizen updateCitizen(@RequestBody  Map<String, Object> requestBody,@PathVariable int id)
	{
		
		Citizen citizen=cDao.getCitizen(id);
		if(citizen==null)
		{
			throw new CitizenNotFoundException("Customer doesn't exsisit with id : "+id);
		}
		String doseName=(String) requestBody.get("doseName");
		System.out.println(doseName);
		
		String vaccineName=(String) requestBody.get("vaccineName");
		if(vaccineName==null)
		{
			throw new GenericException("Please enter vaccine name as it is first dose of citizen : "+id);
		}
		 String dateString = (String) requestBody.get("Date"); // Example date string
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     if(dateString==null)
	     {
	    	 throw new GenericException("Please enter date for current dose for citizen with id : "+id);
	     }
	     java.util.Date utilDate=null;
		try {
			utilDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     Date date= new Date(utilDate.getTime());
	     
	     if(doseName.toLowerCase().equals("first"))
	     {
	    	 if(citizen.getFirstDose()!=null)
	    	 {
	    		 throw new GenericException("Already taken first dose for citizen with id : "+id);
	    	 }
	    	 return cDao.getFirstDose(id,date,vaccineName);
	     }
	     else if(doseName.toLowerCase().equals("second"))
	     {
	    	 if(citizen.getFirstDose()==null)
	    	 {
	    		 throw new GenericException("first dose not yet done for citizen with id  : "+id);
	    	 }
	    	 else if(citizen.getSecondDose()!=null)
	    	 {
	    		 throw new GenericException("Already taken second dose for citizen with id : "+id);
	    	 }
	    	 return cDao.getSecondDose(id,date);
	     }
	     else if(doseName.toLowerCase().equals("booster"))
	     {
	    	 if(citizen.getFirstDose()==null)
	    	 {
	    		 throw new GenericException("first dose not yet done for citizen with id  : "+id);
	    	 }
	    	 else if(citizen.getSecondDose()==null)
	    	 {
	    		 throw new GenericException("Already taken second dose for citizen with id : "+id);
	    	 }
	    	 else if(citizen.getBoosterDose()!=null)
	    	 {
	    		 throw new GenericException("Already taken booster dose for citizen with id : "+id);
	    	 }
	    	 else
	    	 {
	    		 return cDao.getBoosterDose(id, date);
	    	 }
	     }
	     else
	     {
	    	 throw new GenericException("Please enter propse dose name  and check with database");
	     }

		
	}
	
	@GetMapping("/citizens/getpartial")
	public ArrayList<Citizen> getPartial()
	{
		return cDao.getPartial();
	}
	
	@GetMapping("/citizens/getFully")
	public ArrayList<Citizen> getFully()
	{
		return cDao.getFully();
	}
	
}
