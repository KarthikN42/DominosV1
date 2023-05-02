package com.domi.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.domi.testCases.BaseClass;
import com.domi.utilities.Constants;

public class dominosPage extends BaseClass implements Constants {
	WebDriver driver;

	public dominosPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='online-banner']/div/a/button")
	WebElement orderOnlineClick;

	@FindBy(xpath = "//input[@class='srch-cnt-srch-inpt']")
	WebElement location;

	@FindBy(xpath = "//*[@class='overlay']//following::input[3]")
	WebElement locationInput;

	@FindBy(xpath = "//*[@class='suggestions']/following::ul/li//span")
	WebElement suggestion;

	@FindBy(xpath = "//*[@id='desktopBannerWrapped']//button[1]")
	WebElement alertDismiss;

	@FindBy(xpath = "//*[@class='mn-hdr hide'][@data-label='Veg Pizza']//span")
	WebElement vegPizza;

	@FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Margherita']//span[contains(text(),'ADD TO CART')]") // *[@data-label='Margherita']/following::button[last()]/span
	WebElement Margherita;

	@FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Caprese Gourmet Pizza']//span[contains(text(),'ADD TO CART')]")
	WebElement gourmetPizza;

	@FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Caprese Gourmet Pizza']//div[@data-label='increase']")
	WebElement gourmetPizzaINC;

	@FindBy(xpath = "//*[@data-label='Add button']//span")
	WebElement noThanksBTN;

	@FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Margherita']//div[@data-label='increase']")
	WebElement MargheritaIncrement;

	@FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Margherita']//div[@data-label='decrease']")
	WebElement MargheritaDecrement;

	@FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Peppy Paneer']//span[contains(text(),'ADD TO CART')]")
	WebElement peppypaneer;

	@FindBy(xpath = "//div[@data-label='Veg Pizza']//div[@data-label='Peppy Paneer']//div[@data-label='increase']")
	WebElement peppyIncrement;

	@FindBy(xpath = "//*[@class='rupee sb-ttl']")
	WebElement total;

	@FindBy(xpath = "//*[@class='mn-hdr hide'][@data-label='Beverages']/span")
	WebElement Beverages;

	@FindBy(xpath = "//div[@data-label='Pepsi 475ml']//button[@data-label='addTocart']")
	WebElement pepsi;

	@FindBy(xpath = "//div[@data-label='Pepsi 475ml']//div[@class='injectStyles-sc-1jy9bcf-0 gwKvJy']")
	WebElement pepsiIncrement;

	@FindBy(xpath = "//div[@data-label='Pepsi 475ml']//div[@data-label='decrease']")
	WebElement pepsiDecrement;

	public void click() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(orderOnlineClick));
		orderOnlineClick.click();
	}

	public void location() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(location));
		location.click();

	}

	public void locationInput() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locationInput));
		locationInput.sendKeys("600028");
		locationInput.sendKeys(Keys.ENTER);

	}

	public void suggestions() {
		sleep(3000);
		int position = 0;
		List<WebElement> we = new ArrayList<WebElement>();
		we.add(suggestion);
		for (WebElement web : we) {
			position++;
			if (position == 1) {
				web.click();
				break;

			}
		}

	}
  
	public void vegPizza()  {
		
		sleep(3000);
		
		alertDismiss.click();

		vegPizza.click();

		Margherita.click();

		noThanksBTN.click();

		MargheritaIncrement.click();

		sleep(5000);

		gourmetPizza.click();
		
		sleep(2000);

		gourmetPizzaINC.click();

		sleep(2000);

		peppypaneer.click();

		sleep(2000);

		peppyIncrement.click();

		String cartValue1 = total.getText();
		System.out.println(cartValue1);

		Assert.assertEquals(First_Cart_Value, cartValue1);

	
		
	}

	public void beverages() {
		sleep(2000);
		Beverages.click();
		sleep(2000);
		pepsi.click();
		sleep(5000);
		
		for (int i = 0; i < 11; i++)
		{
			pepsiIncrement.click();
		}
		
		String cartvalue2 = total.getText();
		System.out.println(cartvalue2);
		Assert.assertEquals(Second_Cart_Value, cartvalue2);
	}

	public void finalCartValue() {

		for (int i = 0; i < 6; i++) {
			pepsiDecrement.click();
		}

		vegPizza.click();
		
		MargheritaDecrement.click();

		String cartValue3 = total.getText();
		System.out.println(cartValue3);

		Assert.assertEquals(Third_cart_value, cartValue3);

	}

	public void dominos() {
		click();
		location();
		locationInput();
		suggestions();
		vegPizza();
		beverages();
		finalCartValue();
	}

}
