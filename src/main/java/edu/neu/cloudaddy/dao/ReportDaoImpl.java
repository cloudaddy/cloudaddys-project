package edu.neu.cloudaddy.dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import edu.neu.cloudaddy.model.Report;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao {

	ResultSet rs;
	Connection connection;

	@Override
	public ArrayList<Report> getReports(DataSource dataSource, int userId)
			throws SQLException {
		ArrayList<Report> reports = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select r.Id, r.name, r.attachment, r.deleted, " +
							"r.created_on, r.modified_on, s.company from " +
							"reports r left join suppliers s on " +
							"r.supplier_id = s.id where userId =? "
							+ "and deleted = 'N' order by created_on desc LIMIT 50;");
			query.setInt(1, userId);
			// System.out.println("query : " + query);
			rs = query.executeQuery();

			while (rs.next()) {
				String name = rs.getString("r.name");
				String Id = rs.getString("r.Id");
				String attached = rs.getString("r.attachment");
				String deleted = rs.getString("r.deleted");
				String created_on = rs.getString("r.created_on");
				String modified_on = rs.getString("r.modified_on");
				String supplierName = rs.getString("s.company");
				Report report = new Report();
				report.setReportName(name);
				report.setId(Integer.parseInt(Id));
				report.setCreated_on(created_on);
				report.setModified_on(modified_on);
				report.setDeleted(deleted);
				report.setAttached(attached);
				report.setSupplierName(supplierName);

				reports.add(report);
			}
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			connection.close();
		}
		return reports;
	}

	@Override
	public Report getFileContent(DataSource dataSource, String repoId)
			throws SQLException {
		String content;
		Report report = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select name, attachment from reports where id =? "
							+ "and deleted = 'N';");
			query.setInt(1, Integer.parseInt(repoId));
			rs = query.executeQuery();
			rs.next();
			report = new Report();
			String reportName = rs.getString("name");
			Clob c = (Clob) rs.getClob("attachment");
			if (c != null) {
				content = c.getSubString(1, (int) c.length());
				report.setReportName(reportName);
				report.setAttached(content);
				System.out.println("content:" + content);

			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			connection.close();
		}
		return report;

	}

	@Override
	public void deleteFile(DataSource dataSource, String repoId)
			throws SQLException {
		try {
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("update reports set deleted = 'Y' where id=?");
			query.setInt(1, Integer.parseInt(repoId));
			query.execute();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			connection.close();
		}
	}

}