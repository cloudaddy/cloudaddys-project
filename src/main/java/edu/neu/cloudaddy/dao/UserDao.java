package edu.neu.cloudaddy.dao;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.User;

public interface UserDao {

	User getUserId(DataSource dataSource, String username);  
}
