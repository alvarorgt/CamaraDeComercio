package com.qvision.camara.convenio.stepsdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.qvision.camara.convenio.steps.LogInStep;
import com.qvision.camara.convenio.steps.MainStep;
import com.qvision.camara.convenio.steps.RegistrarPartesStep;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConvenioStepsDefinitions {

	@Steps
	LogInStep stepPrincipal;
	@Steps
	MainStep stepMain;
	@Steps
	RegistrarPartesStep stepRegistrarPartes;

	@Given("^On principal page login with user with profile Aux\\.Administrativo$")
	public void onPrincipalPageLoginWithUserWithProfileAuxAdministrativo(DataTable arg1) {
		stepPrincipal.openurl();
		List<Map<String, String>> listData = arg1.asMaps(String.class, String.class);
		String username = listData.get(0).get("user");
		String password = listData.get(0).get("pass");
		stepPrincipal.logIn(username, password);
	}

	@When("^I select the option of convenios$")
	public void iSelectTheOptionOfConvenios() {
		stepMain.selectOption();

	}

	@When("^I complete the form$")
	public void iCompleteTheForm(DataTable arg1) {
		List<Map<String, String>> listData2 = arg1.asMaps(String.class, String.class);
		String convenio = listData2.get(0).get("convenio");
		String hechos = listData2.get(0).get("hechos");
		String pretensiones = listData2.get(0).get("pretensiones");
		String tipoDeCuantia = listData2.get(0).get("tipoDeCuantia");
		String cuantia = listData2.get(0).get("cuantia");
		String inicioDelConflicto = listData2.get(0).get("inicioDelConflicto");
		String lugarDelConflicto = listData2.get(0).get("lugarDelConflicto");
		String quienSolicita = listData2.get(0).get("quienSolicita");
		String materia = listData2.get(0).get("materia");
		String conciliador = listData2.get(0).get("conciliador");
		String tipoDeAudiencia = listData2.get(0).get("tipoDeAudiencia");
		String sede = listData2.get(0).get("sede");
		String fechaIngresada = listData2.get(0).get("fechaIngresada");
		stepMain.process(convenio, hechos, pretensiones, tipoDeCuantia, cuantia, inicioDelConflicto, lugarDelConflicto,
				quienSolicita, materia, conciliador, tipoDeAudiencia, sede, fechaIngresada);
	}

	@When("^complete the register the convocante$")
	public void completeTheRegisterTheConvocante(DataTable arg1) {
		List<Map<String, String>> listDataConvocante = arg1.asMaps(String.class, String.class);
		String tipoDePersona = listDataConvocante.get(0).get("tipoDePersona");
		String rol = listDataConvocante.get(0).get("rol");
		String tipoDeIdentificacion = listDataConvocante.get(0).get("tipoDeIdentificacion");
		String numeroDeIdentificacion = listDataConvocante.get(0).get("numeroDeIdentificacion");
		String nacionalidad = listDataConvocante.get(0).get("nacionalidad");
		String ciudadDeIdentificacion = listDataConvocante.get(0).get("ciudadDeIdentificacion");
		String nombre = listDataConvocante.get(0).get("nombre");
		String apellido = listDataConvocante.get(0).get("apellido");
		String email = listDataConvocante.get(0).get("email");
		String sexo = listDataConvocante.get(0).get("sexo");
		stepRegistrarPartes.registrarInformacion(tipoDePersona, rol, tipoDeIdentificacion, numeroDeIdentificacion,
				nacionalidad, ciudadDeIdentificacion, nombre, apellido, email, sexo);
	}

	@When("^complete the register the Convocado$")
	public void completeTheRegisterTheConvocado(DataTable arg1) {
		List<Map<String, String>> listDataConvocado = arg1.asMaps(String.class, String.class);
		String tipoDePersona = listDataConvocado.get(0).get("tipoDePersona");
		String rol = listDataConvocado.get(0).get("rol");
		String tipoDeIdentificacion = listDataConvocado.get(0).get("tipoDeIdentificacion");
		String numeroDeIdentificacion = listDataConvocado.get(0).get("numeroDeIdentificacion");
		String nacionalidad = listDataConvocado.get(0).get("nacionalidad");
		String ciudadDeIdentificacion = listDataConvocado.get(0).get("ciudadDeIdentificacion");
		String nombre = listDataConvocado.get(0).get("nombre");
		String apellido = listDataConvocado.get(0).get("apellido");
		String email = listDataConvocado.get(0).get("email");
		String sexo = listDataConvocado.get(0).get("sexo");
		stepRegistrarPartes.registrarInformacion(tipoDePersona, rol, tipoDeIdentificacion, numeroDeIdentificacion,
				nacionalidad, ciudadDeIdentificacion, nombre, apellido, email, sexo);
		stepRegistrarPartes.continuar();

	}

	@Then("^I should execute all process for create a radication of agreement and get a number of radicate$")
	public void iShouldExecuteAllProcessForCreateARadicationOfAgreementAndGetANumberOfRadicate() throws IOException {
		stepRegistrarPartes.esperar();

	}

}
