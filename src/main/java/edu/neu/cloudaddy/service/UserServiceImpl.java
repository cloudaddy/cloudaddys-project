package edu.neu.cloudaddy.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.cloudaddy.dao.UserDao;
import edu.neu.cloudaddy.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserIdService(String username) throws SQLException {
		return userDao.getUserId(dataSource, username);
	}

}
