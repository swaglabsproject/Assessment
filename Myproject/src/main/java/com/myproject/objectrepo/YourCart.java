package com.myproject.objectrepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.basepackage.BasicSetup;

public class YourCart extends BasicSetup{
	@FindBy(xpath="//div[@class='cart_item_label']")
	WebElement item_price;
	@FindBy(id="continue-shopping")
	WebElement continue_shopingbtn;
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkout_btn;
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement remove_btn;
	@FindBy(xpath="//div[@class='cart_item']")
	WebElement entireproduct_details;
	@FindBy(xpath="//span[text()='Checkout: Your Information']")
	WebElement info_page;
	
	public YourCart() {
		PageFactory.initElements(driver, this);
	}
	public void pricedetails() {
		boolean price=item_price.isDisplayed();
		assertTrue(price);
		System.out.println("Product price details are displayed");
		
	}
	
	public YourinfoPage checkout() {
		checkout_btn.click();
		Boolean your_info=info_page.isDisplayed();
		assertTrue(your_info);
		System.out.println("After check out navigated to your onfo page");
		return new YourinfoPage();
		
	}

}
