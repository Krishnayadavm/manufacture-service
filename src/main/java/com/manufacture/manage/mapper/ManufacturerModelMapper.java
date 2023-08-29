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

@Component
public class ManufacturerModelMapper {

	public ManufacturerModel entityToManufacturerModel(ManufacturerEntity manufacturerEntity) {
		manufacturerEntity.setManufacturerId(getId(manufacturerEntity.getManufacturerId()));
		ManufacturerModel ManufacturerModel = new ManufacturerModel();
		BeanUtils.copyProperties(manufacturerEntity, ManufacturerModel);
		ManufacturerModel.setAddressModel(entityToAddressModel(manufacturerEntity.getAddressEntity()));
		ManufacturerModel.setContactModelList(entityToContactModels(manufacturerEntity.getContactEntityList()));
		return ManufacturerModel;
	}

	public AddressModel entityToAddressModel(AddressEntity addressEntity) {
		addressEntity.setAddressId(getId(addressEntity.getAddressId()));
		AddressModel AddressModel = new AddressModel();
		BeanUtils.copyProperties(addressEntity, AddressModel);
		return AddressModel;
	}

	public ContactModel entityToContactModel(ContactEntity contactEntity) {
		contactEntity.setContactId(getId(contactEntity.getContactId()));
		ContactModel contactModel = new ContactModel();
		BeanUtils.copyProperties(contactEntity, contactModel);
		return contactModel;
	}

	public List<ContactModel> entityToContactModels(List<ContactEntity> contactEntities) {
		return contactEntities.stream().map(contactEntity -> entityToContactModel(contactEntity))
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
