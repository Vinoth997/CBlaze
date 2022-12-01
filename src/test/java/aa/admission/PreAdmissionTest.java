package aa.admission;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.*;

import a.Base.Baseclass;
import a.Base.LoginUser;
import a.Base.MyRetry;
import aa.Admission.Admissiondashboard;
import aa.Admission.Admissionform;
import aa.Admission.PreAdmissionStatus;
import aa.Admission.Preadmissiontomainadmiddion;
import ab.sectionAllocation.SectionAllocation;
import ac.studentmanage.StudentManage;

public class PreAdmissionTest extends Baseclass {

	@BeforeTest
	private void open() throws IOException, InterruptedException {
		browserOpen();
		new LoginUser().login();

	}

	// Creating a new preAdmission studewnt
	@Test(priority = 0)
	private void create_Preadmission() throws IOException, InterruptedException {
		new Admissiondashboard().Dashboard();
		new Admissiondashboard().newAdmission();
		new Admissionform().form();
		new Admissionform().preadmissionBack();

	}

	// Update the status for preadmission student from active to selected
	@Test(priority = 1)
	private void status_Update() throws IOException, InterruptedException {

		new PreAdmissionStatus().preadmissionsearch();
		new PreAdmissionStatus().editStudent();
		newTabhandle();
		new PreAdmissionStatus().admissionstatus();
		parentTabhandle();

	}

	// Updating the student from preadmission to mainadmisssion
	@Test(priority = 2)
	private void updated_Mainadmission() throws InterruptedException, IOException {
		Thread.sleep(2000);
		new Admissiondashboard().mainadmission();
		new Preadmissiontomainadmiddion().newmainadmissions();
		new Preadmissiontomainadmiddion().admissionumber();
		new Preadmissiontomainadmiddion().submitform();
	}

//	// Allocating the section for the new student
//	// Verifying the added student is student list
	@Test(priority = 3)
	private void section_Allocation() throws IOException, InterruptedException {
		Thread.sleep(2000);
		new Admissiondashboard().SessionAllogation();
		new SectionAllocation().newSectionAllocation();
		new Admissiondashboard().studentManage();
		new StudentManage().studentList();
		Thread.sleep(2000);
		browserClose();
	}

//	@AfterTest
//	private void driverClose(@NoInjection ITestResult result) throws Exception {
//
//		failedMethodTakesscreenshot(result);
////		browserClose();
//	}
}
