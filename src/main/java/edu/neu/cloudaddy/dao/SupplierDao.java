package edu.neu.cloudaddy.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Supplier;

public class SupplierDao {

	public ArrayList<Supplier> getSuppliers(DataSource dataSource){
		try {
            //Class.forName(driver).newInstance();
            Connection connection = dataSource.getConnection();
            query = conn.prepareStatement("insert into movies values(?,?,?,?,?);");
            query.setString(1, movie.getMovieName());
            query.setString(2, movie.getActor());
            query.setString(3, movie.getActress());
            query.setString(4, movie.getGenre());
            query.setString(5, movie.getYear());
            query.execute();
            conn.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);
            } 
		return null;
		
	}
}
