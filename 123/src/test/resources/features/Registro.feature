#Proyecto de pruebas 123
#12/01/2022
#Carlos De la Cruz
Feature: Pruebas Generales demo openmrs

@tag1
Scenario: Inicio de sesion
	Given abrir el navegador
	When Diligenciar credenciasles
	And seleccionar location
	And iniciar sesión
	Then validar sesión

	@tag2
	Scenario: Inicio de sesion
		Given abrir el navegador
		When Diligenciar credenciasles
		And seleccionar location
		And iniciar sesión
		And Cerrar sesion
		Then validar cierre sesión
