package com.gcs.agoda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcs.agoda.entity.HomestayEntity;
import com.gcs.agoda.service.IHomeStayService;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 14, 2019	
 *@version 1.0
 */
@RestController
@RequestMapping("/homestay")
public class HomeController {

	@Autowired
	private IHomeStayService homeStayService;

	@GetMapping("/getall")
	public List<HomestayEntity> inde() {
		
		return homeStayService.findAll();
	}

	@GetMapping("/{page}/{size}")
	public List<HomestayEntity> index(@PathVariable int page, @PathVariable int size) {
		
		return homeStayService.findAll(PageRequest.of(page, size));
	}
	
}
