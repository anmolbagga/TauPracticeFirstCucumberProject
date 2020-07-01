package com.tau.practice.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps

{
	private WebDriver driver;

	@Given("I am in the login page of the Para Bank Application")
	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anmol\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://parabank.parasoft.com/parabank/index.htm");
	}

	@When("I enter invalid credentials")
	public void i_enter_valid_credentials() {
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("username")).submit();
	}

	@Then("I see the error message")
	public void i_should_be_taken_to_the_Overview_page() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='error']")));
		driver.findElement(By.xpath("//p[@class='error']")).isDisplayed();
		System.out.println("Error is "+driver.findElement(By.xpath("//p[@class='error']")).getText());
		driver.quit();
	}

}
