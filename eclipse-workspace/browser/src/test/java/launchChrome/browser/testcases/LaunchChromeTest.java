package launchChrome.browser.testcases;

import org.testng.annotations.Test;

import launchChrome.browser.pages.SetUp;

public class LaunchChromeTest extends SetUp {
	@Test
	public void browserLaunchWithExtension() {
		driver.get("https://www.google.com/");
		System.out.println("Pagetitle1=" + driver.getTitle());
		System.out.println("Browser launched successfully!");
	}
}
