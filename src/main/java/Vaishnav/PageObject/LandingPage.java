package Vaishnav.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@aria-label='Close']")
	WebElement closepopup;

	@FindBy(xpath="//a[normalize-space()='Log In / Sign Up']")
	WebElement Login;
	
	@FindBy(css="#mobileNumber")
	WebElement Mobilenumber;
	
	@FindBy(css="button[type='submit']")
	WebElement submit;
	
	@FindBy(css="input[inputmode='tel']")
	WebElement Pin;
	
	@FindBy(css="div[class='col-span-12 ng-star-inserted']")
	WebElement loggedin;
	
	
	
	@FindBy(xpath="//span[normalize-space()='Continue']")
	WebElement Continue;

	@FindBy(xpath="//span[@class='ellipsis']")
	WebElement Order;
	
	@FindBy(xpath="//a[@ng-reflect-router-link='/my-orders']")
	WebElement MyOrder;
	
	@FindBy(xpath="(//div[contains(text(),'500.00')])[1]")
	WebElement Text;
	
	public void LoginApplication(String Mnum, String pinn)
	{
		closepopup.click();
		Login.click();
		Mobilenumber.sendKeys(Mnum);
		submit.click();
		Pin.sendKeys(pinn);
		loggedin.click();

	}
	
	public void goTo()
	{
		driver.get("https://new-cp.gfau.augmont.com/");
	
	}
	
	
	public void AfterPayment()
	{
		
		Continue.click();
		Order.click();
		MyOrder.click();
		String FinalValue =Text.getText();
		//Assert.assertTrue(FinalValue.contains("500.00"));
		System.out.println("Gold purchased successfully");
		
	}
	
	public void setup()
	{

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
	}
	

	 

	
}
