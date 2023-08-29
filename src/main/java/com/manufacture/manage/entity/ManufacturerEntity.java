package com.manufacture.manage.entity;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="manufacturer",schema= "manufacture_schema")
public class ManufacturerEntity {
	@Id
	@Column(name = "manufacturer_id")
	private int manufacturerId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "registration_number")
	private String registrationNumber;

	@Column(name = "registration_date")
	private LocalDate registrationDate;

	private String description;

	@OneToOne//(mappedBy = "manufacturer_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private AddressEntity addressEntity;

	@JsonManagedReference("manufacturer-contact")
	@OneToMany(mappedBy = "manufacturerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContactEntity> contactEntityList;

	public ManufacturerEntity() {
		super();
	}

	public ManufacturerEntity(int manufacturerId, String companyName, String registrationNumber,
			LocalDate registrationDate, String description, AddressEntity addressEntity,
			List<ContactEntity> contactEntityList) {
		super();
		this.manufacturerId = manufacturerId;
		this.companyName = companyName;
		this.registrationNumber = registrationNumber;
		this.registrationDate = registrationDate;
		this.description = description;
		this.addressEntity = addressEntity;
		this.contactEntityList = contactEntityList;
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

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public List<ContactEntity> getContactEntityList() {
		return contactEntityList;
	}

	public void setContactEntityList(List<ContactEntity> contactEntityList) {
		this.contactEntityList = contactEntityList;
	}


}
