package ab.sectionallocationTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import a.Base.Baseclass;
import a.Base.LoginUser;
import aa.Admission.Admissiondashboard;
import aa.Admission.Admissionform;
import aa.Admission.PreAdmissionStatus;
import aa.Admission.Preadmissiontomainadmiddion;
import ab.sectionAllocation.SectionAllocation;

public class SectionAllocationTest extends Baseclass{
	
	
	@BeforeTest
	private void open() throws IOException, InterruptedException {
		browserOpen();
		new LoginUser().login();

	}

	@Test
	private void Session() throws IOException, InterruptedException {
		new Admissiondashboard().SessionAllogation();
		new SectionAllocation().newSectionAllocation();
		
	}


	@AfterMethod
	private void driverClose(ITestResult result) {
		try {
			failedMethodTakesscreenshot(result);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			excelWriteData("Exception", e1.toString());
			e1.printStackTrace();
		}
//		browserClose();
	}
}
