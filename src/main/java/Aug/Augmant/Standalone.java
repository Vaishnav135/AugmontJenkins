package Aug.Augmant;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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


