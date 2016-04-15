package edu.neu.cloudaddy.model;

public class User {

	int Id;
	String username;
	String password;
	
	public User(){
	}
	
	public User(String username, int id, String password){
		this.username = username;
		this.Id=id;
		this.password= password;
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
