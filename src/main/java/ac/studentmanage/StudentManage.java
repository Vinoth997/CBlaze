package ac.studentmanage;

import java.awt.RenderingHints.Key;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import a.Base.Baseclass;

public class StudentManage extends Baseclass {

	public StudentManage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@type='search'])[1]")
	WebElement search;


	public void searcH() throws IOException {
		search.sendKeys(excelGetdata("Newadmissionstudent", 0, 2), Keys.ENTER);
	}
	
	public void studentList() throws IOException {
		searcH();

	}

}
