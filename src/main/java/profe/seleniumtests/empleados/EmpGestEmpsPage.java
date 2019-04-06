package profe.seleniumtests.empleados;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import profe.empleados.model.Empleado;
import profe.empleados.model.EmpleadoForTest;

public class EmpGestEmpsPage {

	private WebDriver driver;
	
	@FindBy(name = "cif")
	private WebElement inputCif;
	@FindBy(name = "nombre")
	private WebElement inputNombre;
	@FindBy(name = "apellidos")
	private WebElement inputApellidos;
	@FindBy(name = "edad")
	private WebElement inputEdad;
	@FindBy(name = "muestraUno")
	private WebElement btnMuestraUno;
	@FindBy(name = "inserta")
	private WebElement btnInserta;
	
	public EmpGestEmpsPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().contains("Gestión de empleados")) {
			throw new RuntimeException();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void clearFields() {
		inputCif.clear();
		inputNombre.clear();
		inputApellidos.clear();
		inputEdad.clear();
	}
	
	public void rellenaDatos(Empleado empleado) {
		this.clearFields();
		inputCif.sendKeys(empleado.getCif());
		inputNombre.sendKeys(empleado.getNombre());
		inputApellidos.sendKeys(empleado.getApellidos());
		inputEdad.sendKeys("" + empleado.getEdad());
	}
	
	public void pulsaInsertar() {
		btnInserta.click();
	}
	
	public void pulsaMuestraUno() {
		btnMuestraUno.click();
		
	}
	
	boolean isTextoInsertadoPresent() {
		return driver.getPageSource().contains("Empleado insertado");
	}
	
	public EmpleadoForTest getEmpleadoFromFields() {
		return new EmpleadoForTest(
				inputCif.getText(), inputNombre.getText(), 
				inputApellidos.getText(), Integer.parseInt(inputEdad.getText()));
	}
	
}
