package openmrs.Paginas;

import openmrs.Steps.Botones;
import openmrs.Steps.Questions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LogIn {
    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;


    public LogIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions();
    }

    @Step
    public void Credenciales () throws IOException {
       this.botones.credenciales();
    }
    @Step
    public void Seleccionarlocation () throws IOException {
        this.botones.Location();
       }
    public void IniciarSesion() throws IOException {
        this.botones.Login();
    }

    @Step
    public void ValidarLogin () throws IOException {
      this.questions.HomeAssert(driver);
    }
}
