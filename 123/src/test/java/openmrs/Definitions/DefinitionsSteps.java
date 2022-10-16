package openmrs.Definitions;

import openmrs.Paginas.FindPatientRecord;
import openmrs.Paginas.Home;
import openmrs.Paginas.LogIn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import openmrs.Paginas.RegisterPatient;
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
	@And("^iniciar sesión$")
	public void iniciar_sesión() throws IOException {
		this.logIn = new LogIn(driver);
		this.logIn.IniciarSesion();
	}
	@Then("^validar sesión$")
	public void validar_sesión() throws IOException {
		this.logIn = new LogIn(driver);
		logIn.ValidarLogin();
	}
	@And("^Cerrar sesion$")
	public void Cerrar_sesionn() throws IOException {
		this.home = new Home(driver);
		home.Cerrarsesion();
	}
	@Then("^validar cierre sesión$")
	public void valida_cierre_sesión() throws IOException {
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

	@And("^Confirmar creación$")
	public void Confirmar_creación() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.registerPatient.ConfirmCreacion();
	}

	@Then("^Validar ID cliente Creado$")
	public void validar_id_cliente_creado() throws IOException {
		this.registerPatient = new RegisterPatient(driver);
		this.findPatientRecord = new FindPatientRecord(driver);
		this.registerPatient.PatientNumber();
		this.registerPatient.ImprimerID();
		this.findPatientRecord.ImprimirID();

	}
	@And("^Buscar paciente$")
	public void buscar_paciente() throws IOException {
	this.findPatientRecord = new FindPatientRecord(driver);
	this.findPatientRecord.BuscarPaciente();


	}



}