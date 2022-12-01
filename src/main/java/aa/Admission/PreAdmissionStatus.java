package aa.Admission;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import a.Base.Baseclass;

public class PreAdmissionStatus extends Baseclass {

	public PreAdmissionStatus() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='ft-settings icon-pencil']")
	WebElement editstudent;
	@FindBy(xpath = "//span[@id='select2-status-container']")
	WebElement preadmissoinstatus;

	@FindBy(xpath = "//li[text()='Selected']")
	WebElement preadmissoinstatusselected;
	@FindBy(xpath = "//button[text()='Submit ']")
	WebElement submitstatus;

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	WebElement preadmissionscarch;

	/* Checking the preAdmission student changing the status */

	public void preadmissionsearch() throws IOException {
		preadmissionscarch.sendKeys(excelGetdata("Newadmissionstudent", 0, 1));
	}

	public void editStudent() {
		editstudent.click();

	}

	public void admissionstatus() throws InterruptedException {
		Scrolljavascriptexecutor("down", preadmissoinstatus);
		preadmissoinstatus.click();
		Thread.sleep(3000);
		preadmissoinstatusselected.click();
		Scrolljavascriptexecutor("down", submitstatus);
		submitstatus.click();
	}

}
