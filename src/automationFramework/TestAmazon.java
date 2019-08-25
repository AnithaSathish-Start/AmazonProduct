package automationFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.java.swing.plaf.windows.resources.windows;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage2;

public class TestAmazon {
	public static WebDriver  driver = null;

 @BeforeClass
   public void setUp(){
        HomePage2.LaunchBrowserandOpenURL();
}
 
@Test
public void TestAmazonProducts() throws IOException {
	
	@SuppressWarnings("unused")
	HomePage2 testautomation = new HomePage2();
//	HomePage2.EnterUsername();
//	HomePage2.EnterPassword();
//	HomePage2.ClickSignin();
	HomePage2.SearchProducts("Books");
	HomePage2.ClickOnProd();
	HomePage2.VerifytheProduct();
	HomePage2.CloseBrowser();

}

}
