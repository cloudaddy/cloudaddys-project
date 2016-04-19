package edu.neu.cloudaddy.service;

import java.sql.SQLException;

import edu.neu.cloudaddy.model.User;

public interface UserService {

	User getUserIdService(String username) throws SQLException;
}
