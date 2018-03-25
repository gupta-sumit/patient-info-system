package com.pm.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class PatientDetails {

	@Id
	private String id;
	
	private UserBasicInfo userBasicInfo;
	private List<Prescription> prescriptions;
	private List<LabReport> labReports;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}
	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public List<LabReport> getLabReports() {
		return labReports;
	}
	public void setLabReports(List<LabReport> labReports) {
		this.labReports = labReports;
	}
	
}
