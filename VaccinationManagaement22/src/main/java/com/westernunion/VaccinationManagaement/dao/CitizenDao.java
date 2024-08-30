package com.westernunion.VaccinationManagaement.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.westernunion.VaccinationManagaement.entity.Citizen;

public interface CitizenDao {

	Citizen getCitizen(int id);
	ArrayList<Citizen> getCitizens();
	Citizen save(Citizen theCustomer);
	Citizen deleteCitizen(int customerID);
	Citizen getFirstDose(int id, Date date, String vaccineName);
	Citizen getSecondDose(int id, Date date);
	Citizen getBoosterDose(int id, Date date);
	ArrayList<Citizen> getPartial();
	ArrayList<Citizen> getFully();

}
