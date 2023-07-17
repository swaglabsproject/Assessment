package com.myproject.objectrepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.basepackage.BasicSetup;

public class YourinfoPage extends BasicSetup {
	@FindBy(id="first-name")
	WebElement first_name;
	@FindBy(id="last-name")
	WebElement last_name;
	@FindBy(id="postal-code")
	WebElement pin_code;
	@FindBy(id="continue")
	WebElement continue_btn;
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	WebElement overview_tittle;
	public YourinfoPage() {
		PageFactory.initElements(driver, this);
	}
	public ProductFinalPage info() {
		String fname= pr.getProperty("firstname");
		String lname= pr.getProperty("lastname");
		String pin=pr.getProperty("postalcode");
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		pin_code.sendKeys(pin);
		continue_btn.click();
		Boolean pr_overview= overview_tittle.isDisplayed();
		assertTrue(pr_overview);
		System.out.println("Yor info added successesfully and navigated to overview page");
		return new ProductFinalPage();
	}
	

}
