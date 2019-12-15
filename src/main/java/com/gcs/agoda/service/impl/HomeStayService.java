package com.gcs.agoda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gcs.agoda.entity.HomestayEntity;
import com.gcs.agoda.repository.HomeStayRepository;
import com.gcs.agoda.service.IHomeStayService;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 15, 2019	
 *@version 1.0
 */
@Service
public class HomeStayService implements IHomeStayService{

	@Autowired
	private HomeStayRepository homeStayService;

	@Override
	public List<HomestayEntity> findAll(Pageable pageable) {
		return homeStayService.findAll(pageable).getContent();
	}

	@Override
	public List<HomestayEntity> findAll() {
		return homeStayService.findAll();
	}

}
