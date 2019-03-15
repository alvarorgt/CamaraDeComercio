package com.qvision.camara.convenio.keys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class KeyWords {
	WebElement txtFechaCalendario;
	WebElement txtDiaCalendario;
	WebElement btnSiguienteMes;

	public int numeroDelMes(String mes) {
		int numberMonthA = 0;
		switch (mes) {// Convierte los meses del calendario en enteros
		case "Enero":
			numberMonthA = 1;
			break;
		case "Febrero":
			numberMonthA = 2;
			break;
		case "Marzo":
			numberMonthA = 3;
			break;
		case "Abril":
			numberMonthA = 4;
			break;
		case "Mayo":
			numberMonthA = 5;
			break;
		case "Junio":
			numberMonthA = 6;
			break;
		case "Julio":
			numberMonthA = 7;
			break;
		case "Agosto":
			numberMonthA = 8;
			break;
		case "Septiembre":
			numberMonthA = 9;
			break;
		case "Octubre":
			numberMonthA = 10;
			break;
		case "Noviembre":
			numberMonthA = 11;
			break;
		case "Diciembre":
			numberMonthA = 12;
			break;
		}

		return numberMonthA;
	}

	public void recorrerCalendario(WebDriver driver, String fechaIngresada) {

		txtFechaCalendario = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]"));
		String fechaDelCalendario = txtFechaCalendario.getText();
		String[] dateAParts = fechaDelCalendario.split("\\s+");
		String mesDelCalendario = dateAParts[0];
		// int añoDelCalendarioA = Integer.parseInt(dateAParts[1]);
		int mesDelCalendarioNumero = numeroDelMes(mesDelCalendario);

		// Lo ingresa en el feature
		String[] dateIParts = fechaIngresada.split("\\/");
		// int dateYear = Integer.parseInt(dateIParts[0]);
		int dateMonth = Integer.parseInt(dateIParts[1]);
		int dateDay = Integer.parseInt(dateIParts[2]);

		if (mesDelCalendarioNumero == dateMonth || dateMonth == (mesDelCalendarioNumero + 1)) {
			if (dateMonth == (mesDelCalendarioNumero + 1)) {
				btnSiguienteMes = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[3]"));
				btnSiguienteMes.click();
			}

			for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 7; j++) {

					txtDiaCalendario = driver
							.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[" + i + "]/td[" + j + "]"));
					int diaDelCalendario = Integer.parseInt(txtDiaCalendario.getText());
					if (diaDelCalendario == dateDay) {
						String attribute = txtDiaCalendario.getAttribute("class"); // leer el atributo del elemento
																					// en la posicion i j
						if (attribute.equals("day")) {
							txtDiaCalendario.click();
						}

					}

				}
			}
		}
	}

	public void screenShot(WebDriver driver) {
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("Evidencia\\" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR EN SS!!!");
		}
	}

	public void borrarArchivos() {
		String sDirectorio = "Evidencia";
		File f = new File(sDirectorio);

		File[] ficheros = f.listFiles();

		for (int x = 0; x < ficheros.length; x++) {
			ficheros[x].delete();
		}
	}

	public void crearExcel() throws IOException {

		String sDirectorio = "Evidencia";
		// Crea un File de la carpeta
		File f = new File(sDirectorio);
		// Crea un arreglo con todas las imagenes
		File[] ficheros = f.listFiles();
		int j = 1;// Para definir la fila del excel
		// Crea el archivo y la Hoja
		XSSFWorkbook my_workbook = new XSSFWorkbook();
		XSSFSheet my_sheet = my_workbook.createSheet("CONVENIO");
		for (int i = 0; i < ficheros.length; i++) {
			// Lee el archivo
			InputStream my_banner_image = new FileInputStream(ficheros[i]);
			byte[] bytes = IOUtils.toByteArray(my_banner_image);
			int my_picture_id = my_workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
			my_banner_image.close();
			String nombre = ficheros[i].toString();
			// Crea el icono para obtener el tamaño de la imagen
			ImageIcon icono = new ImageIcon(nombre);
			int alto = icono.getIconHeight();
			XSSFDrawing drawing = my_sheet.createDrawingPatriarch();
			XSSFClientAnchor my_anchor = new XSSFClientAnchor();
			my_anchor.setCol1(1);
			my_anchor.setRow1(j);
			XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
			my_picture.resize();
			j = j + (alto / 19);
		}
		// Escribe el .xlsx
		FileOutputStream out = new FileOutputStream(
				new File("ExcelFile\\Convenio" + System.currentTimeMillis() + ".xlsx"));
		my_workbook.write(out);
		out.close();
		my_workbook.close();

	}

	public void screenShot2(WebDriver driver) {
		try {

			Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);
			ImageIO.write(fpScreenshot.getImage(), "PNG",
					new File("Evidencia\\" + System.currentTimeMillis() + "full" + ".png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
