package openmrs.Paginas;

import openmrs.Steps.Botones;
import openmrs.Steps.Questions;
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

public class RegisterPatient {

    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;

    String name ="carlos";
    String LastName ="De La Cruz";
    String IDdelPatient =null;





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

    @FindBy(how = How.ID, using = "address1")
    private WebElement address1;

    @FindBy(how = How.ID, using = "address2")
    private WebElement address2;

    @FindBy(how = How.NAME, using = "phoneNumber")
    private WebElement phoneNumber;

    @FindBy(how = How.ID, using = "relationship_type")
    private WebElement relationship;


    @FindBy(how = How.XPATH, using = "//input[@placeholder='Person Name']")
    private WebElement PersonName;

    @FindBy(how = How.XPATH, using = "//input[@id='submit']")
    private WebElement submit;
    @FindBy(how = How.XPATH, using = "//div[@class='float-sm-right']/span")
    private WebElement PatientID;



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

    public void ContactInfoAddres() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(address1));
        address1.clear();
        address1.sendKeys("cl 12 22 33");
        wait.until(ExpectedConditions.elementToBeClickable(address2));
        address2.clear();
        address2.sendKeys("cl 12 22 33");
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));
        NextButton.click();
    }

    public void ContactInfophoneNumber() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
        phoneNumber.clear();
        phoneNumber.sendKeys("3106604843");
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));
        NextButton.click();
    }


    public void ContactInfoprelatives() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(relationship));
        relationship.click();
        new Select(relationship).selectByVisibleText("Sibling");
        wait.until(ExpectedConditions.elementToBeClickable(PersonName));
        PersonName.click();
        wait.until(ExpectedConditions.elementToBeClickable(NextButton));
        NextButton.click();
    }


    public void ConfrimCreacion() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }
/*
    public String PatientNumber() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(PatientID));
        IDdelPatient=PatientID.getText();
        System.out.println("El id del paciente es "+ IDdelPatient);
        try{
            if(PatientID.isDisplayed())
                System.out.println("Element is present and displayed");
            else
                System.out.println("El elemento no ha sido desplegado");
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();// se imprime el error arrojado
        }
return IDdelPatient ;
    }
*/

    public String PatientNumber() throws IOException {
        this.questions.PatientNumber();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(PatientID));
        IDdelPatient=PatientID.getText();
        System.out.println("El id del paciente es "+ IDdelPatient);
        return IDdelPatient ;
    }


}
