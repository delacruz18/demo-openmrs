package openmrs.Steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(how = How.ID, using = "birthdateDay-field")
    private WebElement birthdateDay;

    @FindBy(how = How.NAME, using = "birthdateMonth")
    private WebElement birthdateMonth;

    @FindBy(how = How.NAME, using = "birthdateYear")
    private WebElement birthdateYear;

    @FindBy(how = How.XPATH, using = "//button[@id='next-button']")
    private WebElement NextButton;


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

    @Step
    public void Location () throws IOException {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Inpatient));
        Inpatient.click();
    }

    @Step
    public void Login () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
        @Step
        public void birthdateDay () throws IOException {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(birthdateDay));
            birthdateDay.clear();
            birthdateDay.sendKeys("11");
            new Select(birthdateMonth).selectByVisibleText("January");
            wait.until(ExpectedConditions.elementToBeClickable(birthdateYear));
            birthdateYear.clear();
            birthdateYear.sendKeys("2022");
            wait.until(ExpectedConditions.elementToBeClickable(NextButton));
            NextButton.click();

        }




}
