package com.qvision.camara.convenio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qvision.camara.convenio.keys.KeyWords;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://presprivqas1.ccb.org.co/simasc/#/login")

public class LogInPage extends PageObject {

	@FindBy(xpath = "//*[@id=\"loginWidget\"]/div/form/div[1]/input")
	WebElementFacade txtUser;

	@FindBy(xpath = "//*[@id=\"loginWidget\"]/div/form/div[2]/input")
	WebElement txtPass;

	@FindBy(xpath = "//*[@id=\"loginButton\"]")
	WebElement btnLogin;

	@FindBy(xpath = "//*[@id=\"loginWidget\"]/header/h3")
	WebElementFacade lblValidate;

	@FindBy(xpath = "//*[@id=\"carga\"]/div[2]/div[2]")
	WebElement elementCarga;
	
	KeyWords Key = new KeyWords();
	
	WebDriver driver = getDriver();

	public void logIn(String user, String pass) {
		WebDriver driver = getDriver();
		Key.borrarArchivos();
		waitFor(ExpectedConditions.visibilityOf(txtUser));
		txtUser.sendKeys(user);
		txtPass.sendKeys(pass);
		Key.screenShot(driver);
		btnLogin.click();
		
	}

}
