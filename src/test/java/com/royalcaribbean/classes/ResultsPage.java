package com.royalcaribbean.classes;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.royalcaribbean.utilities.ExplicitWeight;

public class ResultsPage {
	WebDriver driver;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * By cruiseDatesBtn = By.xpath("//button[text()='Cruise dates']"); By
	 * departurePortBtn = By.xpath("//button[text()='Departure Port']"); By
	 * noOfNightsBtn = By.xpath("//button[text()='Number of nights']"); By
	 * seeResultBtn = By.xpath("//button[text()='See results']"); //By cruiseOptions
	 * = By.
	 * xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-colorPrimary MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-colorPrimary MuiButton-disableElevation styles__MonthButton-sc-e7674c24-5 gHuZrk month-button css-csbzia']"
	 * ); By cruiseOptions = By.xpath(
	 * "//div[contains(@class,'styles__MonthTile')]//button[not(contains(@class,'disabled'))]"
	 * ); By deptOpt = By.
	 * xpath("//div[@class='components__ButtonWrap-sc-6abd413c-1 gBFaFs']//button");
	 * By noOfNightOpt = By.xpath("//button[text()='6 - 8']"); By sortByBtn =
	 * By.xpath("//div[@data-testid=\"sort-by-results-dropdown\"]//button"); //By
	 * searchResult = By.
	 * xpath("//div[@class='MuiTypography-root MuiTypography-title2 styles__SectionTitle-sc-39a21b5e-5 jkpeMY css-13jcdqr']//descendant::span[2]"
	 * ); By searchResult =
	 * By.xpath("//*[@id=\"default\"]/div[2]/div[4]/div[1]/div/div[1]/div/span/span"
	 * ); //By searchResult = By.xpath(
	 * "/html/body/div[1]/div[3]/div/div/div[2]/div[4]/div[1]/div/div[1]/div/span/span"
	 * ); By sortByLowToHigh = By.xpath("//p[text()='Price lowest to highest']");
	 */
	// locators
	private @FindBy(xpath = "//button[text()='Cruise dates']") WebElement cruiseDatesBtn;
	private @FindBy(xpath = "//button[text()='Departure Port']") WebElement departurePortBtn;
	private @FindBy(xpath = "//button[text()='Number of nights']") WebElement noOfNightsBtn;
	private @FindBy(xpath = "//button[text()='See results']") WebElement seeResultBtn;
//	@FindBy(xpath = "//div[contains(@class,'styles__MonthTile')]//button[not(contains(@class,'disabled'))]")
//	List<WebElement> cruiseOptions;
	private @FindBy(xpath = "//div[text()='2026']/following::button[1]") WebElement janOption;
	private @FindBy(xpath = "//div[text()='2026']/following::button[2]") WebElement febOption;
	private @FindBy(xpath = "//div[text()='2026']/following::button[3]") WebElement marOption;
	private @FindBy(xpath = "//div[text()='2026']/following::button[4]") WebElement aprOption;
	private @FindBy(xpath = "//div[@class='components__ButtonWrap-sc-6abd413c-1 gBFaFs']//button") WebElement deptOpt;
	private @FindBy(xpath = "//div[@class = 'NightsSelector__OverPill-sc-c59cb1b1-2 hiorfi']//button") WebElement noOfNightOpt;
	private @FindBy(xpath = "//div[@data-testid=\"sort-by-results-dropdown\"]//button") WebElement sortByBtn;
	private @FindBy(xpath = "//*[@id=\"default\"]/div[2]/div[4]/div[1]/div/div[1]/div/span/span") WebElement searchResult;
	private @FindBy(xpath = "//p[text()='Price lowest to highest']") WebElement sortByLowToHigh;

	//actions
	
	// method to clickCruiseDates button
	public void clickCruiseDates() {
		// driver.findElement(cruiseDatesBtn).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", cruiseDatesBtn);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cruiseDatesBtn));
		WebElement element = ExplicitWeight.wait5Seconds(driver, cruiseDatesBtn);
		element.click();
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].click();",cruiseDatesBtn);

	}
	//method to clickDeparturePort button
	public void clickDeparturePort() {
		// driver.findElement(departurePortBtn).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", departurePortBtn);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(departurePortBtn));
//		element.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", departurePortBtn);
	}
	//method to clickNoOfNights button
	public void clickNoOfNights() {
		// driver.findElement(noOfNightsBtn).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", noOfNightsBtn);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(noOfNightsBtn));
//		element.click();

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", noOfNightsBtn);
	}
	//method to clickResult button button
	public void clickResultbtn() {
		seeResultBtn.click();
	}
	//method to clickSortBy button
	public void clickSortBy() {
		sortByBtn.click();
	}
	//select low to high option
	public void sortByOptions() {
		sortByLowToHigh.click();
	}
	//To select 4 cruise options
	public void selectCruiseOptions() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(cruiseOpt1)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(cruiseOpt2)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(cruiseOpt3)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(cruiseOpt4)).click();

//		driver.findElement(cruiseOpt1).click();
//		driver.findElement(cruiseOpt2).click();
//		driver.findElement(cruiseOpt3).click();
//		driver.findElement(cruiseOpt4).click();

//		int count = 0;
//		for (WebElement opt : cruiseOptions) {
//			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();", opt);
//			JavascriptExecutor js = (JavascriptExecutor) driver;

//			js.executeScript("arguments[0].scrollIntoView();", opt);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(opt));
//			WebElement element=ExplicitWeight.wait5Seconds(driver, opt);
//			element.click();
//			count++;
//			if (count >= 4) {
//				break;
//			}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", janOption);
		ExplicitWeight.wait5Seconds(driver, janOption).click();
		ExplicitWeight.wait5Seconds(driver, febOption).click();
		ExplicitWeight.wait5Seconds(driver, marOption).click();
		ExplicitWeight.wait5Seconds(driver, aprOption).click();

	}
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(cruiseOpt1));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(cruiseOpt2));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(cruiseOpt3));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(cruiseOpt4));
	
	//To select available departure option
	public void selectDepartureOption() {
		// driver.findElement(deptOpt).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", deptOpt);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(deptOpt));
//		WebElement element=ExplicitWeight.wait10Seconds(driver, searchResult);
		element.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",deptOpt);
	}
	
	// To select available NoOfNights option
	public void selectNoOfNights() {
		noOfNightOpt.click();
	}
	//To get the searchResult
	public String searchResult() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", searchResult);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		WebElement result =wait.until(ExpectedConditions.visibilityOf(searchResult));
		// WebElement result=ExplicitWeight.wait5Seconds(driver, searchResult);
		return searchResult.getText();
	}
}
