package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DelWalletHubReview2 {
	
	public static WebDriver driver;
	static String baseurl="https://wallethub.com/join/light";
	static String review_sub_url="http://wallethub.com/profile/test_insurance_company/";
	//change username in below URL
	static String review_verification_url="https://wallethub.com/profile/username/reviews/";
	
	
	
	//change username and password here for login
	String username="";
	String password="";
	
	
	@BeforeMethod
	public void setup(){
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//set chrome driver path here
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void DelReviewOnWalletHub() throws InterruptedException{
		
		//Clicking on Login animate, entering credentials and logging in
		WebElement login_animate=driver.findElement(By.xpath("//li/a[contains(text(),'Login')]"));
		login_animate.click(); Thread.sleep(2000);
		
		WebElement user_email_id=driver.findElement(By.xpath("//input[@type='text' and contains(@placeholder,'Email')]"));
		user_email_id.sendKeys(username); Thread.sleep(2000);
		
		WebElement passwd=driver.findElement(By.xpath("//input[@type='password' and contains(@placeholder,'Password')]"));
		passwd.sendKeys(password); Thread.sleep(2000);
		
		
		//Logging in
		WebElement login_btn=driver.findElement(By.xpath("//button//span[contains(text(),'Login')]"));
		login_btn.click(); Thread.sleep(5000);
		
		//navigating to profile page to see if posted review exist
		driver.navigate().to(review_verification_url);
		driver.findElement(By.xpath("//div[@id='wh-body']//li[2]//a[1]")).click();
		driver.findElement(By.xpath("//div[@id='wh-body']//li[3]//a[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Remove')]")).click();
		
}
	
	
	@AfterMethod
	public void teardown(ITestResult result){
		
		if(ITestResult.FAILURE==result.getStatus()){
			
			try{
				
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("screenshots\\"+result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
				
			}catch (Exception e){
				
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
		driver.quit();
		
	}
}
