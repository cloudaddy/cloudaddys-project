package edu.neu.cloudaddy.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.neu.cloudaddy.dao.ReportDao;
import edu.neu.cloudaddy.model.Report;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	DataSource dataSource;

	@Autowired
	ReportDao reportDao;

	@Override
	public ArrayList<Report> getReportService(int userID) {

		return reportDao.getReports(dataSource, userID);
	}

	@Override
	public Report getFileContentService(String repoName) {
		Report report = reportDao.getFileContent(dataSource, repoName);
		writefile(report.getReportName(), report.getAttached());
		return report;
	}

	public String writefile(String reportName, String fileContent) {
		try {
			Writer output = null;
			
			File index = new File("src/main/resources/tmp");
			
			if(!index.exists()){
				index.mkdir();
			}else{
				index = new File(getClass().getResource("/tmp//").getPath());
				String[] entries = index.list();
				for (String s : entries) {
					File currentFile = new File(index.getPath(), s);
					currentFile.delete();
				}

				File file = new File(getClass().getResource("/tmp//").getPath() + reportName);
				output = new BufferedWriter(new FileWriter(file));

				if(fileContent!=null){
					for(String content: fileContent.split("\n")){
						output.write(content + "\n");
					}
				}
				output.close();
				System.out.println("File has been written");
			}

		} catch (Exception e) {
			System.out.println("Could not create file");
		}
		return reportName;
	}

	@Override
	public void deleteFileService(String repoId) {
		reportDao.deleteFile(dataSource, repoId);
		
	}

}
