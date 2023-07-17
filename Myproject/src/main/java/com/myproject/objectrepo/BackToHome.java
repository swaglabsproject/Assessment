package com.myproject.objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.myproject.basepackage.BasicSetup;

public class BackToHome extends BasicSetup{
	@FindBy(xpath="//span[text()='Products']")
	WebElement pr_tittle;
	public BackToHome() {
		PageFactory.initElements(driver, this);
	}
	public void home() {
		String item_tittle=pr_tittle.getText();
		String exp_tittle="products";
		SoftAssert ref= new SoftAssert();
	    ref.assertEquals(item_tittle, exp_tittle, "intentionally failing the method for screenshots");
		
		
	}

}
