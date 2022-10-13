package openmrs.Steps;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Questions {

	@FindBy(how = How.NAME, using = "givenName")
	private WebElement givenName;

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


/*
	@Step
	public void screenShot(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File dest = new File("C:\\Users\\jmedina\\Documents\\Captura" + filename + ".png");
		try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

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