package com.myproject.objectrepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.basepackage.BasicSetup;

public class ProductFinalPage extends BasicSetup{
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
	WebElement total_price;
	@FindBy(xpath="//button[@id='finish']")
	WebElement finish_btn;
	@FindBy(xpath="//button[@id='cancel']")
	WebElement finalcancel_btn;
	public ProductFinalPage() {
		PageFactory.initElements(driver, this);
	}

	public Orderconfirmation finalpage() {
		Boolean fp=total_price.isDisplayed();
		assertTrue(fp);
		System.out.println("Final page contains product total price");
		finish_btn.click();
		return new Orderconfirmation();
	}

	
	

}
