package openmrs.Paginas;

import openmrs.Steps.Botones;
import openmrs.Steps.Questions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Home {

    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;


    public Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions();
    }

    @FindBy(how = How.LINK_TEXT, using = "Logout")
    private WebElement Logout;
    @Step
    public void Cerrarsesion () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Logout));
        Logout.click();
    }
    public void Validar_cierre () throws IOException {
      this.questions.LoginAssert(driver);
      driver.quit();
    }

}
