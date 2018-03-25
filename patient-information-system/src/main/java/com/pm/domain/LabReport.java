package com.pm.domain;

import java.util.Date;

public class LabReport {

	private String id;
	private Date date;
	private DoctorDetails referredDoctor;
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
	public DoctorDetails getReferredDoctor() {
		return referredDoctor;
	}
	public void setReferredDoctor(DoctorDetails referredDoctor) {
		this.referredDoctor = referredDoctor;
	}
	public ProtectedDocument<DocumentList> getDocuments() {
		return documents;
	}
	public void setDocuments(ProtectedDocument<DocumentList> documents) {
		this.documents = documents;
	}
	
}
