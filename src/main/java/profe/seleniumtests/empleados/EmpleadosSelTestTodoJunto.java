package profe.seleniumtests.empleados;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class EmpleadosSelTestTodoJunto {

	private WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		driver = new HtmlUnitDriver();
	}
	
	@Test
	public void whenGetEmpleadoNoExistenteThenApareceTextoNoEncontrado() {
		/* Abrimos página original y pulsamos hiperenlace */
		driver.get("http://localhost:3333");
		driver.findElement(By.id("link_gestor")).click();
		
		/* Página de login */
		driver.findElement(By.name("username")).sendKeys("profe");
		WebElement textPassword = driver.findElement(By.name("password"));
		textPassword.sendKeys("profe");
		textPassword.sendKeys(Keys.ENTER);

		/* Página de gestión */
		driver.findElement(By.id("input_cif")).sendKeys("8765875");
		driver.findElement(By.name("muestraUno")).click();
		assertTrue(driver.getPageSource().contains("no existe"));
		
	}
}
