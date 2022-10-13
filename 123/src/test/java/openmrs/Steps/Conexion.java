package openmrs.Steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.Before;
import net.thucydides.core.annotations.Step;

public class Conexion {

	private WebDriver driver;

	@Before
	@Step
	public WebDriver abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.openmrs.org/openmrs/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		
		
		return this.driver;

	}
	

}
