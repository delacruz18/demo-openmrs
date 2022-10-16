package openmrs.Steps;


import openmrs.Paginas.RegisterPatient;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;


public class Questions {

    private WebDriver driver ;
	private RegisterPatient registerPatient;

	@FindBy(how = How.NAME, using = "givenName")
	private WebElement givenName;
	@FindBy(how = How.XPATH, using = "//div[@class='float-sm-right']/span")
	private WebElement PatientID;

	@FindBy(how = How.XPATH, using = "ul[id='breadcrumbs'] li:nth-child(2)")
	private WebElement NombreCabecera;
	@FindBy(how = How.XPATH, using = "//span[@class='PersonName-givenName']")
	private WebElement FirstName;

	@FindBy(how = How.XPATH, using = "//span[@class='PersonName-familyName']")
	private WebElement familyName;

	@FindBy(how = How.XPATH, using = "//div[@class='gender-age col-auto']//span[2]")
	private WebElement Sexo;

	@FindBy(how = How.XPATH, using = "//span[@id='coreapps-telephoneNumber']")
	private WebElement Telefono;


	@Step //assert para validar que estemos logueados y en la pagina de home
	public void HomeAssert(WebDriver driver) {
		String ActualTitleHome = driver.getTitle();
		System.out.println(ActualTitleHome);
		try {Assert.assertEquals(ActualTitleHome, "Home");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// se imprime el error arrojado
		}
	}

	@Step // assert para validar que estemos localizados en la pagina de login
	public void LoginAssert(WebDriver driver) {
			String ActualTitle = driver.getTitle();
			try {Assert.assertEquals(ActualTitle, "Login");
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();// se imprime el error arrojado
			}
		}
	public void PatientNumber() throws IOException {

		try{
			if(PatientID.isDisplayed())
				System.out.println("Element is present and displayed");
			else
				System.out.println("El elemento no ha sido desplegado");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// se imprime el error arrojado
		}

	}


/*


	@Step
	public void textoAssert(WebDriver driver) {

		Assert.assertEquals("Introduce tu contraseña", "Introduce tu contraseña");
	}

	@Step
	public void textoCrearCuentaAssert(WebDriver driver) {

		Assert.assertEquals("Crea una contraseña", "Crea una contraseña");
	}
	*/
}