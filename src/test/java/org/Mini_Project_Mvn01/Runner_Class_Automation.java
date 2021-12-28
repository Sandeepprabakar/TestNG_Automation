package org.Mini_Project_Mvn01;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.POMclass.Page_Object_Manager_Automation;
import com.baseclass.Base_Class;
import com.helper.File_Reader_Manager;
import com.pom1.Address;
import com.pom1.Evening_Dress;
import com.pom1.Login;
import com.pom1.Order;
import com.pom1.Payment;
import com.pom1.Shipping;
import com.pom1.printeddress;

public class Runner_Class_Automation extends Base_Class {
	static Logger log = Logger.getLogger(Runner_Class_Automation.class);
	public static WebDriver driver = browserlaunch("chrome");

	public static Page_Object_Manager_Automation pom = new Page_Object_Manager_Automation(driver);

	public static void main(String[] args) throws Throwable {
		PropertyConfigurator.configure("log4j.properties");

		String url = File_Reader_Manager.filereadermanager().configurationreader().geturl();

		url(url, "get");

		log.info("Session created");
		driver1("currenturl");

		wait(5);

		jsclick(pom.getLogin().getSignin(), "click");
		wait(5);
		String particulardata = Particulardata(
				"C:\\Users\\SIRISA B S\\eclipse-workspace\\Mini_Project_Mvn\\testcases.xlsx", 0, 10, 5);

		inputelement(pom.getLogin().getEmail(), particulardata);
		String particulardata2 = Particulardata(
				"C:\\Users\\SIRISA B S\\eclipse-workspace\\Mini_Project_Mvn\\testcases.xlsx", 0, 11, 5);

		inputelement(pom.getLogin().getPassword(), particulardata2);

		clickonelement(pom.getLogin().getSubmit());

		wait(10);
		log.info("Successfully logged in");
		jsclick(pom.getD2().getDresses(), "click");

		wait(6);

		jsclick(pom.getCd2().getCasualdress(), "click");
		wait(6);

		jsclick(pom.getPd2().getPrinteddress2(), "click");
		wait(6);

		jsclick(pom.getPd2().getAddtocart2(), "click");
		wait(6);
		jsclick(pom.getPd2().getContinue2(), "click");

		wait(6);

		jsclick(pom.getMs2().getMystore(), "click");
		wait(6);

		jsclick(pom.getTs2().getTshirts2(), "click");
		wait(6);

		jsclick(pom.getTs2().getAddtocart3(), "click");
		wait(6);

		jsclick(pom.getTs2().getContinue3(), "click");
		wait(6);
		jsclick(pom.getMs2().getMystore(), "click");
		wait(6);

		// WebElement women =
		// driver.findElement(By.xpath("//a[text()='Women']"));//a[text()='Women']
		// women.click();
		clickonelement(pom.getEveningdress().getWomen());
		wait(5);

		clickonelement(pom.getEveningdress().getDresses());
		wait(3);
		clickonelement(pom.getEveningdress().getEvening());
		wait(5);

		jsclick(pom.getEveningdress().getPrinteddress(), "click");

		wait(5);
		clickonelement(pom.getPrinteddress().getLarger());
		wait(8);

		clickonelement(pom.getPrinteddress().getClose());
		wait(8);

		for (int i = 0; i < 2; i++) {

			mouseaction(pom.getPrinteddress().getIcon(), "doubleclick");

		}
		dropdown(pom.getPrinteddress().getSize(), "index", "1");

		clickonelement(pom.getPrinteddress().getCart());

		Thread.sleep(8000);
		screenshot("automationpom1");

		wait(8);

		clickonelement(pom.getPrinteddress().getCheckout());
		Thread.sleep(10000);

		clickonelement(pom.getOrder().getCheckout());
		wait(10);

		clickonelement(pom.getAddress().getCheckout());

		wait(10);

		clickonelement(pom.getShipping().getRadiobutton());

		wait(6);

		clickonelement(pom.getShipping().getCheckout());
		wait(6);

		clickonelement(pom.getPayment().getPay());

		wait(4);
		clickonelement(pom.getPayment().getConfirm());
		log.fatal("Successfully booked");

		screenshot("automationmvn2");
		jsclick(pom.getPayment().getSignout(), "click");
		log.fatal("logged out");

	}

}
