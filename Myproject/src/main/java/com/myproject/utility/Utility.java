package com.myproject.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void screenshots(WebDriver driver,String screenshotname) throws IOException {
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination= new File("./Screenshots/"+screenshotname+".png");
		FileUtils.copyFile(source, destination);
		
		
	}
}
