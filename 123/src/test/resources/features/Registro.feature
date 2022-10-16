#Proyecto de pruebas 123
#12/01/2022
#Carlos De la Cruz
Feature: Pruebas Generales demo openmrs

@tag1
Scenario: Inicio de sesion
	Given abrir el navegador
	When  Diligenciar credenciasles
	And   seleccionar location
	And   iniciar sesión
	Then  validar sesión

	@tag2
	Scenario: Cierre de sesion
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesión
		And   Cerrar sesion
		Then  validar cierre sesión

	@tag3
	Scenario: Register a Patient
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesión
		When  Seleccionar registrar paciente
		And   Ingresar Datos  Demographics
		And   Ingresar Datos Contac Info
		And   Ingresar Datos Relationship
		And   Confirmar creación
		Then  Validar ID cliente Creado


	@tag4
	Scenario: Register a Patient
		Given abrir el navegador
		When  Diligenciar credenciasles
		And   seleccionar location
		And   iniciar sesión
		And   Buscar paciente

