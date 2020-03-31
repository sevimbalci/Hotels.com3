package com.hotels.com.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.hotels.com.base.BasePage;
import com.hotels.com.pages.HomePage;
import com.util.Constants;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		homePage=new HomePage(driver);
	}
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String title=homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void getReservationDetails() throws InterruptedException{
		homePage.reservationDetails();
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}
