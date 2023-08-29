package com.manufacture.manage.model;

import java.time.LocalDate;
import java.util.List;

import com.manufacture.manage.entity.AddressEntity;
import com.manufacture.manage.entity.ContactEntity;

import jakarta.validation.constraints.NotBlank;

public class ManufacturerModel {
	
	private int manufacturerId;
	@NotBlank(message="company name should not be null")
	private String companyName;
	private String registrationNumber;
	private LocalDate registrationDate;
	@NotBlank(message="discription should not be null")
	private String description;
	
	private AddressModel addressModel;
	private List<ContactModel> contactModelList;

	public ManufacturerModel() {
		super();
	}

	public ManufacturerModel(int manufacturerId, String companyName, String registrationNumber,
			LocalDate registrationDate, String description, AddressModel addressModel,
			List<ContactModel> contactModelList) {
		super();
		this.manufacturerId = manufacturerId;
		this.companyName = companyName;
		this.registrationNumber = registrationNumber;
		this.registrationDate = registrationDate;
		this.description = description;
		this.addressModel = addressModel;
		this.contactModelList = contactModelList;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressModel getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

	public List<ContactModel> getContactModelList() {
		return contactModelList;
	}

	public void setContactModelList(List<ContactModel> contactModelList) {
		this.contactModelList = contactModelList;
	}

	@Override
	public String toString() {
		return "ManufacturerModel [manufacturerId=" + manufacturerId + ", companyName=" + companyName
				+ ", registrationNumber=" + registrationNumber + ", registrationDate=" + registrationDate
				+ ", description=" + description + ", addressModel=" + addressModel + ", contactModelList="
				+ contactModelList + "]";
	}

	}
