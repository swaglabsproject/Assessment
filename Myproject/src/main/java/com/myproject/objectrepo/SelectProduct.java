package com.myproject.objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.basepackage.BasicSetup;

public class SelectProduct extends BasicSetup {
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	WebElement product_name;
	public SelectProduct() {
		PageFactory.initElements(driver, this);
	}
	public ProductPage productselection() {
		product_name.click();
		return new ProductPage();
	}

}
