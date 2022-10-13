package openmrs.Paginas;

import openmrs.Steps.Botones;
import openmrs.Steps.Questions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class RegisterPatient {

    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;

    String name ="carlos";
    String LastName ="De La Cruz";

    public RegisterPatient(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions();

    }

    @FindBy(how = How.XPATH, using = "//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
    private WebElement Register;

    @FindBy(how = How.NAME, using = "givenName")
    private WebElement givenName;

    @FindBy(how = How.NAME, using = "familyName")
    private WebElement familyName;

    @FindBy(how = How.XPATH, using = "//button[@id='next-button']")
    private WebElement NextButton;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'Male')]")
    private WebElement Male;


    public void Iniiciar_registro () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Register));
        Register.click();

    }

    public void DatosDemograficos () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(givenName));
        givenName.clear();
        givenName.sendKeys(name);
        familyName.clear();
        familyName.sendKeys(LastName);
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));
        NextButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(Male));
        Male.click();
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));
        NextButton.click();

    }

    public void databirthdate () throws IOException {
        this.botones.birthdateDay();

    }

}
