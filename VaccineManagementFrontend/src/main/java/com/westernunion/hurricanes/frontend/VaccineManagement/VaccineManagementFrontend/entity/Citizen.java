package com.westernunion.hurricanes.frontend.VaccineManagement.VaccineManagementFrontend.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Citizen")
@SequenceGenerator(name="myCitizenSequence", sequenceName="citizen_sequence",initialValue=20,allocationSize=1)
@SecondaryTable(name = "Vaccine", pkJoinColumns = @PrimaryKeyJoinColumn(name = "citizen_id"))
public class Citizen 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myCitizenSequence")
	@Column(name="ID")
	private int id;
	
	@Column(name="AADHARNO")
	private String aadharNo;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="MIDDLENAME")
	private String middleName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATEOFBIRTH")
	private Date dateOfBirth;
	
	@Column(name="PHONENO")
	private String phoneNo;
	
	@Column(name="EMAIL")
	private String eMail;
	
	@Column(name ="VACCINENAME", table ="Vaccine")
	private String vaccineName;
	
	@Column(name ="FIRSTDOSE", table ="Vaccine")
	private Date firstDose;
	
	@Column(name ="SECONDDOSE", table ="Vaccine")
	private Date secondDose;
	
	@Column(name ="BOOSTERDOSE", table ="Vaccine")
	private Date BoosterDose;
	
	@Column(name ="STATUS", table ="Vaccine")
	private String status;

	public Citizen(int id, String aadharNo, String firstName, String middleName, String lastName, String gender,
			Date dateOfBirth, String phoneNo, String eMail, String vaccineName, Date firstDose, Date secondDose,
			Date boosterDose, String status) {
		super();
		this.id = id;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNo = phoneNo;
		this.eMail = eMail;
		this.vaccineName = vaccineName;
		this.firstDose = firstDose;
		this.secondDose = secondDose;
		BoosterDose = boosterDose;
		this.status = status;
	}

	public Citizen() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Date getFirstDose() {
		return firstDose;
	}

	public void setFirstDose(Date firstDose) {
		this.firstDose = firstDose;
	}

	public Date getSecondDose() {
		return secondDose;
	}

	public void setSecondDose(Date secondDose) {
		this.secondDose = secondDose;
	}

	public Date getBoosterDose() {
		return BoosterDose;
	}

	public void setBoosterDose(Date boosterDose) {
		BoosterDose = boosterDose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Citizen [id=" + id + ", aadharNo=" + aadharNo + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", phoneNo=" + phoneNo + ", eMail=" + eMail + ", vaccineName=" + vaccineName + ", firstDose="
				+ firstDose + ", secondDose=" + secondDose + ", BoosterDose=" + BoosterDose + ", status=" + status
				+ "]";
	}
	
	
}