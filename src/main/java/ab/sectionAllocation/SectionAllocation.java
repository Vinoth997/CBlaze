package ab.sectionAllocation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import a.Base.Baseclass;

public class SectionAllocation extends Baseclass {

	public SectionAllocation() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' New Section Allocation']")
	WebElement newsectionallot;

	@FindBy(xpath = "//span[@id='select2-standard_id-container']")
	WebElement standardType;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchstd;
	@FindBy(xpath = "//option[text()='LKG']")
	WebElement lkg;

	@FindBy(xpath = "(//input[@class='search-input form-control'])[1]")
	WebElement searchstu;

	@FindBy(id = "select2-group_section_id-container")
	WebElement selectsectype;

	@FindBy(id = "//li[contains(text(),'B')]")
	WebElement selectsecb;

	@FindBy(xpath = "//button[text()='Submit ']")
	WebElement submit;


	public void NewSection() {
		newsectionallot.click();

	}

	public void Standardtype() throws InterruptedException {
		standardType.click();
		searchstd.sendKeys("LKG", Keys.ENTER);

	}

	public void selectstudent() throws IOException {
		searchstu.click();
		searchstu.sendKeys(excelGetdata("Newadmissionstudent", 0, 2), Keys.ENTER);
		String sss = "(//span[contains(text(),'" + excelGetdata("Newadmissionstudent", 0, 2) + "')])[1]";
		System.out.println(sss);
		driver.findElement(By.xpath(sss)).click();

	}

	public void session() throws InterruptedException {
		selectsectype.click();
		searchstd.click();
		searchstd.sendKeys("B",Keys.ENTER);

	}

	public void Submit() {
		submit.click();

	}

	public void newSectionAllocation() throws IOException, InterruptedException {
		NewSection();
		Standardtype();
		selectstudent();
		session();
		Submit();
	}

}
