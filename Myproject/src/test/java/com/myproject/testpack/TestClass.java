package com.myproject.testpack;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.myproject.basepackage.BasicSetup;
import com.myproject.objectrepo.BackToHome;
import com.myproject.objectrepo.LoginPage;
import com.myproject.objectrepo.Orderconfirmation;
import com.myproject.objectrepo.ProductFinalPage;
import com.myproject.objectrepo.ProductPage;
import com.myproject.objectrepo.SelectProduct;
import com.myproject.objectrepo.YourCart;
import com.myproject.objectrepo.YourinfoPage;
import com.myproject.utility.Utility;

public class TestClass extends BasicSetup{
	LoginPage lp;
	SelectProduct sp;
	ProductPage pp;
	YourCart yc;
	YourinfoPage yp;
	ProductFinalPage pfp;
	Orderconfirmation page;
	BackToHome bh;
	
	@Test(priority=1, groups={"smoke","sanity","regression"})
	public void homepagelogin() {
	 lp= new LoginPage();
	 String uname= pr.getProperty("username");
	 String pwd= pr.getProperty("password");
		lp.login(uname,pwd);
	}
	
	
	@Test(priority=2,groups= {"smoke","sanity"})
	public void productselection() {
		sp= new SelectProduct();
		sp.productselection();
	}
	@Test(priority=3,groups= {"smoke","retesting","sanity"})
	public void itempage() {
		pp= new ProductPage();
		pp.productconfirmation();
		pp.viewcart();
	}

	@Test(priority=4,groups= {"smoke","retesting"})
	public void cart() {
		yc= new YourCart();
		yc.pricedetails();
		
		yc.checkout();
	}
	@Test(priority=5,groups= {"smoke","sanity","regression"})
	public void yourinfo() {
        yp= new YourinfoPage();
		yp.info();
	}
	@Test(priority=6,groups= {"sanity","smoke"})
	public void prfinalpage() {
		pfp= new ProductFinalPage();
		pfp.finalpage();
	}
	@Test(priority=7,groups= {"smoke","retesting"})
	public void finalconfirmation() {
		page= new Orderconfirmation();
		page.cofirmationmsg();
	}
	@Test(priority=8,groups= "retesting")
	public void returnhomepage() {
		bh= new BackToHome();
		bh.home();
	}
	@AfterMethod(alwaysRun= true)
	public void ssonfailure(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			Utility.screenshots(driver, result.getName());
		}
	}
	
	@AfterTest(alwaysRun= true)
	public void teardown() {
		driver.close();
	}
	

}
