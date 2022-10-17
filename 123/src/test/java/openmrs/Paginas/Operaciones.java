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

public class Operaciones {
    private WebDriver driver;
    private Botones botones ;
    private Questions questions ;


    public Operaciones(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions();

    }

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Request Appointment')]")
    private WebElement Appointment;

    @FindBy(how = How.ID, using = "appointment-type")
    private WebElement AppointmentType;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[3]/div[4]/form[1]/p[1]/ul[1]/li[1]")
    private WebElement GeneralMedicine;

    @FindBy(how = How.ID, using = "min-time-frame-value")
    private WebElement MinTime;

    @FindBy(how = How.ID, using = "min-time-frame-units")
    private WebElement MinTimeUnits;
    @FindBy(how = How.ID, using = "max-time-frame-value")
    private WebElement MaxTime;

    @FindBy(how = How.ID, using = "max-time-frame-units")
    private WebElement MaxTimeunits;

    @FindBy(how = How.ID, using = "notes")
    private WebElement notes;

    @FindBy(how = How.ID, using = "save-button")
    private WebElement savebutton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Schedule Appointment')]")
    private WebElement ScheduleAppointment;

//////////////////////////////////////////////////////////////////



    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Start Visit')]")
    private WebElement StartVisitit;

    @FindBy(how = How.ID, using = "start-visit-with-visittype-confirm")
    private WebElement StartVisititConfirm;


    @FindBy(how = How.XPATH, using = "//a[@id='attachments.attachments.visitActions.default']")
    private WebElement attachments;

    @FindBy(how = How.XPATH, using = "//div[@class='dz-error-message']")
    private WebElement documents;

    @FindBy(how = How.XPATH, using = "//form[@id='visit-documents-dropzone']")
    private WebElement Ruta;


    @FindBy(how = How.XPATH, using = "//a[@id='org.openmrs.module.coreapps.deletePatient']/div/div[2]")
    private WebElement opcionEliminar;

    @FindBy(how = How.ID, using = "delete-reason")
    private WebElement razonEliminacion;

    @FindBy(how = How.CSS, using = "div[id='delete-patient-creation-dialog'] button[class='confirm right']")
    private WebElement Confirmar;






    public void CrearAppoiment () throws IOException {// se cra una cita desde la info delpaciente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(Appointment));
        Appointment.click();
        wait.until(ExpectedConditions.elementToBeClickable(AppointmentType));
        AppointmentType.clear();
        AppointmentType.sendKeys("General Medicine");
        wait.until(ExpectedConditions.elementToBeClickable(GeneralMedicine));
        GeneralMedicine.click();
        MinTime.sendKeys("11");
        MinTimeUnits.click();
        wait.until(ExpectedConditions.elementToBeClickable(MinTimeUnits));
        new Select(MinTimeUnits).selectByVisibleText("Day(s)");
        MaxTime.clear();
        MaxTime.sendKeys("22");
        wait.until(ExpectedConditions.elementToBeClickable(MaxTimeunits));
        MaxTimeunits.click();
        new Select(MaxTimeunits).selectByVisibleText("Day(s)");
        notes.sendKeys("notas asociadas a la cita");
        wait.until(ExpectedConditions.visibilityOf(savebutton));
        savebutton.click();
    }

    public void ValidaAppoint() throws IOException {// se valida la exixtencia de una cita en la info del paciente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(ScheduleAppointment));
        ScheduleAppointment.click();
        this.questions.Cite(driver);
    }


    public void AdjuntarDocumento () throws IOException {  // no fue posible identific<r elemento donde se cargan los soportes
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(StartVisitit));
        StartVisitit.click();
        wait.until(ExpectedConditions.elementToBeClickable(StartVisititConfirm));
        StartVisititConfirm.click();
        wait.until(ExpectedConditions.elementToBeClickable(attachments));
        attachments.click();
        wait.until(ExpectedConditions.visibilityOf(documents));
       // documents.click();
        Ruta.sendKeys("C:\\Users\\User\\Documents\\ZABUD CESANTIAS.pdf");

    }



    public void DeletePatient() throws IOException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(opcionEliminar));
        opcionEliminar.click();
        wait.until(ExpectedConditions.elementToBeClickable(razonEliminacion));
        razonEliminacion.clear();
        razonEliminacion.sendKeys("eliminar prueba");
        wait.until(ExpectedConditions.elementToBeClickable(Confirmar));
        Confirmar.click();
    }




}
