package com.qvision.camara.convenio.steps;

import com.qvision.camara.convenio.pages.MainPage;

import net.thucydides.core.annotations.Step;

public class MainStep {

	MainPage pageMain;

	@Step
	public void selectOption() {
		pageMain.selectOption();
	}

	@Step
	public void process(String convenio, String hechos, String pretensiones, String tipoDeCuantia, String cuantia,
			String inicioDelConflicto, String lugarDelConflicto, String quienSolicita, String materia,
			String conciliador, String tipoDeAudiencia, String sede, String fechaIngresada) {
		pageMain.process(convenio, hechos, pretensiones, tipoDeCuantia, cuantia, inicioDelConflicto, lugarDelConflicto,
				quienSolicita, materia, conciliador, tipoDeAudiencia, sede, fechaIngresada);
	}

}
