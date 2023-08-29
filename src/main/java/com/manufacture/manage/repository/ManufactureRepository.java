package com.manufacture.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manufacture.manage.entity.ManufacturerEntity;

@Repository
public interface ManufactureRepository extends JpaRepository<ManufacturerEntity, Integer>  {

}
