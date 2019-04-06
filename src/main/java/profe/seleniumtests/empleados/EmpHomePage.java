package profe.seleniumtests.empleados;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmpHomePage {

	private WebDriver driver;
	
	@FindBy(id = "link_gestor")
	private WebElement loginLink;
	
	public EmpHomePage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().contains("web de empleados que")) {
			throw new RuntimeException();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void pulsaEnlaceIrAGestionEmpleados() {
		loginLink.click();
	}
	
}
