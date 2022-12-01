package aa.Admission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import a.Base.Baseclass;

public class Admissiondashboard extends Baseclass {

	public Admissiondashboard() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//li[@class='nav-item has-sub'])[1]")
	WebElement  studentdashboard;
	@FindBy(xpath = "//li[@id='manage-stu']")
	WebElement  studentdashboard1;

	@FindBy(xpath = "(//span[contains(text(),'Admission')])[2]")
	WebElement admission;

	@FindBy(xpath = "(//li[@id='manage-stu-admin-pre'])[2]")
	WebElement preadmission;
	
	@FindBy(xpath = "(//a[text()='Main Admission'])[2]")
	WebElement mainadmission;

	@FindBy(xpath = "(//li[@id='manage-stu-admin-pre-stu']//a[contains(text(),'Student List')])[2]")
	WebElement studentlist;

	@FindBy(xpath = "//a[text()=' New Pre Admission']")
	WebElement newadmission;
	
	@FindBy(xpath = "(//a[text()='Section Allocation'])[2]")
	WebElement sectionallocation;
	@FindBy(xpath = "(//span[text()='Student Manage'])[2]")
	WebElement  studentmanage;
	@FindBy(xpath = "(//a[text()='Student List'])[4]")
	WebElement  studentmanagelist;

	 By payrolldashboard = By.xpath("//span[text()='Payroll']");

	 
	 
	public  void Dashboard() throws InterruptedException {
		studentdashboard.click();
		admission.click();
		preadmission.click();
		studentlist.click();

	}
	public  void mainadmission() throws InterruptedException {
		studentdashboard1.click();
		Thread.sleep(1000);
		studentdashboard1.click();
		admission.click();
		mainadmission.click();
		
	}

	public  void newAdmission() {
		newadmission.click();	
	}
	public void SessionAllogation() {
		studentdashboard.click();
		studentdashboard1.click();
		admission.click();
		sectionallocation.click();

	}
	public  void studentManage() {

		studentdashboard.click();
		studentdashboard1.click();
		studentmanage.click();
		studentmanagelist.click();

	}
	

}