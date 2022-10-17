#Proyecto de pruebas 123
#12/01/2022
#Carlos De la Cruz
Feature: Pruebas Generales demo openmrs
	# este proyecto consta de multiples escenarios para comprobar la creación y eliminación de un paciente
	#  en la pagina https://demo.openmrs.org/openmrs/
	# de momento no fue posible adjuntar documentos en la ejecución debido a como fue desarrollada la pagina

@tag1
Scenario: Inicio de sesion
	Given abrir el navegador
	When  Diligenciar credenciasles
	And   seleccionar location
	And   iniciar sesion
	Then  validar sesion

	@tag2
	Scenario: Cierre de sesion
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesion
		And   Cerrar sesion
		Then  validar cierre sesion

	@tag3
	Scenario: Register a Patient
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesion
		When  Seleccionar registrar paciente
		And   Ingresar Datos  Demographics
		And   Ingresar Datos Contac Info
		And   Ingresar Datos Relationship
		And   Confirmar creación
		Then  Validar ID cliente Creado


	@tag4
	Scenario: Buscar a Patient
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesion
		And   Buscar paciente


	@tag5
	Scenario: Validar Info del Paciente
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesion
		And   Buscar paciente
		Then Validar Datos

	@tag6
	Scenario: Crear cita
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesion
		And   Buscar paciente
		When   Crear cita
		Then  Validar cita

	@tag7
	Scenario: Crear cita
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesion
		And   Buscar paciente
		When  Adjuntar Soporte



	@tag8
	Scenario: Eliminar Paciente
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesion
		And   Buscar paciente
		When  Eliminar paciente
		Then Validar borrado


