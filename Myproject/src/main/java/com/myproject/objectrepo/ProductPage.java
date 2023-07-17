package com.myproject.objectrepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.basepackage.BasicSetup;

public class ProductPage extends BasicSetup {
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']/..//div[@class='inventory_details_desc large_size']")
	WebElement product_details;
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cart_symbol;
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement remove_btn;
	@FindBy(xpath="//span[text()='Your Cart']")
	WebElement cart_acttittle;
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement addtocart_btn;
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	public void productconfirmation() {
		Boolean product=product_details.isDisplayed();
		assertTrue(product);
		System.out.println("product details are displayed");
	}
	public YourCart viewcart() {
		addtocart_btn.click();
		cart_symbol.click();
	 Boolean urcart_page=cart_acttittle.isDisplayed();
		assertTrue(urcart_page);
		System.out.println("Navigated to cart page after selecting cart symbol");
		return new YourCart();
	}

}
