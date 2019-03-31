package com.jlearn.Spring.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.jlearn.Spring.model.FilterBean;


/**
 * Dynamic Filtering.
 * 
 * @author MJ
 * Jan 11, 2019
 */
@RestController
public class HelloContainer {
	
	@GetMapping(path= "/filter", produces= "application/json")
	public MappingJacksonValue sayHello() {
		
		PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");	
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myfilter", filter);			
		MappingJacksonValue mapping = new MappingJacksonValue(new FilterBean("field1", "field2", "field3"));		
		mapping.setFilters(filterProvider);

		return mapping;
	}

}
