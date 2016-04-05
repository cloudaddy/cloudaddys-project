package edu.neu.cloudaddy.model;

public class Reports {

	String username;
	String reportName;
	String name;
	String type;
	String created_on;
	
	public Reports(String username, String reportName, String name,
			String type, String created_on) {
		//super();
		this.username = username;
		this.reportName = reportName;
		this.name = name;
		this.type = type;
		this.created_on = created_on;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	
	
	
	
}
