package openmrs.Steps;

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

public class Botones {

    private WebDriver driver;


    public Botones(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    String usuario ="Admin";
    String Contrasena ="Admin123";

    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    private WebElement username;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//li[@id='Inpatient Ward']")
    private WebElement Inpatient;

    @FindBy(how = How.XPATH, using = "//input[@id='loginButton']")
    private WebElement loginButton;


    @Step //ingreso de credenciales al portal
    public void credenciales() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.clear();
        username.sendKeys(usuario);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(Contrasena);
    }

    @Step //selección de la opción Inpatient ward
    public void Location () throws IOException {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Inpatient));
        Inpatient.click();
    }

    @Step //// se procede a dar logueo
    public void Login () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }


}
