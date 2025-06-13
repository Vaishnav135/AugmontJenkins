package Vaishnav.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoldPage {
	
	WebDriver driver;
	
	public GoldPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@class='p-ripple p-element p-button p-component w-full text-teal bg-white hover:bg-white border-2 border-teal font-gilroymedium rounded-xl text-20 py-4 px-5 text-center text-18']")
	WebElement DropDown;

	@FindBy(xpath="//span[normalize-space()='Digital Gold']")
	WebElement DigitalG ;
	
	@FindBy(xpath="//div[@class='py-2 px-6 border-b border-sheengold ng-star-inserted']")
	WebElement Five;
	
	@FindBy(xpath="//span[normalize-space()='One-Time']")
	WebElement onetime;
	
	@FindBy(xpath="//span[normalize-space()='Buy Gold']")
	WebElement BuyGold;
	
	@FindBy(xpath="//span[normalize-space()='Pay Now']")
	WebElement PayNow;
	
	
	public void BuyGold()
	{
		DropDown.click();
		DigitalG.click();
		Five.click();
		JavascriptExecutor jss = (JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,400)");
		onetime.click();
		jss.executeScript("window.scrollBy(0,500)");
		BuyGold.click();
		jss.executeScript("window.scrollBy(0,500)");
		PayNow.click();

	}
	
	
	
}
