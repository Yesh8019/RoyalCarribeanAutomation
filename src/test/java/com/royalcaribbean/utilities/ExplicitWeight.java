package com.royalcaribbean.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWeight {
	//Explicit Weight Class
	
	//Method to wait for 5 seconds until the element is clickable
	public static WebElement wait5Seconds(WebDriver driver,WebElement elem)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
		return element;
	}
	
	//Method to wait for 10 seconds until the element is clickable
	public static WebElement wait10Seconds(WebDriver driver,WebElement elem)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
		return element;
	}

}
