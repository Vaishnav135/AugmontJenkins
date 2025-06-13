package Vaishnav.PageObject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaymentPage {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class='p-radiobutton-box'])[2]")
	WebElement webpayment;

	@FindBy(xpath="//span[normalize-space()='Choose Account']")
	WebElement ChooseAccount;
	
	@FindBy(css="div[role='button']")
	WebElement button;
	
	@FindBy(css="button.success")
	WebElement success;
	
	@FindBy(xpath="(//div[@role='dialog'])[1]")
	WebElement Dialogbox;
	

	public void Payment() throws IOException
	{
		webpayment.click();
		ChooseAccount.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	    WebElement switchto = driver.findElement(By.cssSelector("iframe.razorpay-checkout-frame"));   
		driver.switchTo().frame(switchto);
		WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));
	    mobileInput.sendKeys("9324148351");
	    button.click();
	    
	    Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Razorpay Bank")) {
                break;
            }}
        
        success.click();
	    
        Set<String> handles2 = driver.getWindowHandles();
        for (String handle : handles2) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Augmont - Best Place to Buy Gold Online | Digital Gold")) {
                break;
            }}
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
      		  "(//div[@role='dialog'])[1]")));
        
        File screenshot = Dialogbox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("Success.png"));
		  
		System.out.println("Screenshot saved as Success.png");
       

	}
	

	 
	
}
