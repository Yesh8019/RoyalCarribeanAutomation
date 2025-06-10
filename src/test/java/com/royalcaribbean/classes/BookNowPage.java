package com.royalcaribbean.classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookNowPage {
	WebDriver driver;
	public BookNowPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*
	By searchOption = By.xpath("//*[@id='rciSearchHeaderIcon']");
	By searchBar = By.xpath("//input[@id='rciSearchInput']");
	By searchInput = By.xpath("//div[@id=\"rciSearchInputIcon\"]");
	By bookNowButton = By.xpath("//a[@id=\"promoHeroCTAButton\"]");
	*/
	
	//Locators
	
	private @FindBy(xpath="//*[@id='rciSearchHeaderIcon']") WebElement searchOption;
	private @FindBy(xpath="//input[@id='rciSearchInput']") WebElement searchBar;
	private @FindBy(xpath="//div[@id=\"rciSearchInputIcon\"]") WebElement searchInput;
	private @FindBy(xpath="//a[@id=\"promoHeroCTAButton\"]") WebElement bookNowButton;
	
	//Actions 
	public WebElement getSearchOption()
	{
		return searchOption;
	}
	public boolean visibleSearchIcon()
	{
		return searchOption.isDisplayed();
	}
	public boolean clickSearchOption()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(searchOption)).click();
		
		
//		searchOption.click();
		return true;
	}
	public void setSearchBar(String text)
	{
		searchBar.sendKeys(text);
	}
	public boolean clickSearch()
	{
		searchInput.click();
		return true;
	}
	public void clickBookNowBtn() {
		bookNowButton.click();
		
	}
	
}
