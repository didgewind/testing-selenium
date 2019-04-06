package profe.seleniumtests.empleados;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import profe.empleados.model.Empleado;
import profe.empleados.model.EmpleadoForTest;

public class EmpleadosSelTestPageObjects {

	private WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://localhost:3333");
	}
	
	@Test
	public void whenInsertaEmpleadoThenEmpleadoCreado() throws Exception {
		EmpHomePage homePage = new EmpHomePage(driver);
		homePage.pulsaEnlaceIrAGestionEmpleados();
		
		EmpLoginPage loginPage = new EmpLoginPage(driver);
		loginPage.loginConUsuario("profe");
		
		EmpGestEmpsPage gestPage = new EmpGestEmpsPage(driver);
		gestPage.rellenaDatos(new Empleado("54325432s", "yo", "yo", 45));
		gestPage.pulsaInsertar();
		assertTrue(gestPage.isTextoInsertadoPresent());
		
		gestPage.rellenaDatos(new Empleado("54325432s", "", "", 0));
		gestPage.pulsaMuestraUno();
		EmpleadoForTest empRecibido = gestPage.getEmpleadoFromFields();
		System.out.println(empRecibido);

	}
}
