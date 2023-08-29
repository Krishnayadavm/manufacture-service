package com.manufacture.manage.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.manufacture.manage.entity.AddressEntity;
import com.manufacture.manage.entity.ContactEntity;
import com.manufacture.manage.entity.ManufacturerEntity;
import com.manufacture.manage.model.AddressModel;
import com.manufacture.manage.model.ContactModel;
import com.manufacture.manage.model.ManufacturerModel;

import io.swagger.v3.oas.annotations.info.Contact;

@Component
public class ManufacturerEntityMapper {

	public ManufacturerEntity modelToManufacturerEntity(ManufacturerModel manufacturerModel) {
		manufacturerModel.setManufacturerId(getId(manufacturerModel.getManufacturerId()));
		ManufacturerEntity manufacturerEntity = new ManufacturerEntity();
		BeanUtils.copyProperties(manufacturerModel, manufacturerEntity);
		manufacturerEntity.setAddressEntity(modelToAddressEntity(manufacturerModel.getAddressModel()));
		manufacturerEntity.setContactEntityList(modelToContactEntities(manufacturerModel.getContactModelList(),manufacturerEntity));
		return manufacturerEntity;
	}

	public AddressEntity modelToAddressEntity(AddressModel addressModel) {
		addressModel.setAddressId(getId(addressModel.getAddressId()));
		AddressEntity addressEntity = new AddressEntity();
		BeanUtils.copyProperties(addressModel, addressEntity);
		return addressEntity;
	}

	public ContactEntity modelToContactEntity(ContactModel contactModel,ManufacturerEntity manufacturerEntity) {
		contactModel.setContactId(getId(contactModel.getContactId()));
		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contactModel, contactEntity);
		return contactEntity;
	}

	public List<ContactEntity> modelToContactEntities(List<ContactModel> contactModels, ManufacturerEntity manufacturerEntitys) {
		return contactModels.stream().map(contactModel -> modelToContactEntity(contactModel,manufacturerEntitys))
				.collect(Collectors.toList());
	}

	public int getId(int id) {
		if (id <= 0) {
			id = UUID.randomUUID().hashCode();
		} else {
			throw new RuntimeException("id is not found" + id);
		}
		return id;
	}
}
