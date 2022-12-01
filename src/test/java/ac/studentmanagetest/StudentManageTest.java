package ac.studentmanagetest;

import java.io.IOException;

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
import ac.studentmanage.StudentManage;

public class StudentManageTest extends Baseclass {

	@BeforeTest
	private void open() throws IOException, InterruptedException {
		browserOpen();
		new LoginUser().login();

	}

	@Test
	private void studentmanage() throws IOException, InterruptedException {
		new Admissiondashboard().studentManage();
		new StudentManage().studentList();;
		
	}

	@AfterMethod
	private void driverClose(ITestResult result) throws Exception {

		failedMethodTakesscreenshot(result);
//		browserClose();
	}

}
