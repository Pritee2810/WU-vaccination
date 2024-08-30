package com.westernunion.VaccinationManagaement.dao;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.westernunion.VaccinationManagaement.controller.GenericException;
import com.westernunion.VaccinationManagaement.entity.Citizen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CitizenDaoImpl implements CitizenDao 
{
  private EntityManager entityManager;

public CitizenDaoImpl(EntityManager entityManager) 
{
	this.entityManager = entityManager;
}

@Transactional
public Citizen getCitizen(int id)
{
	Session currentSession=entityManager.unwrap(Session.class);
	Citizen theCitizen=currentSession.get(Citizen.class,id);
	return theCitizen;
}

@Transactional
@Override
public ArrayList<Citizen> getCitizens() {
	Session currentSession=entityManager.unwrap(Session.class);
	Query theQuery= currentSession.createQuery("from Citizen",Citizen.class);
	
	ArrayList<Citizen> citizenRecords= (ArrayList<Citizen>) theQuery.getResultList();
	
	return citizenRecords;
}

@Transactional
@Override
public Citizen save(Citizen theCitizen) 
{
	 Session currentSession=entityManager.unwrap(Session.class);
	 currentSession.saveOrUpdate(theCitizen);
	 return theCitizen;
}

@Transactional
@Override
public Citizen deleteCitizen(int cid) {
	Citizen citizenRecord=getCitizen(cid);

	Session currentSession=entityManager.unwrap(Session.class);
	Query theQuery=currentSession.createQuery("delete from Citizen where id=:citizenId");
	theQuery.setParameter("citizenId", cid);
	theQuery.executeUpdate();
	return citizenRecord;
}

@Transactional
@Override
public Citizen getFirstDose(int id, Date date, String vaccineName) 
{
	Session currentSession=entityManager.unwrap(Session.class);
	Citizen citizen=currentSession.get(Citizen.class,id);
	
	
		
		citizen.setFirstDose(date);
		citizen.setStatus("partial");
		citizen.setVaccineName(vaccineName);
	
		currentSession.saveOrUpdate(citizen);
		
		return citizen;
		
	}
	
	
	


@Transactional
@Override
public Citizen getSecondDose(int id, Date date) 
{
	// TODO Auto-generated method stub
	Session currentSession=entityManager.unwrap(Session.class);
	Citizen citizen=currentSession.get(Citizen.class,id);
	
    	// first ensure if the gap is 120 days
   
    	Date firstDose =citizen.getFirstDose();
    	java.time.LocalDate fd = firstDose.toLocalDate();
		java.time.LocalDate sd = date.toLocalDate();
		long daysDiff = fd.atStartOfDay().until(sd.atStartOfDay(), ChronoUnit.DAYS);
		
		if(daysDiff<120)
		{
			throw new GenericException("can't take second dose 120 days are yet not completed for citizen with id : "+id);
		}
    	
		citizen.setSecondDose(date);
		
		currentSession.saveOrUpdate(citizen);
		
		return citizen;
	
}

@Transactional
@Override
public Citizen getBoosterDose(int id, Date date) 
{
	Session currentSession=entityManager.unwrap(Session.class);
	Citizen citizen=currentSession.get(Citizen.class,id);
	
	
		// check gap of 120 days
		
		Date secondDose = citizen.getSecondDose();
    	java.time.LocalDate fd = secondDose.toLocalDate();
		java.time.LocalDate sd = date.toLocalDate();
		long daysDiff = fd.atStartOfDay().until(sd.atStartOfDay(), ChronoUnit.DAYS);
		
		if(daysDiff<120)
		{
			throw new GenericException("can't take booster dose since 120 days are yet not completed for previous dose for citizen with id : "+id);
		}
		
			citizen.setBoosterDose(date);
			citizen.setStatus("Full");
			currentSession.saveOrUpdate(citizen);
			
			return citizen;
			
		
	
	
	
}
@Transactional
@Override
public ArrayList<Citizen> getPartial() 
{
	// TODO Auto-generated method stub
	Session currentSession=entityManager.unwrap(Session.class);
     Query theQuery= currentSession.createQuery("from Citizen",Citizen.class);
	
	ArrayList<Citizen> citizens=(ArrayList<Citizen>) theQuery.getResultList();
	
	ArrayList<Citizen> citizen=new ArrayList<Citizen>();
	
	
	
	for(Citizen c : citizens)
	{
		if(c.getVaccineName()!=null)
		{
			if(c.getStatus().toLowerCase().equals("partial"))
			{
				citizen.add(c);
			}
		}
	}
	return citizen;
	
	
}

@Transactional
@Override
public ArrayList<Citizen> getFully() 
{
	ArrayList<Citizen> citizen=new ArrayList<Citizen>();
	
	Session currentSession=entityManager.unwrap(Session.class);
    Query theQuery= currentSession.createQuery("from Citizen",Citizen.class);
	
	ArrayList<Citizen> citizens=(ArrayList<Citizen>) theQuery.getResultList();
	
	for(Citizen c : citizens)
	{
		if(c.getVaccineName()!=null || c.getBoosterDose()!=null)
		{
			if(c.getStatus().toLowerCase().equals("full"))
			{
				citizen.add(c);
			}
		}
	}
	return citizen;
	// TODO Auto-generated method stub

}
  
  
}
