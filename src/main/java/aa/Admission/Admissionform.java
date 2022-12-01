package aa.Admission;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import a.Base.Baseclass;

public class Admissionform extends Baseclass {

	public Admissionform() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Admission No ']")
	WebElement admissionid;

	@FindBy(xpath = "//span[@aria-labelledby='select2-admission_type_id-container']")
	WebElement admissiontype;

	@FindBy(xpath = "(//li[@role='treeitem'])[2]")
	WebElement preadmission;

	@FindBy(xpath = "//span[@id='select2-standard_id-container']")
	WebElement standarD;
	@FindBy(xpath = "//option[text()='LKG']")
	WebElement standardLKG;
	@FindBy(id = "first_name")
	WebElement firstname;
	@FindBy(id = "last_name")
	WebElement lastname;
	@FindBy(name = "dob")
	WebElement dob;
	@FindBy(id = "select2-gender_id-container")
	WebElement gender;
	@FindBy(xpath = "//li[text()='Male']")
	WebElement genderMale;
	@FindBy(id = "father_full_name")
	WebElement fathername;
	@FindBy(id = "mother_full_name")
	WebElement mothername;

	@FindBy(id = "select2-blood_group_id-container")
	WebElement blood;

	@FindBy(xpath = "//li[text()='A +ve ']")
	WebElement oplusgroup;

	@FindBy(id = "select2-religion_id-container")
	WebElement relegion;

	@FindBy(xpath = "//li[text()='Hindu']")
	WebElement religionhindu;
	@FindBy(id = "select2-nationality_id-container")
	WebElement nationality;
	@FindBy(xpath = "//li[text()='Indian ']")
	WebElement indian;
	@FindBy(id = "select2-mother_tongue_id-container")
	WebElement mothertongue;
	@FindBy(xpath = "//li[text()='Tamil']")
	WebElement tamil;

	@FindBy(xpath = "//span[@id='select2-medium_of_study_id-container']")
	WebElement mediamofstudy;

	@FindBy(xpath = "//li[text()='English']")
	WebElement englishmediam;

	@FindBy(xpath = "//span[@id='select2-previous_state_board_id-container']")
	WebElement stateboard;
	@FindBy(xpath = "//li[contains(text(),'CBSE')]")
	WebElement cbse;
	@FindBy(id = "select2-community_id-container")
	WebElement communitytype;
	@FindBy(xpath = "//li[text()='OC']")
	WebElement communityoc;
	@FindBy(xpath = "//span[@id='select2-caste_id-container']")
	WebElement castetype;
	@FindBy(xpath = "//li[text()='general']")
	WebElement castegeneral;

	@FindBy(id = "per_address")
	WebElement peraddres;

	@FindBy(xpath = "//span[@id='select2-per_country_id-container']")
	WebElement percountrytype;
	@FindBy(xpath = "//li[text()='United Arab Emirates']")
	WebElement percountryUAE;
	@FindBy(id = "select2-per_state_id-container")
	WebElement perstatetype;
	@FindBy(xpath = "//li[text()='Dubai']")
	WebElement perstateDubai;
	@FindBy(id = "res_address")
	WebElement resaddres;

	@FindBy(id = "select2-res_country_id-container")
	WebElement rescountrytype;
	@FindBy(xpath = "//li[text()='India']")
	WebElement rescountryindia;
	@FindBy(id = "select2-res_state_id-container")
	WebElement resstatetype;
	@FindBy(xpath = "//li[text()='Puducherry']")
	WebElement resstatePuducherry;

	@FindBy(id = "fa_mobile_no")
	WebElement phonenumber;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement submit;
	
	
	/* Filling all the datas in the preAdmission form */
	
	
	public void admissionId() throws IOException {
		String attribute = admissionid.getAttribute("value");
		excelPutdata("Newadmissionstudent", 0, 1, attribute);
		excelPutdata("Newadmissionstudent", 0, 2, "null");
	}



	public void admissionType() {
		admissiontype.click();
	}

