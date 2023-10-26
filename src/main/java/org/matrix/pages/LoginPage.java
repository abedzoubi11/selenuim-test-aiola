package org.matrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage{

	@FindBy(css = "input[name='username']")
	private WebElement userName;

	@FindBy(css = "input[name='password']")
	private WebElement password;

	@FindBy(css = "input[value='Log In']")
	private WebElement loginButton;


	public LoginPage() {
		PageFactory.initElements(driver, this);
	}


	//Method to enter username
	public void enterUsername(String user) {
		userName.sendKeys(user);
	}


	//Method to enter password
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	//Method to click on Login button
	public void clickLogin() {
		loginButton.click();
	}

}
