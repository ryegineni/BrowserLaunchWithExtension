package launchChrome.browser.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class SetUp {
	public static WebDriver driver = null;
	public static FileInputStream fisprop = null;
	public static Properties prop = new Properties();

	
	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		browserLaunch();

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method testMethod) {

	}

	public WebDriver getDriver() throws InterruptedException {
		browserLaunch();
		return driver;
	}

	
	public void configureDriverPath() throws IOException {

		if (System.getProperty("os.name").startsWith("Linux")) {
			String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver83";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriverupdate");
		}
		if (System.getProperty("os.name").startsWith("Mac")) {
			String chromeDriverPath = System.getProperty("user.dir") + "chromedriver_mac";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if (System.getProperty("os.name").startsWith("Windows")) {
			String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver_latest.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
		}

	}

	@SuppressWarnings("deprecation")
	public void browserLaunch() throws InterruptedException {
		try {
			configureDriverPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ChromeOptions options = new ChromeOptions();
		  options.addArguments("--no-sandbox");
		 // options.addArguments("--disable-dev-shm-usage");      Thread.sleep(5000);
		  System.out.println("Installing metamask extension");
		  options.addExtensions(new File(System.getProperty("user.dir") + "/extension_7_7_8_0.crx"));
		  DesiredCapabilities caps = DesiredCapabilities.chrome();
		  caps.setCapability(ChromeOptions.CAPABILITY, options);
		  System.setProperty("webdriver.chrome.silentOutput", "true");
		  driver = new ChromeDriver(caps);
		  //Thread.sleep(5000);
		
		/*
		 * try { configureDriverPath(); } catch (IOException e) { e.printStackTrace(); }
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--no-sandbox");
		 * options.addArguments("--disable-dev-shm-usage"); Thread.sleep(5000);
		 * //System.out.println("Installing metamask extension");
		 * //options.addExtensions(new File(System.getProperty("user.dir") +
		 * "/extension_7_7_8_0.crx")); //Thread.sleep(5000);
		 * options.addArguments("--headless"); //
		 * options.addArguments("--window-size=1920,1080"); //
		 * options.addArguments("--no-sandbox");
		 * 
		 * //options.addArguments("--headless");
		 * //options.addArguments("--window-size=1920,1080");
		 * //options.addArguments("staraddArgumentst-maximized"); Thread.sleep(3000);
		 * //C:\Users\Vinay\Downloads\metamask-7.7.9-an+fx.xpi options.addExtensions(new
		 * File(System.getProperty("user.dir") + "/extension_7_7_8_0.crx"));
		 * Thread.sleep(3000); DesiredCapabilities caps = DesiredCapabilities.chrome();
		 * Thread.sleep(5000); caps.setCapability(ChromeOptions.CAPABILITY, options);
		 * Thread.sleep(3000); //System.setProperty("webdriver.chrome.silentOutput",
		 * "true"); System.out.println("Launching browser"); driver = new
		 * ChromeDriver(caps);
		 * //System.out.println("Clicking on getting started button");
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * //driver.findElement(By.
		 * xpath("//button[@class='button btn-primary first-time-flow__button']")).click
		 * (); // driver.manage().window().maximize();
		 * System.out.println("Launching Google search");
		 * driver.get("https://www.google.com/"); Thread.sleep(5000);
		 * System.out.println("Page title="+driver.getTitle());
		 */
		// WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
			/*
			 * FirefoxProfile firefoxprofile = new FirefoxProfile();
			 * firefoxprofile.addExtension(new File(System.getProperty("user.dir") +
			 * "/metamaskNew.xpi")); FirefoxOptions option = new FirefoxOptions();
			 * option.setProfile(firefoxprofile);
			 */
		// option.setCapability("marionette", true);
		// option.setHeadless(true);
		// DesiredCapabilities caps = DesiredCapabilities.firefox();
		// caps.setCapability(FirefoxDriver.PROFILE, firefoxprofile);
		// DesiredCapabilities capability = DesiredCapabilities.firefox();
		// capability.setJavascriptEnabled(true);
		
		// ProfilesIni profile = new ProfilesIni();
//		FirefoxOptions firefoxOptions = new FirefoxOptions();
//		FirefoxProfile profile = new FirefoxProfile();
//
//		profile.addExtension(new File("foxyproxy_basic-5.5-an+fx.xpi"));
//
//		firefoxOptions.setProfile(profile);

		// FirefoxProfile firefoxprofile = profile.getProfile("ravi");

		//
		// option.setProfile(firefoxProfile);
		// capability.setCapability("firefox_profile", firefoxprofile);
			/*
			 * driver = new FirefoxDriver(option); Thread.sleep(3000);
			 */
		System.out.println("Current url =" + driver.getCurrentUrl());
		

	}

	@AfterSuite
	public void afterSuite() {
		if (driver != null) {
			driver.quit();
		}
	}

}
