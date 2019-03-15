package com.qvision.camara.convenio.steps;

import com.qvision.camara.convenio.pages.LogInPage;

import net.thucydides.core.annotations.Step;

public class LogInStep {

	LogInPage pagePrincipal;

	@Step
	public void openurl() {
		pagePrincipal.open();
	}

	@Step
	public void logIn(String user, String pass) {
		pagePrincipal.logIn(user, pass);
	}
}
