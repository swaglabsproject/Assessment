package com.myproject.objectrepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.basepackage.BasicSetup;

public class Orderconfirmation extends BasicSetup{
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	WebElement order_confirmation;
	@FindBy(id ="back-to-products")
	WebElement backhome_btn;
	public Orderconfirmation() {
		PageFactory.initElements(driver, this);
	}
	public BackToHome cofirmationmsg() {
		Boolean pr_confirmation=order_confirmation.isDisplayed();
		assertTrue(pr_confirmation);
		System.out.println("Order placed successesfully");
		backhome_btn.click();
		return new BackToHome();
		
		
		
	}
	

}
