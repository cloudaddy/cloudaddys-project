package edu.neu.cloudaddy.service;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.neu.cloudaddy.model.Report;

public interface ReportService {

	ArrayList<Report> getReportService(int userID) throws SQLException;
	Report getFileContentService(String repoName) throws SQLException;
	void deleteFileService(String repoId) throws SQLException;
}