	public void preAdmission() throws IOException {

		String s = excelGetdata("Newadmissionstudent", 1, 1);
		if (s.equalsIgnoreCase("Pre Admission")) {
			preadmission.click();
		} else if (s.equalsIgnoreCase("Admission Enquiry")) {
			preadmission.click();
		} else if (s.equalsIgnoreCase("Online Enquriy")) {
			preadmission.click();
		} else {
			System.out.println("check type");
		}

	}

	public void standard() throws IOException {
		standarD.click();
		standardLKG.click();
//		String s = excelGetdata("Newadmissionstudent", 3, 1);
//		System.out.println(s);
//		if (s.equalsIgnoreCase("LKG")) {
//			driver.findElement(standardLKG).click();
//		} else if (s.equalsIgnoreCase("UKG")) {
//			driver.findElement(standardLKG).click();
//		} else if (s.equalsIgnoreCase("6 STD")) {
//			driver.findElement(standardLKG).click();
//		} else {
//			System.out.println("check type");
//		}

	}

	public void studentName() throws IOException {
		firstname.sendKeys(excelGetdata("Newadmissionstudent", 5, 1));
		lastname.sendKeys(excelGetdata("Newadmissionstudent", 6, 1));
	}

	public void dOB() throws IOException {
//		driver.findElement(dob).sendKeys(excelGetdata("Newadmissionstudent", 9, 1));
		dob.sendKeys("11/05/2020");

	}

	public void Gender() throws IOException {
		gender.click();
		genderMale.click();

	}

	public void parentName() throws IOException {
		fathername.sendKeys(excelGetdata("Newadmissionstudent", 12, 1));
		mothername.sendKeys(excelGetdata("Newadmissionstudent", 13, 1));

	}

	public void bloodGroup() throws InterruptedException {
		blood.click();
		oplusgroup.click();

	}

	public void religion() {
		relegion.click();
		religionhindu.click();
	}

	public void Nationality() {
		nationality.click();
		indian.click();
	}

	public void MotherToungue() {
		mothertongue.click();
		tamil.click();
	}

	public void MediamofStudy() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "mediamofstudy");
//		Scrolljavascriptexecutor("down", admissionid);
		mediamofstudy.click();
		englishmediam.click();
	}

	public void stateBoard() {
		stateboard.click();
		cbse.click();
	}

	public void community() {
		communitytype.click();
		communityoc.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "castetype");

	}

	public void caste() throws InterruptedException {
		Thread.sleep(2000);
		castetype.click();
		castegeneral.click();

	}

	public void paraddress() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "percountrytype");
		peraddres.sendKeys("softsuave tamilnadu");
		percountrytype.click();
		percountryUAE.click();
		Thread.sleep(2000);
		perstatetype.click();
		perstateDubai.click();
	}

	public void resaddress() {
		resaddres.sendKeys("softsuave tamilnadu");
		rescountrytype.click();
		rescountryindia.click();
		resstatetype.click();
		resstatePuducherry.click();
	}

	public void phoneNumber() {
		phonenumber.sendKeys("8547958689");
	}

	public void submitform() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1750)", "submit");
		Thread.sleep(3000);
		submit.click();
	}

//	public void admissionstatus() throws InterruptedException {
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true)", preadmissoinstatus);
//		preadmissoinstatus.click();
//		Thread.sleep(3000);
//		preadmissoinstatusselected.click();
//		Thread.sleep(3000);
//		js.executeScript("arguments[0].scrollIntoView(true)", submitstatus);
//		Thread.sleep(3000);
//		submitstatus.click();
//		System.out.println("true");
//	}

	@FindBy(xpath = "//a[text()=' Back']")
	WebElement preadmissionback;

	public void preadmissionBack() {
		preadmissionback.click();
	}

	public void form() throws IOException, InterruptedException {
		admissionId();
		admissionType();
		preAdmission();
		standard();
		studentName();
		dOB();
		Gender();
		parentName();
		bloodGroup();
		religion();
		Nationality();
		MotherToungue();
		MediamofStudy();
		stateBoard();
		community();
		caste();
		paraddress();
		resaddress();
		phoneNumber();
		submitform();
	}

}
