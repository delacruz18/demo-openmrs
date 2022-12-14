package openmrs.Definitions;

import openmrs.Paginas.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import openmrs.Steps.*;
import io.cucumber.java.en.Given;
import java.io.IOException;


public class DefinitionsSteps {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private Questions questions;
	private LogIn logIn;
	private Home home;
	private RegisterPatient registerPatient;
	private FindPatientRecord findPatientRecord;
	private MedicalRecord medicalRecord;
	private Operaciones operaciones;

	

	@Given("^abrir el navegador$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();
	}
	@When("^Diligenciar credenciasles$")
	public void diligenciar_credenciasles() throws IOException {
		this.logIn = new LogIn(driver);
		this.logIn.Credenciales();
	}
	@And("^seleccionar location$")
	public void seleccionar_location() throws IOException {
		this.logIn = new LogIn(driver);
		this.logIn.Seleccionarlocation();
	}
	@And("^iniciar sesion")
	public void iniciar_sesion() throws IOException {
		this.logIn = new LogIn(driver);
		this.logIn.IniciarSesion();
	}
	@Then("^validar sesion")
	public void validar_sesion() throws IOException {
		this.logIn = new LogIn(driver);
		logIn.ValidarLogin();
	}
	@And("^Cerrar sesion$")
	public void Cerrar_sesionn() throws IOException {
		this.home = new Home(driver);
		home.Cerrarsesion();
	}
	@Then("^validar cierre sesion")
	public void valida_cierre_sesion() throws IOException {
		this.home = new Home(driver);
		home.Validar_cierre();
	}
	@When("^Seleccionar registrar paciente$")
	public void Seleccionar_registrar_pacientes() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.registerPatient.Iniiciar_registro();
	}
	@And("^Ingresar Datos  Demographics$")
	public void ingresar_datos_demographics() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.registerPatient.DatosDemograficos();
		this.registerPatient.databirthdate();
	}
	@And("^Ingresar Datos Contac Info$")
	public void ingresar_datos_contac_info() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.registerPatient.ContactInfoAddres();
		this.registerPatient.ContactInfophoneNumber();
	}
	@And("^Ingresar Datos Relationship$")
	public void ingresar_datos_relationship() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.registerPatient.ContactInfoprelatives();
	}

	@And("^Confirmar creaci??n$")
	public void Confirmar_creaci??n() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.registerPatient.ConfirmCreacion();
	}

	@Then("^Validar ID cliente Creado$")
	public void validar_id_cliente_creado() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.registerPatient.PatientNumber();

	}
	@And("^Buscar paciente$")
	public void buscar_paciente() throws IOException, InterruptedException {
	this.findPatientRecord = new FindPatientRecord(driver);
	this.findPatientRecord.BuscarPaciente();
	}

	@Then("^Validar Datos$")
	public void Validar_Datos() throws IOException {
		this.medicalRecord = new MedicalRecord(driver);
		this.medicalRecord.ValidarDatos();
	}

	@When("^Crear cita$")
	public void Crear_cita() throws IOException {
		this.operaciones = new Operaciones(driver);
		this.operaciones.CrearAppoiment();

	}

	@Then("^Validar cita$")
	public void Validar_cita() throws IOException {
		this.operaciones = new Operaciones(driver);
		this.operaciones.ValidaAppoint();
	}

	@When("^Adjuntar Soporte$")
	public void Adjuntar_Soporte() throws IOException {
		this.operaciones = new Operaciones(driver);
		//this.operaciones.AdjuntarDocumento();
	}

	@When("^Eliminar paciente$")
	public void Eliminar_paciente() throws IOException {
		this.operaciones = new Operaciones(driver);
		this.operaciones.DeletePatient();
	}
	@Then("^Validar borrado$")
	public void Validar_borrado()  {
		this.questions = new Questions();
		this.questions.SearchAssert(driver);
	}


}