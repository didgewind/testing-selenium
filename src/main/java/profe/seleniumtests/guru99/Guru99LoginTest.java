package profe.seleniumtests.guru99;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Guru99LoginTest {
	WebDriver driver;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;

	@Before
	public void setUp() {
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setHeadless(true);
	    driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}

	/**
	 * This test case will login in http://demo.guru99.com/V4/ Verify login page
	 * title as guru99 bank Login to application Verify the home page using
	 * Dashboard message
	 */
	@Test
	public void test_Home_Page_Appear_Correct() {
		// Create Login Page object
		objLogin = new Guru99Login(driver);
		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		// login to application
		objLogin.loginToGuru99("mgr123", "mgr!23");
		// go the next page
		objHomePage = new Guru99HomePage(driver);
		// Verify home page
		assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}
}
