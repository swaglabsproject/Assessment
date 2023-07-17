package com.myproject.basepackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSetup {
	public static WebDriver driver;
	public static Properties pr;

	@BeforeSuite(alwaysRun= true)
	public void staticprop() throws IOException {
		pr = new Properties();
		File fi = new File("C:\\Users\\maruj\\eclipse-workspace\\Myproject\\properties\\pr.properties");
		BufferedReader br = new BufferedReader(new FileReader(fi));
		pr.load(br);
	}

	@BeforeTest(alwaysRun= true)
	public void launchbrowser() {
		String browsername = pr.getProperty("browser");
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		}
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
