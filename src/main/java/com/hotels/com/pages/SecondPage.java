package com.hotels.com.pages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hotels.com.base.BasePage;
import com.util.Constants;
import com.util.ElementUtil;

public class SecondPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	
	By deal = By.id("hdr-deals");
	By fiveStar=By.id("f-star-rating-5");
	By fourStar=By.id("f-star-rating-4");
	By threeStar=By.id("f-star-rating-3");
	//constructor
	
	public SecondPage (WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public void getHomePage() throws InterruptedException{
		homePage=new HomePage(driver);
		homePage.reservationDetails();
	}
	public String getSecondPageTitle (){
		return elementUtil.waitForGetPageTitle(Constants.SECOND_PAGE_TITLE);
	}
	public void selectFiveStar() throws InterruptedException{
		driver.findElement(fiveStar);
		Thread.sleep(2000);
	}
	public void selectFourStar() throws InterruptedException{
		driver.findElement(fourStar).click();
		Thread.sleep(2000);
	}
	public void selectThreeStar() throws InterruptedException{
		driver.findElement(threeStar).click();
		Thread.sleep(2000);
	}
	public void enterHotelName() throws InterruptedException{
		WebElement hotelName=driver.findElement(By.id("f-name"));
		hotelName.sendKeys("Hilton");
		driver.findElement(By.id("f-name-cta")).click();
		Thread.sleep(5000);
	}
	public String closerThanTenMile(){
		List<WebElement> hotels = driver.findElements(By.xpath("//a[@class='property-name-link']"));
		List<WebElement> hotelDistances=driver.findElements(By.xpath("//ul[@class='property-landmarks']/li[1]"));
		List<String> allHotels= new ArrayList<String>();
		List<String> allHotelDistances=new ArrayList<String>();
//		String text;
		for (int i=0; i<hotels.size(); i++){
			String a = (hotels.get(i).getText());
			String b = (hotelDistances.get(i).getText());
			String tenMileIssue=" ".concat(b);
			String [] xyz = tenMileIssue.split(" ");
			double hotelDistance=Double.parseDouble(xyz[1]);
			if(hotelDistance<=10){
			System.out.println(a + " is closer than 10 mile");
//			text = a + " is closer than 10 mile";
//			System.out.println(text);
			}		
		}return null;
	}
}
