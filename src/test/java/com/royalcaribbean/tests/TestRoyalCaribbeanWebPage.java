package com.royalcaribbean.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.royalcaribbean.classes.BookNowPage;
import com.royalcaribbean.classes.ResultsPage;
import com.royalcaribbean.classes.TextResultPage;
import com.royalcaribbean.utilities.TestCases;

//Test Class to run the entire website of RoyalCaribbean
public class TestRoyalCaribbeanWebPage {
	// Created a list to store all the testcases which are executed
	public List<String> testCases = new ArrayList<>();
	public WebDriver driver;

// To Execute the driver
	@BeforeClass
	@Parameters({ "browser" })
	void setup(String br) {
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		//Added implicit weight to the driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		//To make the driver open the website 
		
		driver.get("https://www.royalcaribbean.com/alaska-cruises");
		testCases.add("Website Opened Successfully");
	}

//To check the bookNow page
	@Test(priority = 1)
	void testBookNow() {
		BookNowPage bnp = new BookNowPage(driver);
		
		WebElement elem=bnp.getSearchOption();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// To check whether the search icon is visible
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(elem)).isDisplayed());
		boolean searchOptionClicked = bnp.clickSearchOption();
		Assert.assertTrue(searchOptionClicked);
		testCases.add("Search Option is visible");
		bnp.setSearchBar("Rapsody of the Seas");
		testCases.add("Entered 'Rapsody of the Seas' successfully");
		// Handling pop up which appears on the page
		try {
			WebElement img = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']/child::img")));
			// if
			// (driver.findElement(By.xpath("//div[@role='dialog']/child::img")).isDisplayed())
			// {
			if (img.isDisplayed()) {
				System.out.println("Image displayed:: "
						+ driver.findElement(By.xpath(("//div[@role='dialog']/child::img"))).isDisplayed());
				// driver.findElement(By.xpath("//div[@class='notification-banner__close']")).click();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						driver.findElement(By.xpath("//div[@class='notification-banner__section-close']")));
				System.out.println("Adv Closed");
				testCases.add("Advertisement Closed Successfully");
			}
		} catch (Exception e) {

		}
		// To click the search button
		testCases.add("Clicked Search Button");
		Assert.assertTrue(bnp.clickSearch());

	}

	// To click the First Result which appears on the page
	@Test(priority = 2)
	void testTextResultPage() {
		TextResultPage trp = new TextResultPage(driver);
		testCases.add("Clicked First Result Successfully");
		Assert.assertTrue(trp.clickFirstResult());

	}

	// To click the bookNow button
	@Test(priority = 3)
	void testClickBookNow() {
		BookNowPage bnp = new BookNowPage(driver);
		bnp.clickBookNowBtn();
		testCases.add("Book Now Button is clicked Successfully");
	}

	// To test the Result Page
	@Test(priority = 4)
	void testResultPage() throws InterruptedException {

		ResultsPage rp = new ResultsPage(driver);
		rp.clickCruiseDates();
		testCases.add("Clicked Cruise Option Sucessfully");
		rp.selectCruiseOptions();
		testCases.add("Selected available options");
		rp.clickDeparturePort();
		testCases.add("Clicked Departure Option Sucessfully");
		rp.selectDepartureOption();
		testCases.add("Selected available options");
		rp.clickNoOfNights();
		testCases.add("Clicked NoOfNights Option Sucessfully");
		rp.selectNoOfNights();
		testCases.add("Selected available NoOfNights option successfully");
		rp.clickResultbtn();
		testCases.add("Clicked Show Result Button Sucessfully");
		rp.clickSortBy();
		testCases.add("Clicked Sort By Option successfully");
		rp.sortByOptions();
		testCases.add("Clicked option Lowest To Highest Sucessfully");

		String result = rp.searchResult();

		System.out.println("Cruise Search Results are:: " + result);
		testCases.add("Cruise Search Results are:: " + result);

	}

	// To close the driver and to write all the testcases in excel file
	@AfterClass
	void tearDown() {
		try {
			TestCases.writeTestCase(testCases);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
