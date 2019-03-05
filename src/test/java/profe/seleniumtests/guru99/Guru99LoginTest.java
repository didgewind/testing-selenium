package profe.seleniumtests.guru99;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Guru99LoginTest {
	WebDriver driver;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;

	@BeforeEach
	public void setup() {
		driver = new FirefoxDriver();
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
		Assertions.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		// login to application
		objLogin.loginToGuru99("mgr123", "mgr!23");
		// go the next page
		objHomePage = new Guru99HomePage(driver);
		// Verify home page
		Assertions.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}
}
