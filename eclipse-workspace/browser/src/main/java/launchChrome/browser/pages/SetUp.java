package launchChrome.browser.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if (System.getProperty("os.name").startsWith("Mac")) {
			String chromeDriverPath = System.getProperty("user.dir") + "chromedriver_mac";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if (System.getProperty("os.name").startsWith("Windows")) {
			String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver_latest.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
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
		options.addArguments("--disable-dev-shm-usage");
		Thread.sleep(5000);
		System.out.println("Installing metamask extension");
		//options.addExtensions(new File(System.getProperty("user.dir") + "/extension_7_7_8_0.crx"));
		//Thread.sleep(5000);
		// options.addArguments("--headless");
		// options.addArguments("--window-size=1920,1080");
		// options.addArguments("--no-sandbox");
		
		//options.addArguments("--headless");
		//options.addArguments("--window-size=1920,1080");
		//options.addArguments("staraddArgumentst-maximized");
		
		
		Thread.sleep(3000);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		Thread.sleep(5000);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		Thread.sleep(3000);
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		System.out.println("Launching browser");
		driver = new ChromeDriver(caps);
		System.out.println("Clicking on getting started button");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='button btn-primary first-time-flow__button']")).click();
		// driver.manage().window().maximize();
		System.out.println("Launching Google search");
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		System.out.println("Page title="+driver.getTitle());

	}

	@AfterSuite
	public void afterSuite() {
		if (driver != null) {
			driver.quit();
		}
	}

}
