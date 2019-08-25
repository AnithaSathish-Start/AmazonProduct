package pageObject;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

public class HomePage2 {
	public static WebDriver  driver = null;
	 public static void sleep() 
	    {
	    	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  
	   public static  HomePage2 LaunchBrowserandOpenURL(){
		   try {
			   System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver_win32\\chromedriver.exe");
			   driver=new ChromeDriver();
	           driver.get("https://www.amazon.in/");
	           driver.manage().window().maximize();
	           ScreenCapture();
	           } catch (Exception e) {
	               e.printStackTrace();
	
	 }
		return null;
}
	   public static HomePage2 SignIn(){
		   try {

			   driver.findElement(By.id("nav-link-yourAccount")).click();
	           } catch (Exception e) {
	               e.printStackTrace();
	
	 }
		return null;
}
	   
	   public static HomePage2 CloseBrowser(){
		   try {

			   driver.close();
	           } catch (Exception e) {
	               e.printStackTrace();
	
	 }
		return null;
}
	   
	   public static HomePage2 EnterUsername() throws IOException{
		   driver.findElement(By.id("ap_email")).sendKeys("1234567899");
		   ScreenCapture();
		   driver.findElement(By.id("continue")).click();
		return null;
	   }
	   
	   public static HomePage2 EnterPassword() throws IOException{
		   driver.findElement(By.id("ap_password")).sendKeys("3214569877");
		   ScreenCapture();
		return null;
	   }
	   
	   public static HomePage2 ClickSignin(){
		   try {
		   driver.findElement(By.id("signInSubmit")).click();
		   sleep();
		   ScreenCapture();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	   }
	   public static HomePage2 ScreenCapture() throws IOException
	   {
		   File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       File ScreenshotName = new File("F:\\Results"+driver.getTitle()+".png");
		   FileUtils.copyFile(srcFile,ScreenshotName);
		   Reporter.log("<br><img src='"+ScreenshotName+"'height=400 width=400</br>");
		   return null;   
	   }
	   
	   public static HomePage2 MatchContent()
	   {
		   sleep();
		   String content = driver.findElement(By.xpath("//*[@id='nav-global-location-slot']")).getText();
		   System.out.println(content);
		   String pattern = ".*Test*";
		   boolean isMatch = Pattern.matches(pattern, content);
		   System.out.println(isMatch);
		return null;
	   }
	   
	   public static Object SearchProducts(String EnterProd)
	   {
		   WebElement search = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		   search.sendKeys(EnterProd);
		   driver.findElement(By.xpath(".//input[@type='submit']")).click();
		   return new HomePage2();
	   }
	   
	   public static HomePage2 ClickOnProd()
	   {
		   WebElement FirstProdClick = driver.findElement(By.xpath("//*[@id='pdagDesktopSparkleHeadline']"));
		   String GetText = FirstProdClick.getText();
		   System.out.println(GetText);
		   FirstProdClick.click();
		  return null;
	   }
	   
	   public static HomePage2 VerifytheProduct()
	   {
		   sleep();
		   WebElement GetProductName = driver.findElement(By.xpath("(.//div[text()='Paperback']//preceding-sibling::div/a)[1]"));
		   String NameOfTheProduct = GetProductName.getText();
		   System.out.println(NameOfTheProduct);
		   GetProductName.click();
		   
		   //Verify the product
		   WebElement ProdNameInDetailpage = driver.findElement(By.xpath("//*[@id='productTitle']"));
		   String VerifyProdName = ProdNameInDetailpage.getText();
		   if(VerifyProdName.equals(NameOfTheProduct))
		   {
			   System.out.println("Test case is passed"); 
		   }
		   else
		   {
			   System.out.println("Test case is failed");
		   }
		   
		   return null;
	   }
	 
}
		   
	