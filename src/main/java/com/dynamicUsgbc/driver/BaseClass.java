package com.dynamicUsgbc.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.LogStatus;




public class BaseClass {
	
	public static WebDriver driver;
	public static XlsReader data;
	public Properties prop;
	public JavascriptExecutor js;
	public String testName;
	public String testScreenShotDirectory;
	public static String BaseUrl = "http://test-dynamic-usgbc.pantheonsite.io/";
	public static String ReceiptUrl = "http://test-dynamic-usgbc.pantheonsite.io/payment/reciept";
	public String CommunityRegistrationUrl = "community/registration";
	public String DonationsHaitiUrl = "/donations/center/online/haiti";
	public String DonationsUsgbcUrl = "/donations/center/online/usgbc";
	public String DonationsCfgsUrl = "/donations/center/online/cfgs";
	public String DonationsMyGreenAppleUrl = "/donations/center/online/mygreenapple";
	public String SponsorshipUrl = "/sponsorship/content";
	public String ExamRegistrationUrl = "/register-exams/exam";
	public String StoreUrl = "/store";
	public String ProductUrl = "/product/details";
	public String SignInUrl = "/user/login";
	public String NewRegistrationUrl="/signin";
	public String MembershipUrl="/membership/contact";
	public static String downloadPath = System.getProperty("user.dir") +"\\Download\\";
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browserName","environment"})
	public void setup(String browserName,String environment) throws InterruptedException, IOException{
		System.out.println("This is Before Class");
		//Excel path configuration
		data= new XlsReader(System.getProperty("user.dir")+"/DynamicUsgbc.xlsx"); 
		
		 
		//selecting browser based on parameter from TestNG.xml
		if(browserName.equalsIgnoreCase("firefox")){
			
			FirefoxProfile profile = new FirefoxProfile();
			   profile.setPreference("browser.download.folderList", 2);
			   profile.setPreference("browser.download.dir", downloadPath);
			   System.out.println(downloadPath);
			   profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			   profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
			   profile.setPreference("browser.download.manager.showWhenStarting", false);
			   profile.setPreference("browser.download.manager.focusWhenStarting", false);  
			   profile.setPreference("browser.download.useDownloadDir", true);
			   profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			   profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			   profile.setPreference("browser.download.manager.closeWhenDone", true);
			   profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			   profile.setPreference("browser.download.manager.useWindow", false);
			   profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			   profile.setPreference("pdfjs.disabled", true);
			         
			   driver = new FirefoxDriver(profile);
			  
		}
		else if(browserName.equalsIgnoreCase("chrome")){

			//work with chrome
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/DriverFiles/chromedriver.exe");
			   HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		       chromePrefs.put("profile.default_content_settings.popups", 0);
		       chromePrefs.put("download.default_directory", downloadPath);
		       ChromeOptions options = new ChromeOptions();
		       HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		       options.setExperimentalOption("prefs", chromePrefs);
		       options.addArguments("--test-type");
		       options.addArguments("--disable-extensions"); //to disable browser extension popup
		       DesiredCapabilities cap = DesiredCapabilities.chrome();
		       cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		       cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		       cap.setCapability(ChromeOptions.CAPABILITY, options);
		       
			driver = new ChromeDriver(cap);	
		}
		                   
		else if(browserName.equalsIgnoreCase("opera")){
			//opera
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"/DriverFiles/operadriver.exe");
			driver = new OperaDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie")){
	       
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capabilities.setCapability("disable-popup-blocking", true);
			//work with Internet explorer
			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\DriverFiles\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			
		}
		
		else if(browserName.equalsIgnoreCase("safari")){

			//work with Internet explorer
			System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
			driver = new SafariDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("phantom")){

			File src = new File (System.getProperty("user.dir")+"\\phantomjs.exe");
			System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
		   // driver = new PhantomJSDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("htmlunit")){

		    driver = new HtmlUnitDriver();
		    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
		   /* Logger logger = Logger.getLogger("");
		    logger.setLevel(Level.OFF); */
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);

		prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Environment.properties");

		prop.load(file);
		String qaurl=prop.getProperty("ENV_QA");
		String stageurl=prop.getProperty("ENV_STAGING");
		String productionurl=prop.getProperty("ENV_PRODUCTION");
		
		if(environment.equalsIgnoreCase("qa")){
			
			driver.get(qaurl);
			
		}
		else if(environment.equalsIgnoreCase("staging")){
			System.out.println(stageurl);
			driver.get(stageurl);

		}
		else if(environment.equalsIgnoreCase("production")){
			
			driver.get(productionurl);
			
		}
		Thread.sleep(5000);	
		System.out.println(driver.getTitle());
	
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {
		
		 if (result.getStatus() == ITestResult.FAILURE) {
			 CommonMethod.test.log(LogStatus.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	        CommonMethod.test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	        } else {
	        CommonMethod.test.log(LogStatus.PASS, "Test passed");
	        }
		CommonMethod.extent.endTest(CommonMethod.test);
		CommonMethod.extent.flush();
	}
	
	@AfterClass(alwaysRun = true)
	public void end(){	
	/*//driver.manage().deleteAllCookies();
	driver.close();
	driver.quit();*/
	 if (driver != null)
	 driver.quit();    	
	 }
   }
