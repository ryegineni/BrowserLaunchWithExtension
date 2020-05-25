package launchChrome.browser.testcases;

import org.testng.annotations.Test;

import launchChrome.browser.pages.SetUp;

public class LaunchChromeTest extends SetUp {
	@Test
	public void browserLaunchWithExtension() {
		System.out.println("Browser launched successfully");
	}
}
