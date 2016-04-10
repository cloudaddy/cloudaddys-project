package edu.neu.cloudaddy.service;

import java.util.ArrayList;

import edu.neu.cloudaddy.model.Report;

public interface ReportService {

	ArrayList<Report> getReportService(int userID);
	Report getFileContentService(String repoName);
	void deleteFileService(String repoId);
}
