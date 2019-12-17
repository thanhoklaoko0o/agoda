package com.gcs.agoda.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcs.agoda.dto.SearchDTO;
import com.gcs.agoda.entity.HomestayEntity;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 15, 2019	
 *@version 1.0
 */
@Repository
public interface HomeStayRepository extends JpaRepository<HomestayEntity, Integer>{

	@Query("SELECT h FROM HomestayEntity h WHERE h.name LIKE %:#{#s.value}%")
	List<HomestayEntity> findAllByName (@Param("s") SearchDTO searchDTO, Pageable pageable);

	@Query("SELECT h FROM HomestayEntity h JOIN DistrictEntity "
			+ "d on h.districtEntity = d.id WHERE d.name LIKE %:#{#s.value}%")
	List<HomestayEntity> findAllByDistrict (@Param("s") SearchDTO searchDTO, Pageable pageable);

	@Query("SELECT h FROM HomestayEntity h JOIN DistrictEntity "
			+ "d on h.districtEntity = d.id JOIN CityEntity c on "
			+ "d.cityEntity = c.id WHERE c.name LIKE %:#{#s.value}%")
	List<HomestayEntity> findAllByCity (@Param("s") SearchDTO searchDTO, Pageable pageable);
}
