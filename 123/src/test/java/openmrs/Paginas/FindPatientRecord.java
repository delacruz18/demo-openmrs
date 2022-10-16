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

public class FindPatientRecord {
    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;
    private RegisterPatient registerPatient;


    public FindPatientRecord(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions();
        this.registerPatient = new RegisterPatient(driver);

    }
    @FindBy(how = How.CSS, using = "#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    private WebElement FindMenu;


    @FindBy(how = How.XPATH, using = "//input[@id='patient-search']")
    private WebElement search;
    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[1]")
    private WebElement SelectPatient;


    public void BuscarPaciente () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(FindMenu));
        FindMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(search));
        search.clear();
        String ID = registerPatient.getIDdelPatient();
        search.sendKeys(ID);
        wait.until(ExpectedConditions.elementToBeClickable(SelectPatient));
        SelectPatient.click();

    }




}
