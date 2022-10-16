package openmrs.Steps;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class Questions {

    private WebDriver driver ;



	@FindBy(how = How.NAME, using = "givenName")
	private WebElement givenName;

	@FindBy(how = How.XPATH, using = "//div[@class='float-sm-right']/span")
	private WebElement PatientID;

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