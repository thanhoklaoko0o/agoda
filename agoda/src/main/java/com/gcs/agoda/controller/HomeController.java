package com.gcs.agoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcs.agoda.apiresult.ApiResult;
import com.gcs.agoda.dto.SearchDTO;
import com.gcs.agoda.service.IHomeStayService;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 14, 2019	
 *@version 1.0
 */
@RestController
@RequestMapping("/homestay")
public class HomeController extends BaseController {

	@Autowired
	private IHomeStayService homeStayService;

	@PostMapping
	public ApiResult getResultSearch(@RequestBody SearchDTO searchDTO) {
		
		// Get page and sizePage
		PageRequest pageReq = PageRequest.of(searchDTO.getPage(), searchDTO.getSizePage());
		
		// Check parameter search
		if (searchDTO.getType() == 1) {
			ApiResult result = createResult(homeStayService.findAllByName(searchDTO, pageReq), 200);
			return result;
		}
			
		if (searchDTO.getType() == 2) {
			ApiResult result = createResult(homeStayService.findAllByDistrict(searchDTO, pageReq), 200);
			return result;
		}
		
		ApiResult result = createResult(homeStayService.findAllByCity(searchDTO, pageReq), 200);
		return result;
	}
}
