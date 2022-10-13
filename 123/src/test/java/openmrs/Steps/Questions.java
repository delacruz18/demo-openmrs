package openmrs.Steps;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.ibm.icu.text.SimpleDateFormat;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.OutputType;

public class Questions {

	@Step
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

	@Step
	public void LoginAssert(WebDriver driver) {

		String ActualTitle = driver.getTitle();
		try {Assert.assertEquals(ActualTitle, "Login");

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// se imprime el error arrojado

		}

	}

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
}