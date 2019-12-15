package com.gcs.agoda.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.gcs.agoda.entity.HomestayEntity;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 15, 2019	
 *@version 1.0
 */
public interface IHomeStayService {

	List<HomestayEntity> findAll(Pageable pageable);
	List<HomestayEntity> findAll();
}
