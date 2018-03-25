package com.pm.domain;

import java.util.Date;

public class Prescription {

	private String id;
	private Date date;
	private DoctorDetails doctorDetails;
	private HospitalDetails hospitalDetails;
	private ProtectedDocument<DocumentList> documents;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DoctorDetails getDoctorDetails() {
		return doctorDetails;
	}
	public void setDoctorDetails(DoctorDetails doctorDetails) {
		this.doctorDetails = doctorDetails;
	}
	public HospitalDetails getHospitalDetails() {
		return hospitalDetails;
	}
	public void setHospitalDetails(HospitalDetails hospitalDetails) {
		this.hospitalDetails = hospitalDetails;
	}
	public ProtectedDocument<DocumentList> getDocuments() {
		return documents;
	}
	public void setDocuments(ProtectedDocument<DocumentList> documents) {
		this.documents = documents;
	}
	
}
