package com.jlearn.Spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jlearn.Spring.model.PersonV1;
import com.jlearn.Spring.model.PersonV2;

@RestController
public class versioningController {
	
	
	// URI versioning
	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Mayank Jain");
	}	
	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new PersonV2.Name("Mayank","Jain"));
	}
	
	
	//Request parameter versioning
	@GetMapping(value="/person", params="version=1")
	public PersonV1 getPersonV11() {
		return new PersonV1("Mayank Jain");
	}	
	@GetMapping(value="/person", params="version=2")
	public PersonV2 getPersonV21() {
		return new PersonV2(new PersonV2.Name("Mayank","Jain"));
	}
	
	
	
	//(custom) header
	@GetMapping(value="/person", headers="X-API-VERSION=1")
	public PersonV1 getPersonV12() {
		return new PersonV1("Mayank Jain");
	}
	
	@GetMapping(value="/person", headers="X-API-VERSION=2")
	public PersonV2 getPersonV22() {
		return new PersonV2(new PersonV2.Name("Mayank","Jain"));
	}
	
	
	//media type aka content negotiation	
	@GetMapping(value="/person", produces="application/app-v1+json")
	public PersonV1 getPersonV13() {
		return new PersonV1("Mayank Jain");
	}
	
	@GetMapping(value="/person", produces="application/app-v2+json")
	public PersonV2 getPersonV23() {
		return new PersonV2(new PersonV2.Name("Mayank","Jain"));
	}
	
}
