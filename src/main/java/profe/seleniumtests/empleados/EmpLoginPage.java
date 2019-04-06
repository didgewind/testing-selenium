package profe.seleniumtests.empleados;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmpLoginPage {

	private WebDriver driver;
	
	@FindBy(name = "username")
	private WebElement inputUserName;
	@FindBy(name = "password")
	private WebElement inputPassword;
	
	public EmpLoginPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().contains("Login")) {
			throw new RuntimeException();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void loginConUsuario(String usuario) {
		inputUserName.sendKeys("profe");
		inputPassword.sendKeys("profe");
		inputPassword.sendKeys(Keys.ENTER);
	}
	
}
