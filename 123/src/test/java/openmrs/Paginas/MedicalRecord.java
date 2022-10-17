package openmrs.Paginas;

import openmrs.Steps.Botones;
import openmrs.Steps.Questions;
import org.junit.Assert;
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

    @FindBy(how = How.XPATH, using = "//body/ul[@id='breadcrumbs']/li[2]")
    private WebElement NombreCompleto;



    @FindBy(how = How.XPATH, using = "//span[@class='PersonName-givenName']")
    private WebElement FirstName;

    @FindBy(how = How.XPATH, using = "//span[@class='PersonName-familyName']")
    private WebElement familyName;

    @FindBy(how = How.XPATH, using = "//div[@class='gender-age col-auto']//span[2]")
    private WebElement Sexo;
    @FindBy(how = How.CSS, using = "#coreapps-telephoneNumber")
    private WebElement Telefono;
    @FindBy(how = How.XPATH, using = "//div[@id='contactInfoContent']//div")
    private WebElement Direccionp;

    @FindBy(how = How.XPATH, using = "//div[@class='float-sm-right']/span")
    private WebElement IDDelPAciente;



    public void ValidarDatos () throws IOException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.elementToBeClickable(showContactInfo));
        //showContactInfo.click();
        //wait.until(ExpectedConditions.visibilityOf(Telefono));
        String name1 = registerPatient.name;  //String del nombre con el que se creó al paciente
        String LastName1 = registerPatient.LastName;//String del Apellido con el que se creó al paciente
        String Dir = registerPatient.Direccion;//String de la direeción con el que se creó al paciente
        String Cel = registerPatient.NumeroTelefono;//String del Telefono con el que se creó al paciente

        String name2 = FirstName.getText();// se toma el texto del elemento que contiene el nombre del paciente la ventana de infomación
        String Apellidos = familyName.getText();// se toma el texto del elemento que contiene el nombre del Apellido la ventana de infomación
        String Celular = Telefono.getAttribute("textContent").replaceAll("\\s", "");// es necesario eliminar saltos de linea y espacios
        String DirInfo = Direccionp.getAttribute("textContent").trim().substring(0, 11);// se acoorta el texo que contienen lla dirección en info del paciente
        String CompletoNombre = NombreCompleto.getText(); // se toma el texto del elemento que contiene el nombre completo  del paciente la ventana de infomación
        String espacio = " ";
        String NombreCompleto2 = name2 + espacio + Apellidos;// es necesario concatenar nombre y apellidos de creación para obtener nombre completo

        try {
            if ((name1.equals(name2)) && (LastName1.equals(Apellidos)) && (Cel.equals(Celular))
                    && (Dir.equals(DirInfo)) && NombreCompleto2.equals(CompletoNombre)) {
                System.out.println(" Todo OK");

            } else { // se imprimen los valores comparados con la idea de validar las diferencias entre ellos
                System.out.println(name1 + "\n" + name2);
                System.out.println(LastName1 + "\n" + Apellidos);
                System.out.println(Cel + "\n" + Celular);
                System.out.println(Dir + "\n" + DirInfo);
                System.out.println(NombreCompleto2 + "\n" + CompletoNombre);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();// se imprime el error arrojado
        }
    }

    }

