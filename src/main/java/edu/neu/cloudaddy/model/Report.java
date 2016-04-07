package edu.neu.cloudaddy.model;

public class Report {

	int Id;
	String userId;
	String reportName;
	String deleted;
	String attached;
	String created_on;
	String modified_on;
	String supplierName;
	
	
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getModified_on() {
		return modified_on;
	}
	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}
	public Report(){
		
	}
	public Report(int Id, String username, String reportName, String deleted,
					String attached, String created_on, 
					String supplierName,String modified_on) {
		//super();
		this.Id = Id;
		this.userId = username;
		this.reportName = reportName;
		this.created_on = created_on;
		this.modified_on =modified_on;
		this.deleted = deleted;
		this.attached = attached;
		this.supplierName = supplierName;
	}

	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getAttached() {
		return attached;
	}
	public void setAttached(String attached) {
		this.attached = attached;
	}
	public String getUsername() {
		return userId;
	}

	public void setUsername(String username) {
		this.userId = username;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}
