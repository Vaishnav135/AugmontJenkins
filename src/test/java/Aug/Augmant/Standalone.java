package Aug.Augmant;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Vaishnav.PageObject.GoldPage;
import Vaishnav.PageObject.LandingPage;
import Vaishnav.PageObject.PaymentPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone {

	public static void main(String[] args) throws IOException {
		
	    WebDriverManager.chromedriver().setup();
		  
	    WebDriver driver = new ChromeDriver();
		  
		LandingPage lp = new LandingPage(driver);
		lp.setup();
		lp.goTo();
		lp.LoginApplication("9324148351", "998755");
		
		GoldPage Gp =new GoldPage(driver);
		Gp.BuyGold();
	
		PaymentPage P= new PaymentPage(driver);
		P.Payment();
		
		lp.AfterPayment();
				 
		}

		
	}


