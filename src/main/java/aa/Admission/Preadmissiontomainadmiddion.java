package aa.Admission;

import java.awt.RenderingHints.Key;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import a.Base.Baseclass;

public class Preadmissiontomainadmiddion extends Baseclass {

	public Preadmissiontomainadmiddion() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' New Main Admission']")
	WebElement newadmissionmain;

	@FindBy(id = "select2-admission_type-container")
	WebElement admissiontype;

	@FindBy(xpath = "(//li[@role='treeitem'])[2]")
	WebElement preadmission;
	@FindBy(id = "select2-preadmission_id-container")
	WebElement admissionnum;
	@FindBy(xpath = "//input[@type='search']")
	WebElement admissionnumber;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement  submit;
	
	@FindBy(xpath = "//input[@id='code']")
	WebElement  admissionno;
	
	@FindBy(id = "select2-third_language_id-container")
	WebElement thirdlanguage;

	public void newmainadmission() {
		newadmissionmain.click();

	}

	public void admissionType() {
		admissiontype.click();
	}

	public void preAdmission() {
		preadmission.click();

	}
	
	public void Admissionnumber() throws IOException, InterruptedException {
		admissionno.isDisplayed();
		Thread.sleep(4000);
		String attribute = admissionno.getAttribute("value");
		System.out.println(attribute);
		excelPutdata("Newadmissionstudent", 0, 2, attribute);

	}

	public void admissionumber() throws InterruptedException, IOException {
		admissionnum.click();
		Thread.sleep(1000);
		admissionnum.isDisplayed();
		admissionnumber.sendKeys(excelGetdata("Newadmissionstudent", 0, 1),Keys.ENTER);
		Admissionnumber();
	}
	
	public void submitform() throws InterruptedException {
		Scrolljavascriptexecutor("down", thirdlanguage);
		Scrolljavascriptexecutor("down", submit);
		submit.click();
	}

	public void newmainadmissions() throws InterruptedException {
		newmainadmission();
		admissionType();
		preAdmission();
		
		
	}
}
