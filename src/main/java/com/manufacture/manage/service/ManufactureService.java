package com.manufacture.manage.service;

import com.manufacture.manage.entity.ManufacturerEntity;
import com.manufacture.manage.model.ManufacturerModel;

public interface ManufactureService {
	public void createManufacture(ManufacturerModel manufacturerModel);

	public void updateManufacture(ManufacturerModel manufacturerModel);

	public void deleteManufacture(int manufacturerModel);

	public ManufacturerModel findBymanufacturerId(int manufacturerID);

}
