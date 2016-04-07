package edu.neu.cloudaddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import edu.neu.cloudaddy.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	Connection connection;
	ResultSet rs;
	
	@Override
	public User getUserId(DataSource dataSource, String username) {
		User user = new User();
		try {
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select u.id from users u, users_password p" +
							" where u.id = p.id and u.username =?;");
			query.setString(1,username);
			
			rs = query.executeQuery();
			rs.next();
			String Id = rs.getString("id");
		
			user.setId(Integer.parseInt(Id));
			user.setUsername(username);
			
			connection.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return user;
	}

}
