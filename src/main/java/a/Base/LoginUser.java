package a.Base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUser extends Baseclass {

	public LoginUser() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user-name']")  	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")		WebElement password;

	@FindBy(xpath = "//button[@type='submit']")		WebElement login;

	public void login() throws IOException {

		try {
			username.sendKeys(excelGetdata("ENV &LOGIN", 8, 1));
			password.sendKeys(excelGetdata("ENV &LOGIN", 8, 2));
			login.click();
		} catch (Exception e) {
			takesScreenShot(username);
			takesScreenShotfull();
			
		}
	}

}
