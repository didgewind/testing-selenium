package profe.seleniumtests.guru99;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.FindsById;

/*
 * Ejemplo Guru99 sin page objects
 */
public class Guru99TestAllTogether {

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
			// Verify login page title
			Assertions.assertTrue(driver.findElement(By.className("barone")).getText().contains("Guru99 Bank"));
			// login to application
			driver.findElement(By.name("uid")).sendKeys("mgr123");
			driver.findElement(By.name("password")).sendKeys("mgr!23");
			driver.findElement(By.name("btnLogin")).click();
			// Verify home page
			Assertions.assertTrue(driver.findElement(By.xpath("//table//tr[@class='heading3']")).getText().toLowerCase().contains("manger id : mgr123"));
		}
		
}
