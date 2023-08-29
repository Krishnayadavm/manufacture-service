package com.manufacture.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manufacture.manage.entity.ManufacturerEntity;
import com.manufacture.manage.model.ManufacturerModel;
import com.manufacture.manage.service.ManufactureService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/manufacture")

public class manufactureController {

	@Autowired
	private ManufactureService manufactureService;

	@PostMapping("/create")
	public void createManufacture(@Valid @RequestBody ManufacturerModel manufacturerModel) {
		manufactureService.createManufacture(manufacturerModel);
	}

	@PutMapping("/update")
	public void updateManufacture(@Valid @RequestBody ManufacturerModel manufacturerModel) {
		manufactureService.updateManufacture(manufacturerModel);
	}

	@DeleteMapping("/delete/{manufacturerId}")
	public void deleteManufacture(@PathVariable int manufacturerId) {
		manufactureService.deleteManufacture(manufacturerId);
	}

	@GetMapping("/findBymanufacturerId/{manufacturerId}")
	public ManufacturerModel findBymanufacturerId(@PathVariable int manufacturerID) {
		return manufactureService.findBymanufacturerId(manufacturerID);
	}

}
