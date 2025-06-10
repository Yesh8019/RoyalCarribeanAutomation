package com.royalcaribbean.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextResultPage {
	WebDriver driver;
	public TextResultPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//By firstResult=By.xpath("//div[@class='searchResult__base']/div//a[text()='Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises']");
	//@FindBy(xpath="//div[@class='searchResult__base']/div//a[text()='Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises']")WebElement firstResult;
	//Providing PageLocator using xpath to find the first element
	private @FindBy(xpath="//div[@class='searchResult__base']//a[text()='Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises']")WebElement firstResult;
	
	//Method to click the first result
	public boolean clickFirstResult()
	{
		firstResult.click();
		return true;
	}

	
}
