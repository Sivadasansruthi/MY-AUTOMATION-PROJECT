package Utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Context.Constants;

public class ReportNG {
	
	static ExtentSparkReporter reporter;
public static ExtentReports generateReport() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.reportPath);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Demo WebShop");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Name", "Anjali");
		extent.setSystemInfo("Brand", "Demo WebShop");
		return extent;
	}

public static void loadXMLFIle() {
	try {
		reporter.loadXMLConfig(Constants.extentConfigFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
