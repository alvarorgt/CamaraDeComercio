# encoding: iso-8859-1
Feature: Create radication agreement on principal page
		I Want to create a radication agreement for users with profile Aux.Administrativo
	
	Scenario: Radication Successful
		Given On principal page login with user with profile Aux.Administrativo	
				|user	 |pass	   |	
				|52310301|Cartuja03|
		When I select the option of convenios 
				
		And I complete the form
		|convenio			 |hechos|pretensiones		   |tipoDeCuantia|cuantia|inicioDelConflicto	       |lugarDelConflicto|quienSolicita	|materia   	        |conciliador				   |tipoDeAudiencia|sede		  |fechaIngresada|
		|MAPFRE COLOMBIA S.A.|Prueba|Prueba de Pretensiones|Determinada	 |2500000|De 1 a 30 días (Hasta 1 mes).|BOGOTA D.C.		 |Las dos partes|Derecho Civil      |MÓNICA CONSUELO DELGADO ORTIZ |Presencial     |SEDE CHAPINERO|2019/04/04    |
		And complete the register the convocante
		|tipoDePersona|rol		 |tipoDeIdentificacion|numeroDeIdentificacion|nacionalidad|ciudadDeIdentificacion|nombre	|apellido|email			  |sexo         |
		|Natural	  |Convocante|Nit				  |1569788436			 |COLOMBIA	  |BOGOTA D.C.			 |Ricardo	|Franco  |franco@gmail.com|Indeterminado|
		And complete the register the Convocado
		|tipoDePersona|rol		 |tipoDeIdentificacion|numeroDeIdentificacion|nacionalidad|ciudadDeIdentificacion|nombre	|apellido|email		     |sexo         |
		|Natural	  |Convocado |Nit				  |456988235			 |COLOMBIA	  |BOGOTA D.C.			 |Alvaro	|Fayad   |fayad@gmail.com|Masculino    |	
				
		Then I should execute all process for create a radication of agreement and get a number of radicate 
		