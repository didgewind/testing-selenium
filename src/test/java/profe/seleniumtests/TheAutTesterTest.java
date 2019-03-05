package profe.seleniumtests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TheAutTesterTest {

	private static WebDriver selenium = new FirefoxDriver();

	@Test
	public void shouldCheckButtonOnChapter2Page() {
		loadHomePage();
		clickAndLoadChapter2();
		assertEquals(1, selenium.findElements(By.id("but1")).size());
	}

	@Test
	public void shouldCheckAnotherButtonOnChapter2Page() {
		loadHomePage();
		clickAndLoadChapter2();
		assertEquals(1, selenium.findElements(By.id("verifybutton")).size());
	}

	private void loadHomePage() {
		selenium.get("http://book.theautomatedtester.co.uk");
	}

	private void clickAndLoadChapter2() {
		selenium.findElement(By.linkText("Chapter2")).click();
	}

}
