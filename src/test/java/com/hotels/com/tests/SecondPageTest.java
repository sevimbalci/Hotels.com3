package com.hotels.com.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.com.base.BasePage;
import com.hotels.com.pages.HomePage;
import com.hotels.com.pages.SecondPage;
import com.util.Constants;

public class SecondPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	SecondPage secondPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		secondPage = new SecondPage(driver);
		secondPage.getHomePage();
	}
	@Test(priority=1)
	public void verifySecondPageTitle(){
		String title=secondPage.getSecondPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.SECOND_PAGE_TITLE);
	}
	@Test(priority=2)
	public void fiveStarCloserThanTenMile() throws InterruptedException{
		secondPage.selectFiveStar();
		secondPage.closerThanTenMile();
	}
	@Test(priority=3)
	public void fourStarCloserThanTenMiles() throws InterruptedException{
		secondPage.selectFourStar();
		secondPage.closerThanTenMile();
	}
	@Test(priority=4)
	public void threeStarCloserThanTenMile() throws InterruptedException{
		secondPage.selectThreeStar();
		secondPage.closerThanTenMile();
	}
	@Test
	public void selectHotelCloserThanTenMile() throws InterruptedException{
		secondPage.enterHotelName();
		secondPage.closerThanTenMile();
	}
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}
