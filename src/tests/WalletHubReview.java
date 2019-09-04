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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WalletHubReview {

 public static WebDriver driver;
 static String baseurl = "https://wallethub.com/join/light";
 static String review_sub_url = "http://wallethub.com/profile/test_insurance_company/";
 /* Change the <Username> to your Username in below URL */
 static String review_verification_url = "https://wallethub.com/profile/harshd38/reviews/";

 //change username and password here for login
 String username = "harshd38@gmail.com";
 String password = "Jumper398@";

 @BeforeMethod
 public void setup() {

  ChromeOptions options = new ChromeOptions();
  options.addArguments("--disable-notifications");
  
  /* Loading Up the Chrome Driver and Opening the Browser */
  System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
  System.out.println("1. Test 2 is Starting");
  driver = new ChromeDriver(options);
  driver.get(baseurl);
  System.out.println("2. Redirecting to WalletHUb");
  driver.manage().window().maximize();
  System.out.println("3. Window is Maximized");
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }

 @Test
 public void CanPostReviewOnWalletHub() throws InterruptedException {

  
//Clicking on Login animate, entering credentials and logging in
  WebElement login_animate = driver.findElement(By.xpath("//li/a[contains(text(),'Login')]")); // Login button
  login_animate.click();
  Thread.sleep(2000);
  
  WebElement user_email_id = driver.findElement(By.xpath("//input[@type='text' and contains(@placeholder,'Email')]")); //Email Input
  user_email_id.sendKeys(username);
  Thread.sleep(2000);
  WebElement passwd = driver.findElement(By.xpath("//input[@type='password' and contains(@placeholder,'Password')]")); //Password Input
  passwd.sendKeys(password);
  Thread.sleep(2000);
  System.out.println("4. Entering Credentials");
  //Logging in
  WebElement login_btn = driver.findElement(By.xpath("//button//span[contains(text(),'Login')]")); //Login Button
  login_btn.click();
  Thread.sleep(5000);
  System.out.println("5. Logging In");
  
 
  //Routing to review submission page
  driver.navigate().to(review_sub_url);
  System.out.println("6. Navigating to Review Page");
  WebDriverWait wait = new WebDriverWait(driver, 30);
  
  
  //hovering to review stars and selecting 5th one
  WebElement review_2thstars = driver.findElement(By.xpath("//review-star[@class='rvs-svg']//*[2]"));
  WebElement review_3thstars = driver.findElement(By.xpath("//div[@class='review-action ng-enter-element']//*[3]"));
  WebElement review_4thstars = driver.findElement(By.xpath("//div[@class='review-action ng-enter-element']//*[4]"));
  Actions builder = new Actions(driver);
  Thread.sleep(1000);
  //Hovering to second start
  builder.moveToElement(review_2thstars).build().perform();;
  Thread.sleep(1000);
  //Hovering to 3rd star
  builder.moveToElement(review_3thstars).build().perform();;
  Thread.sleep(1000);
  // hovering to 4rth Star
  builder.moveToElement(review_4thstars).build().perform();;
  //Clicking on 4th Star
  builder.moveToElement(review_4thstars).click().perform();

  //selecting health from policy DD and Submitting the Review
  WebElement review_nth_stars = driver.findElement(By.xpath("//body/web-app/div[@id='web-app']/div[@id='scroller']/main/div[@class='pr-content pr-content-company']/div[@class='pr-content-left']/div[@class='pr-ct-box-space']/section[@id='reviews-section']/modal-dialog[@class='md-write-a-review']/div[@class='ng-modal-dialog opened ng-md-fullscreen']/div[@class='ng-modal-container ready']/write-review/review-star[@class='rvs-svg']/div[@class='rating-box-wrapper']/*[1]"));
  WebElement review_4th_star = driver.findElement(By.xpath("//modal-dialog[@class='md-write-a-review']//review-star[@class='rvs-svg']//*[4]"));
  WebElement policyDD = driver.findElement(By.xpath("//span[contains(text(),'Select...')]"));
  WebElement PolicyReview = driver.findElement(By.xpath("//textarea[@placeholder='Write your review...']"));
  WebElement PolicyHealth = driver.findElement(By.xpath("//li[contains(text(),'Health Insurance')]"));

  //Hovering hover 1st star
  builder.moveToElement(review_nth_stars).build().perform();;
  Thread.sleep(2000);
  //Hovering Over 4th Star
  builder.moveToElement(review_4th_star).build().perform();;
  //Click on 4th Star
  builder.moveToElement(review_4th_star).click().perform();
  //Dropdwon List Opened
  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Select...')]"))));
   policyDD.click();
  Thread.sleep(2000);
  PolicyHealth.click();
  //Selected Health Insurance
  Thread.sleep(2000);
  System.out.println("6. Selecting 4th star");
  //Adding review
  PolicyReview.clear();

  String msg = "";
  for (int i = 0; i < 2; i++) {
   msg += " WalletHub is a personal finance website that was launched in early August 2013.[1][2][3] It is based in Washington, D.C.[4][5][6] and owned by Evolution Finance, Inc. – parent company of the credit card website CardHub.com.[7][8]\n" +
    "\n" +
    "According to Web reports, WalletHub initially positioned itself as a “personal finance social network” with a focus on reviews for financial advisors.[9][10][11]\n" +
    "\n" +
    "WalletHub is also known for its free consumer tools,[12][13][14] such as its WalletLiteracy Quiz[15][16] and its Financial Fitness Tool, which provides users with free credit reports, credit scores and credit monitoring.[17][18] The company also successfully overcame a public trademark dispute with Major League Baseball, brought on behalf of the Washington Nationals and Chicago Cubs.[19][20]";
  }
  PolicyReview.sendKeys(msg);
  driver.findElement(By.xpath("/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]/modal-dialog[1]/div[1]/div[1]/write-review[1]/sub-navigation[1]/div[1]/div[2]")).click();;
  System.out.println("7. Adding Review");
  //checking confirmation
  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[contains(text(),'Your review has been posted.')]"))));

  //navigating to profile page to see if posted review exist
  driver.navigate().to(review_verification_url);
  driver.findElement(By.xpath("//div[@id='wh-body']//li[2]//a[1]")).click();
  driver.findElement(By.xpath("//div[@id='wh-body']//li[3]//a[1]")).click();
  String bodyText = driver.findElement(By.xpath("//p[contains(text(),'WalletHub is a personal finance website that was l')]")).getText();
  System.out.println("8. Confirming The Review");
  Assert.assertTrue(bodyText.contains(bodyText), "Review is not showing in profile/review page, Failing Test!");
  System.out.println("Posted review is showing in profile/review page, Passing Test!");

 }


 @AfterMethod
 public void teardown(ITestResult result) {

  if (ITestResult.FAILURE == result.getStatus()) {

   try {

    // To create reference of TakesScreenshot
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    // Call method to capture screenshot
    File src = screenshot.getScreenshotAs(OutputType.FILE);

    // Copy files to specific location 
    // result.getName() will return name of test case so that screenshot name will be same as test case name
    FileUtils.copyFile(src, new File("screenshots\\" + result.getName() + ".png"));
    System.out.println("Successfully captured a screenshot");

   } catch (Exception e) {

    System.out.println("Exception while taking screenshot " + e.getMessage());
   }
  }
  driver.quit();

 }
}