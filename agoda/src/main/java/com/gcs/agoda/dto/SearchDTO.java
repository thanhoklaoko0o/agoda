package com.gcs.agoda.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 17, 2019	
 *@version 1.0
 */
@Setter
@Getter
public class SearchDTO {

	private int type;
	private int max_person;
	private String value;
	private LocalDate startDate;
	private LocalDate endDate;
	private int page;
	private int sizePage;
}
