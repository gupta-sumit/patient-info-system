package com.pm.services;

import com.pm.domain.PatientDetails;
import com.pm.domain.Prescription;

public interface PatientInfoService {

	public void addNewPatient(PatientDetails patientDetails);
	
	public PatientDetails getPatientInfo(String patientId);
	
	public void addPrescription(String patientId, Prescription prescription);
}
