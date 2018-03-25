package com.pm.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.domain.PatientDetails;
import com.pm.domain.Prescription;

@RestController
@RequestMapping("/patient")
public class PatientInfoController {

	@PutMapping
	public void addPatient(PatientDetails patientDetails) {
		
	}
	
	public void addPrescription(Prescription prescription) {
		
	}
	
	
}
