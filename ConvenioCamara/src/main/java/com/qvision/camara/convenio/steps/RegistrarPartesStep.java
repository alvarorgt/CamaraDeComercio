package com.qvision.camara.convenio.steps;

import java.io.IOException;

import com.qvision.camara.convenio.pages.RegistrarPartesPage;

import net.thucydides.core.annotations.Step;

public class RegistrarPartesStep {

	RegistrarPartesPage pageRegistrarPartes;

	@Step
	public void registrarInformacion(String tipoDePersona, String rol, String tipoDeIdentificacion,
			String numeroDeIdentificacion, String nacionalidad, String ciudadDeIdentificacion, String nombre,
			String apellido, String email, String sexo) {
		pageRegistrarPartes.registrarInformacion(tipoDePersona, rol, tipoDeIdentificacion, numeroDeIdentificacion,
				nacionalidad, ciudadDeIdentificacion, nombre, apellido, email, sexo);

	}

	@Step
	public void continuar() {
		pageRegistrarPartes.continuar();
	}

	@Step
	public void esperar() throws IOException {
		pageRegistrarPartes.espera();
	}

}
