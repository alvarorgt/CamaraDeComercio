package com.qvision.camara.convenio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qvision.camara.convenio.keys.KeyWords;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://presprivqas1.ccb.org.co/simasc/#/app/Arbitraje/TRANSF009")

public class MainPage extends PageObject {

	KeyWords Key = new KeyWords();
	
	WebDriver driver = getDriver();

	@FindBy(xpath = "//*[@id=\"app\"]/nav[2]/div/div/div/div/div[2]/ul/li[2]/a/a[1]")
	WebElement listProfile;

	@FindBy(xpath = "//*[@id=\"app\"]/nav[2]/div/div/div/div/div[2]/ul/li[2]/ul/li[6]/a")
	WebElement txtProfile;

	@FindBy(xpath = "//*[@id=\"TRANSF009\"]")
	WebElementFacade lblValidatetwo;

	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[1]/ul[3]/li[4]/a")
	WebElementFacade btnConciliacion;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]")
	WebElementFacade btnRadicarCaso;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[1]/div/label")
	WebElement lblRadicarCaso;

	@FindBy(xpath = "//*[@id=\"carga\"]/div[1]")
	WebElement elementCarga;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[1]/div/select")
	WebElementFacade listConvenio;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[2]/div/input")
	WebElement txtHechos;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[3]/div/input")
	WebElement txtPretensiones;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[4]/div/select")
	WebElementFacade listTipoDeCuantia;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[5]/div/label")
	WebElement lblCuantia;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[5]/div/input")
	WebElement txtCuantia;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[6]/div/select")
	WebElementFacade listInicioElConflicto;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[7]/div/select")
	WebElementFacade listLugarDelConflicto;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[8]/div/select")
	WebElementFacade listQuienSolicita;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[9]/div/select")
	WebElementFacade listMateria;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[10]/div/select")
	WebElementFacade listConciliadores;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[11]/div/select")
	WebElementFacade listTipoDeAudiencia;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[12]/div/select")
	WebElementFacade listSede;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[13]/div[1]/div/label")
	WebElement lblCargandoAgendamiento;

	@FindBy(xpath = "//*[@id=\"q-datepicker_3\"]/input")
	WebElementFacade btnFecha;

	@FindBy(xpath = "/html/body/div[2]")
	WebElement calendarioConciliacion;

	@FindBy(xpath = "/html/body/div[2]/div[1]/table/thead/tr[2]/th[1]")
	WebElement btnCalendarioBack;

	@FindBy(xpath = "/html/body/div[2]/div[1]/table/thead/tr[2]/th[3]")
	WebElement btnCalendarioForward;

	@FindBy(xpath = "/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]")
	WebElementFacade btnCalendarioMonth;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[13]/div[2]/div/select")
	WebElementFacade btnHoraDeAudiencia;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[13]/div[4]/div/div[2]/button")
	WebElement btnContinuar;

	@FindBy(xpath = "//*[@id=\"CONF107RadicarCasoConvenio\"]/div/section/form/div[13]/div[2]/div/select/option[2]")
	WebElement txtHoraDeAudiencia;

	boolean cargandoAgendamiento = true;
	boolean esperaCalendario = false;
	int month3;
	

	public void process(String convenio, String hechos, String pretensiones, String tipoDeCuantia, String cuantia,
			String inicioDelConflicto, String lugarDelConflicto, String quienSolicita, String materia,
			String conciliador, String tipoDeAudiencia, String sede, String fechaIngresada) {
		WebDriver driver = getDriver();
		waitFor(lblRadicarCaso).isCurrentlyVisible();
		Key.screenShot(driver);
		listConvenio.selectByVisibleText(convenio);
		txtHechos.sendKeys(hechos);
		txtPretensiones.sendKeys(pretensiones);
		listTipoDeCuantia.selectByVisibleText(tipoDeCuantia);
		waitFor(lblCuantia).isVisible();
		txtCuantia.sendKeys(cuantia);
		listInicioElConflicto.selectByVisibleText(inicioDelConflicto);
		listLugarDelConflicto.selectByVisibleText(lugarDelConflicto);
		listQuienSolicita.selectByVisibleText(quienSolicita);
		listMateria.selectByVisibleText(materia);
		listConciliadores.selectByVisibleText(conciliador);
		listTipoDeAudiencia.selectByVisibleText(tipoDeAudiencia);
		listSede.selectByVisibleText(sede);
		waitFor(lblCargandoAgendamiento).isCurrentlyVisible();
		btnFecha.click();
		Key.recorrerCalendario(driver, fechaIngresada);
		String hora = txtHoraDeAudiencia.getText();
		btnHoraDeAudiencia.selectByVisibleText(hora);
		Key.screenShot2(driver);
		btnContinuar.click();
	}

	public void selectOption() {
		
		for (int i = 0; i < 7; i++)
			waitFor(listProfile).isClickable();
		listProfile.click();
		txtProfile.click();
		waitFor(lblValidatetwo).isCurrentlyVisible();
		btnConciliacion.click();
		waitFor(btnRadicarCaso).isClickable();
		btnRadicarCaso.click();
		
	}
}
