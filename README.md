# WalletHub-SDET - Assignment
Submission of Wallethub initial Screening Test 


Completed with selenium + testng

How to run it 

<ul><li>Install: java jdk 1.8, chrome latest version</li> 
	<li>git clone</li> 
	<li>Import Project and run as Maven Project</li> 
	<li>Build module /Install WalletHub-app with Maven</li> 
	<li>insert credentials for login/pass in tests class</li>
	<li> PS: the chrome driver is Google Chrome 76 </li></ul> 

public class Facebooklogin {
 
	public static WebDriver driver;
	static String baseurl="http://www.facebook.com";
	//change username and password here for login
	String username="";
	String password="";
  
  public class WalletHubReview {
	
	public static WebDriver driver;
	static String baseurl="https://wallethub.com/join/light";
	static String review_sub_url="http://wallethub.com/profile/test_insurance_company/";
	
	//change username in below URL in WalltHubReview at <b>Line 30</b>
	static String review_verification_url="https://wallethub.com/profile/username/reviews/";
	
	//change username and password here for login in WalltHubReview at <b>Line 33 and 34</b>
	String username="";
	String password="";
  <b> To Run the Whole Test :-</b>
<ui><li> Run testng.xml file run as <b>TESTNG</b> </li></ul>
  
  public void DelReviewOnWalletHub(){
  
  	//change username in below URL in DelWalltHubReview2 at <b>Line 25</b>
	static String review_verification_url="https://wallethub.com/profile/username/reviews/";
	
	//change username and password here for login in DelWalltHubReview2 at <b>Line 30 and 31</b>
	String username="";
	String password="";
	



<b> To delete Posted Review :-</b>
<ui><li> Run testng2.xml file run as <b>TESTNG</b> </li></ul>
<b>Automation test results:</b> Check Video Folder: <b>WalletHub-Assignment/Video/</b>
