package com.qvision.camara.convenio.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qvision.camara.convenio.keys.KeyWords;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://presprivqas1.ccb.org.co/simasc/#/app/Conciliacion/CONF113")

public class RegistrarPartesPage extends PageObject {

	KeyWords Key = new KeyWords();
	
	WebDriver driver = getDriver();
	
	@FindBy(xpath = "//*[@id=\"tipoPersona-select\"]")
	WebElementFacade listTipoDePersona;

	@FindBy(xpath = "//*[@id=\"rol-select\"]")
	WebElementFacade listRol;

	@FindBy(xpath = "//*[@id=\"tipoIdentificacion-select\"]")
	WebElementFacade listTipoDeIdentificacion;

	@FindBy(xpath = "//*[@id=\"numeroIdentificacion-input\"]")
	WebElement txtNumeroDeIdentificacion;

	@FindBy(xpath = "//*[@id=\"nacionalidad-select\"]")
	WebElementFacade listNacionalidad;

	@FindBy(xpath = "//*[@id=\"ciudadIdentificacion-select\"]")
	WebElementFacade listCiudadDeIdentificacion;

	@FindBy(xpath = "//*[@id=\"primerApellidoORazonSocial-input\"]")
	WebElementFacade txtNombre;

	@FindBy(xpath = "//*[@id=\"primerNombre-input\"]")
	WebElement txtApellido;

	@FindBy(xpath = "//*[@id=\"emailUno-input\"]")
	WebElement txtEmail;

	@FindBy(xpath = "//*[@id=\"tipoSexo-select\"]")
	WebElementFacade listSexo;

	@FindBy(xpath = "//*[@id=\"CONF113buttonAdicionar\"]")
	WebElement btnAdicionar;

	@FindBy(xpath = "//*[@id=\"CONF113buttonContinuar\"]")
	WebElement btnContinuar;

	@FindBy(xpath = "//*[@id=\"divMensaje\"]/strong")
	WebElement lblVaidate;

	@FindBy(xpath = "//*[@id=\"CONF113divTipoPersonaYSeleccionar\"]/label")
	WebElement lblTipoDePersona;

	@FindBy(xpath = "//*[@id=\"CONF113divConsultaPartesCaso\"]/div/div/div/div/section/div/table/tbody/tr/td[1]")
	WebElement lblRegistro;

	@FindBy(xpath = "//*[@id=\"CONF113div\"]/div[1]/label")
	WebElementFacade lblNombre;


	public void registrarInformacion(String tipoDePersona, String rol, String tipoDeIdentificacion,
			String numeroDeIdentificacion, String nacionalidad, String ciudadDeIdentificacion, String nombre,
			String apellido, String email, String sexo) {
		WebDriver driver = getDriver();
		waitFor(lblTipoDePersona).isCurrentlyVisible();
		listTipoDePersona.selectByVisibleText(tipoDePersona);
		waitFor(txtNombre).isClickable();
		waitFor(txtApellido).isClickable();
		listRol.selectByVisibleText(rol);
		listTipoDeIdentificacion.selectByVisibleText(tipoDeIdentificacion);
		txtNumeroDeIdentificacion.sendKeys(numeroDeIdentificacion);
		listNacionalidad.selectByVisibleText(nacionalidad);
		listCiudadDeIdentificacion.selectByVisibleText(ciudadDeIdentificacion);
		for (int i = 1; i < 16; i++)
			waitFor(txtNombre).clear();
		txtNombre.sendKeys(nombre);
		waitFor(txtApellido).clear();
		txtApellido.sendKeys(apellido);
		waitFor(txtEmail).clear();
		txtEmail.sendKeys(email);
		waitFor(listSexo).selectByVisibleText(sexo);
		Key.screenShot2(driver);
		btnAdicionar.click();
		Key.screenShot(driver);
		waitFor(lblRegistro).isCurrentlyVisible();
		

	}

	public void continuar() {

		btnContinuar.click();

	}

	public void espera() throws IOException {
		WebDriver driver = getDriver();
		waitFor(lblVaidate).isCurrentlyVisible();
		String radicacion = lblVaidate.getText();
		System.out.println(radicacion);
		Key.screenShot(driver);
		Key.crearExcel();

	}

}
