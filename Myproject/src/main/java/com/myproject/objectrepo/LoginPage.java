package com.myproject.objectrepo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.basepackage.BasicSetup;

public class LoginPage extends BasicSetup {
	@FindBy(id="user-name")
	WebElement username_textarea;
	@FindBy(xpath="//input[@id='password']")
	WebElement password_textarea;
	@FindBy(id="login-button")
	WebElement login_btn;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public SelectProduct login(String uname,String pwd) {
		username_textarea.sendKeys(uname);
		password_textarea.sendKeys(pwd);
		login_btn.click();
		String actual_url=driver.getCurrentUrl();
		String expected_url="https://www.saucedemo.com/inventory.html";
		assertEquals(actual_url, expected_url);
		System.out.println("Application loged in successesfully");
		return new SelectProduct();
	}
}
