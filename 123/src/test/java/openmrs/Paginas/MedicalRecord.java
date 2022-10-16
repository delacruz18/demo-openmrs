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

public class MedicalRecord {

    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;
    private RegisterPatient registerPatient;
    String name ="carlos";
    String LastName ="De La Cruz";
    static String IDdelPatient;

    public MedicalRecord(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions();

    }

    @FindBy(how = How.XPATH, using = "//div[@class='float-sm-right']/span")
    private WebElement PatientID;

    @FindBy(how = How.XPATH, using = "//span[@id='coreapps-showContactInfo']")
    private WebElement showContactInfo;
    @FindBy(how = How.XPATH, using = "//span[@id='coreapps-telephoneNumber']")
    private WebElement Telefono;

    public void ValidarDatos () throws IOException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.elementToBeClickable(showContactInfo));
        //showContactInfo.click();
        //wait.until(ExpectedConditions.visibilityOf(Telefono));
        String x = this.name;
          System.out.println(x);


    }
}
